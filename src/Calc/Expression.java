package Calc;

public class Expression {
	int value1;
	int value2;
	String symbol = null;
	
	public Expression(Integer value1, String symbol, Integer value2) {
		this.value1 = value1;
		this.value2 = value2;
		this.symbol = symbol;
		System.out.println(this.value1 + this.symbol + this.value2);
	}

	public int calc() {
		if (symbol.equals("+")){
			return  value1 + value2;
		}
		else if (symbol.equals("-")){
			return value1 - value2;
		}
		else if(symbol.equals("*")){
			return value1 * value2;
		}
		else if (symbol.equals("/")){
			return value1 / value2;
		}
		else{
			assert(false);
			return 0;
		}
	}

}
