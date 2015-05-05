package Calc;

import java.util.Stack;


public class CalcProcess{
	private Stack<Integer> intStack;
	private Stack<Oper> operStack;
	OperFactory prio = new OperFactory(0);
	
	public CalcProcess() {
		intStack = new Stack<Integer>();
		operStack = new Stack<Oper>();
	}
	
	String Cacl(String str){
		try {
			return Cacl(new ExpressionChain(str + "#"));
		} catch (InputErrorException e) {
			e.printStackTrace();
		}
		return "Input Error";
	}
	
	String Cacl(ExpressionChain expressionChain) throws InputErrorException
	{	
		while (!expressionChain.empty()){
			Element elem = expressionChain.get();
			if (elem.isDig()){
				intStack.push(Integer.valueOf(elem.toString())) ;
			}else if (elem.isBracket()){
				prio.calcPrio(elem.toString());
			}else if (elem.isOper()){
				Oper oper = prio.instance(elem.toString());
				pushOper(oper);
			}else{
				throw new InputErrorException();
			}
		}
		return getResult();
	}

	String getResult(){
		assert(intStack.size() == 1);
		return String.valueOf(intStack.pop());
	}
	
	void pushOper(Oper oper){
		while (!operStack.empty() && oper.noHigherThan( operStack.lastElement())){
			int num1 = intStack.pop();
			int num2 = intStack.pop();
			Expression exp = new Expression(num2, operStack.pop().toString(), num1);
			intStack.push(exp.calc());
		}
		operStack.push(oper);
	}
}