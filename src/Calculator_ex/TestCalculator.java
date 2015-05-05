package Calculator_ex;

import static org.junit.Assert.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

import org.junit.Test;


class Div{
	class Divider{
		private int value = 0;
		private String str = null;
		Divider(int value, String str){
			this.value = value;
			this.str = str;
//			System.out.println(value +" " + str);
		}
		int getDivResult(){
			return value;
		}
		String getRest(){
			return str;
		}
	}
	
	Divider guessDived(String strA, String strB){
		int digA = Integer.valueOf(strA);
		int digB = Integer.valueOf(strB);
		for (int i = 9; i >= 0; i--){
			if (digA - digB * i >= 0){
				return new Divider(i, String.valueOf(digA - digB * i));
			}
		}
		return new Divider(0, strA);
	}
	
	void append(StringBuffer str, int value){
		str.append(value);
	}	
	
	public String omitZeros(StringBuffer str){
		int index = 0;
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) == '0'){
				index++;
			}else{
				break;
			}
		}
		return str.substring(index).toString();
	}
	
	public String divide(String strA, String strB){
		int index = 0;
		StringBuffer result = new StringBuffer();
		StringBuffer str = new StringBuffer();
		while (index < strA.length()){
			str.append(strA.charAt(index++));
			Divider div = guessDived(str.toString(), strB);
			append(result, div.getDivResult());
			str = new StringBuffer(div.getRest());			
		}		
		return omitZeros(result);
	}		
}


public class TestCalculator {
	private Calculator calcor = new Calculator();
	@Test
	public void test_25_divide_5(){ 
		Div div = new Div();
		assertEquals("5", div.divide("25", "5"));
		assertEquals("51", div.divide("255", "5"));
		assertEquals("100000000000000000", div.divide("1000000000000000000", "10"));
	} 
	
	@Test
	public void test_omitZero(){
		Div div = new Div();
		StringBuffer buffer = new StringBuffer("000000001234");
		assertEquals("1234", div.omitZeros(buffer));
	}
	
	@Test
	public void test_3_add_5_equal_8() {		
		assertEquals("8", Calculator.add("3", "5"));
	}
	
	@Test
	public void test_9_add_5_equal_14() {		
		assertEquals("14", Calculator.add("9", "5"));
	}
	
	@Test
	public void test_111_add_222_equal_333() {		
		assertEquals("333", Calculator.add("111", "222"));
	}
	
	@Test
	public void test_9999999999999999999_add_99999999999999999999999999999999_equal_100000000000009999999999999999998(){
		assertEquals("100000000000009999999999999999998", Calculator.add("9999999999999999999", "99999999999999999999999999999999"));
	}
	
	@Test
	public void test_2_multiply_3_equal_6(){
		assertEquals("6", Calculator.multiply("2", "3"));
	}
	
	@Test
	public void test_45666_minus_999_equal_44667(){
		assertEquals("44667", Calculator.minus("45666", "999"));
	}
	
	@Test
	public void test_999_minus_45666_equal_negtive_44667(){
		assertEquals("-44667", Calculator.minus("999", "45666"));
	}
	
	@Test
	public void test_mius_to_add(){ 
		assertEquals("44", Calculator.minus("-45", "-89"));
	}
	
	@Test
	public void test_add_to_minus(){
		assertEquals("0", Calculator.add("-345", "345"));
	}
	
	@Test
	public void test_add_to_minus_1(){
		assertEquals("-1", Calculator.add("-346", "345"));
	}
	
	@Test
	public void test_minus_to_add(){
		assertEquals("-1579", Calculator.minus("-1234", "345"));
	}
	@Test
	public void test_(){
		assertEquals("44667", Calculator.minus("-999", "-45666"));
	}
	
	@Test
	public void test_fix_add_and_minus(){
		assertEquals("19", calcor.calc("3 + 4 + 4 - -8"));
	}
	
	@Test
	public void test_all(){
		assertEquals("37", calcor.calc("3 + 4 + 4 - -8 * 3 - 8 + 2 * 5"));
		assertEquals("21", calcor.calc("3 - 4 - 4 - -8 * 3 - 8 + 2 * 5"));		
	}
}
