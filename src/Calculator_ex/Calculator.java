package Calculator_ex;


public class Calculator {
	
	CalcRule calcor = null;
	
	public Calculator(){
		String[] symbols_l = {"-", "+"};
		String[] symbols_h = {"*"};
		calcor = new CalcRule(symbols_l, new CalcRule(symbols_h, new StringGetter()));
	}
	
	public static String add(String strA, String strB) {
		BigDig digA = new BigDig(strA);
		BigDig digB = new BigDig(strB);
		return digA.add(digB).toString();
	}

	public static String multiply(String strA, String strB) {
		BigDig digA = new BigDig(strA);
		BigDig digB = new BigDig(strB);
		return digA.multiply(digB).toString();
	}

	public static String minus(String strA, String strB) {
		BigDig digA = new BigDig(strA);
		BigDig digB = new BigDig(strB);		
		return digA.minus(digB).toString();
	}

	public String calc(String string) {
		Expression exp = new Expression(string);
		return calcor.calc(exp);
	}
}
