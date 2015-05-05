package BookRoom;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestBookRoom {
	@Test
	public void test_bookroom() {
		String bookInfo = "M123456 L1&S1 2011-6-1 2";
		HotelSystem system = HotelSystem.getInstance();
		assertEquals(1960, system.bookRoom(bookInfo), 0.0001);
	}
	
	@Test
	public void test_morethan_30days(){
		String bookInfo = "M999999 D1 2011-6-2 30";
		HotelSystem system = HotelSystem.getInstance();
		assertEquals(11220.00, system.bookRoom(bookInfo), 0.0001);
	}
}
