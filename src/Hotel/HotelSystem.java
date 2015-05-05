package Hotel;

public class HotelSystem {
	static HotelSystem instance = null;
	static public HotelSystem getInstance(){
		if (instance == null){
			instance = new HotelSystem();
		}
		return instance;
	}
	
	private HotelSystem() {}
	
	private Condition makeCondition(Client client, Room room, Day day){
		CompositeCondition condition = new CompositeCondition();
		condition.add(client);
		condition.add(room);
		condition.add(day);
		return condition;
	}
	
	private int calcFee(String[] segments){
		Client client = new Client(segments[0]);
		Room[] rooms = Room.toRooms(segments[1]);
		Day day = new Day(segments[3]);
		DiscountRule discountRule = DiscountRule.getInstance();
		int fee = 0;
		for (Room room : rooms){
			Condition condition = makeCondition(client, room, day);
			fee += discountRule.calc(condition) * room.getFee();
		}
		return fee;
	}
	
	String bookRoom(String bookInfo){
		String[] segments = bookInfo.split(bookInfo);
		assert(segments.length == 4);
		return String.valueOf(calcFee(segments));
	}
}
