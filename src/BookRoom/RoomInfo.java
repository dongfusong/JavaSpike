package BookRoom;

public class RoomInfo {
	private static final int luxaryRoom = 0;
	private static final int singleRoom = 1;
	private static final int doubleRoom = 2;
	
	private int type = 0; 
	private double fee = 0;
	private int count = 0;
	
	public RoomInfo(String type, int count) {
		System.out.println(type + " " +  count);
		this.count  = count;
		if (type.equals("L")){
			this.type = luxaryRoom;
			fee = 800;
		}else if (type.equals("D")){
			this.type = doubleRoom;
			fee = 500;
		}else if (type.equals("S")){
			this.type = singleRoom;
			fee = 400;
		}else{
			try {
				throw new NoSuchFieldException();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isLuxary() {
		return type == luxaryRoom;
	}

	public boolean isDouble() {
		return type == doubleRoom;
	}
	
	public boolean isSingle(){
		return type == singleRoom;
	}
	
	double getFee(){
		return fee * count;
	}
}
