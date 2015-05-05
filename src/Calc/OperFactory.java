package Calc;

class Oper{
	public int prio = 0;
	private String content = null;
	
	Oper(String content, int prio){
		this.content = content;
		this.prio = prio;
	}
	public boolean noHigherThan(Oper top) {
		return this.prio <= top.prio;
	}
	@Override
	public String toString(){
		return content;
	}
}

public class OperFactory{
	private static final int BASE = 4;
	private int basePrio = 0;
	
	private int getRawPrio(String symbol) throws NoSuchFieldException{		
		if (symbol.equals("+") || symbol.equals("-")){
			return 1;
		}
		else if ((symbol.equals("/") || symbol.equals("*"))){
			return 2;
		}
		else if (symbol.equals("#")){
			return 0;
		}
		else{
			throw new NoSuchFieldException();
		}
	}
	
	private int getPrio(String symbol){		
		try {
			return basePrio * BASE + getRawPrio(symbol);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	OperFactory(int basePrio){
		this.basePrio = basePrio;
	}
	
	Oper instance(String str){
		return new Oper(str, getPrio(str));		
	}

	public void calcPrio(String elem) {
		if (elem.equals("(")){
			basePrio += 1;
		}else{
			basePrio -= 1;
		}
	}
}
