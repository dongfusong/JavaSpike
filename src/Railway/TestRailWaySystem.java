package Railway;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRailWaySystem {

	@Test
	public void test_a_canReach_a() {
		Node a = new Node("a");
		assertEquals(true, a.canReach("a"));
	}
	
	@Test
	public void test_a_cannot_reach_b(){
		Node a = new Node("a");
		assertEquals(false, a.canReach("b"));
	}
	
	@Test
	public void test_a_can_reach_b(){
		Node a = new Node("a");
		Node b = new Node("b");
		a.addNeighbor(b);
		assertEquals(true, a.canReach("b"));
	}
	
	@Test
	public void test_a_can_reach_c(){
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		a.addNeighbor(b);
		b.addNeighbor(c);
		assertEquals(true, a.canReach("c"));
	}
	
	@Test
	public void test_a_can_not_reach_c(){
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		a.addNeighbor(b);
		b.addNeighbor(a);
		assertEquals(false, a.canReach("c"));
	}
	
}
