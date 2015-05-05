package Calculator_ex;


class CalcRule implements PriotyRule{
	private PriotyRule higherRule;
	private String[] symbols;
	
	public CalcRule(String[] symbols, PriotyRule rule) {
		this.symbols = symbols;
		higherRule = rule;
	}
	
	String calc(String digA, String symbol, String digB){
		if (symbol.equals("+")){					
			return Calculator.add(digA, digB);
		}else if (symbol.equals("-")){
			return Calculator.minus(digA, digB);
		}else{
			return Calculator.multiply(digA, digB);
		}
	}

	public String calc(Expression expression){
		String digA =  higherRule.calc(expression);
		while(! expression.empty()){			
			String symbol = expression.get();
			if (isForMe(symbol) == true){
				digA = calc(digA, symbol, higherRule.calc(expression));
			}else{		
				expression.moveBack();
				break;
			}
		}
		return digA;
	}

	private boolean isForMe(String symbol) {
		for (int i = 0; i < symbols.length; i++){
			if (symbols[i].equals(symbol)){
				return true;
			}
		}
		return false;
	}
}