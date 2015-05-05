package calc_ex;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Describable;

//注意思考的层次不能沉的太细节，要在实践和高度抽象之间
public class TestCalc {
	@Test
	public void test() {
		assertEquals("2659230", new Calcor_x().multiply("1134", "2345"));
	}
}
