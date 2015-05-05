package Hotel;

public class Room extends SingleCondition{
	String roomType;
	public static Room[] toRooms(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Room(String str) {
		roomType = str;
	}
	
	public double getFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean fullfillSpec(Condition condition) {
		if (condition instanceof Room){
			return ((Room) condition).roomType == roomType;
		}
		return false;
	}
	@Override
	protected boolean beFullfillSpec(Condition condition) {
		return fullfillSpec(condition);
	}
	
}
