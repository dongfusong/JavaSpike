package Calc;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestExp {

	@Test
	public void test_exp() {
		OperFactory operF = new OperFactory(0);
		ExpressionChain exp = new ExpressionChain("2234 + (123 - 1244) * 12 + 9 + 8#");		
		while(!exp.empty()){			
			Element elem = exp.get();
			System.out.println(elem.toString());
			if (elem.isOper()){
				Oper oper = operF.instance(elem.toString());
				System.out.println(oper.toString() + oper.prio);
			}
			else if (elem.isBracket()){
				operF.calcPrio(elem.toString());
			}			
		}
	}
	@Test
	public void test(){
		String str = "12234";
		assertEquals(new Integer(12234), Integer.valueOf(str));
	}
}
