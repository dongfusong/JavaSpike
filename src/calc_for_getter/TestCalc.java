package calc_for_getter;

import static org.junit.Assert.*;

import org.junit.Test;

class Calculator{
	static Calculator instance = null;
	private Calcer calc = null;
	static Calculator getInstance(){
		if (instance == null){
			instance = new Calculator();
		}
		return instance;
	}
	private Calculator(){
		String[] symbols1 = new String[]{"*", "/"};
		String[] symbols2 = new String[]{"+", "-"};
		calc = new Calcer(symbols2, new Calcer(symbols1, new SimpleGetter()));
	}
	int calc(String str){
		return calc.get(new Container(str.split(" ")));
	}

}

public class TestCalc {
	@Test
	public void test() {
		String str = "3 + 4 - 6 * 4";		
		assertEquals(-17, Calculator.getInstance().calc(str));
	}
}
