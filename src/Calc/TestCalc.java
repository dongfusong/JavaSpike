package Calc;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


public class TestCalc {
	@Test
	public void test_normal_calc() {
		String str = "2234 + 123 - 1244 * 12 + 9 + 8";
		CalcProcess process = new CalcProcess();
		assertEquals("-12554", process.Cacl(str));
	}
	
	@Test
	public void test_with_bracket() {
		String str = "4 + (5 - 6 + 7)";
		CalcProcess process = new CalcProcess();
		assertEquals("10", process.Cacl(str));
	}
	
	@Test
	public void test_stack(){
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(2);
		stk.push(1);
		assertEquals(new Integer(1), stk.lastElement());
	}
	
	@Test
	public void test_bracket(){
		String str = "(((2)))";
		assertEquals("2", (new CalcProcess()).Cacl(str));
	}
	
	@Test
	public void test_all(){
		String str = "(8 * ((2+3)-3)+8) + 9 * 283";
		assertEquals("2571", (new CalcProcess()).Cacl(str));
	}
}
