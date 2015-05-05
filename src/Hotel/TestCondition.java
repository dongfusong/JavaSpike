package Hotel;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCondition {

	@Test
	public void testClient() {
		Client client = new Client("dfs");
		assertEquals(true, client.fullfill(new Client("dfs")));
	}
	
	@Test
	public void testDays(){
		Day day = new Day("23");
		assertEquals(true, day.fullfill(new Day("22")));
		assertEquals(false, day.fullfill(new Day("25")));
	}
	
	@Test
	public void testCompositeCondition_fullfill_single(){
		CompositeCondition condition1 = new CompositeCondition();
		condition1.add(new Day("12"));
		condition1.add(new Client("dfs"));
				
		assertEquals(true, condition1.fullfill(new Day("10")));
		assertEquals(false, condition1.fullfill(new Client("dfsg")));
	}
	
	@Test
	public void testCompositeCondition_fullfill_composite(){
		CompositeCondition condition1 = new CompositeCondition();
		condition1.add(new Day("12"));
		condition1.add(new Client("dfs"));
		
		CompositeCondition condition2 = new CompositeCondition();
		condition2.add(new Day("34"));
		condition2.add(new Client("dfs"));
		
		assertEquals(false, condition1.fullfill(condition2));
		assertEquals(true, condition2.fullfill(condition1));
	}
}
