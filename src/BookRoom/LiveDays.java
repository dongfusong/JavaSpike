package BookRoom;

public class LiveDays {
	private static final int discountDay = 30;
	private int days = 0;
	public LiveDays(int days) {
		this.days = days;
	}
	public double discount(RoomInfo room){
		if (days >= discountDay){
			if (room.isLuxary()){
				return 0.85;
			}else if (room.isDouble()){
				return 0.88;
			}else{
				return 0.9;
			}
		}
		return 1;
	}
	public int value() {
		return days;
	}
}
