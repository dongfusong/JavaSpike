package calc_ex;

public class Calcor_x {
	int getValue(String str, int index){
		if (index < str.length()){
			return str.charAt(index) - '0';
		}
		return 0;
	}
	String multiply(String multiA, String multiB){
		BigDig a = new BigDig(multiA);
		BigDig b = new BigDig(multiB);
		return multiply(a, b);
	}
	private String multiply(BigDig a, BigDig b) {
		String result = new String();
		int offset = 0;
		for (int i = a.length() - 1; i >= 0; i--){
			String singleResult = multiplySingle(a.getValue(i), b);
			result = add(result, shift(singleResult, offset++));
		}
		return result;
	}
	

	String reverse(String str){
		return new StringBuilder(str).reverse().toString();
	}
	
	String reverseToString(StringBuilder str){
		return str.reverse().toString();
	}
	
	private String CalcOperation(int minLength, Calcor calcor){
		int carry = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < minLength; i++){
			Decimal dig = Decimal.toDecimal(calcor.calc(i, carry));
			result.append(dig.rest);
			carry = dig.carry;
		}
		if (carry != 0){
			result.append(String.valueOf(carry));
		}
		return reverseToString(result);
	}
	
	private String multiplySingle(int value, BigDig multi) {
		return CalcOperation(multi.length(), new MultiCalcor(multi.reverse(), value));
	}
	
	private String add(String addA, String addB) {
		return CalcOperation(Math.max(addA.length(), addB.length()), 
				new AddCalcor(reverse(addA), reverse(addB)));
	}

	private String shift(String str, int count) { 
		String appendZeros = new String();
		while(count > 0){
			appendZeros += "0";
			count--;
		}
		return str + appendZeros;
	}
}
