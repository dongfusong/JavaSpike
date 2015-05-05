package BookRoom;

abstract class ClientType{
	protected double discount = 0;
	public double discount(RoomInfo room){
		return discount;
	}
}

class DiamondClient extends ClientType{
	public DiamondClient() {
		discount = 0.7;
	}
}

class Golden extends ClientType{
	public Golden() {
		discount = 0.85;
	}
	public double discount(RoomInfo room){
		if (room.isLuxary()){
			return 0.8;
		}else{
			return discount;
		}
	}
}

class Silver extends ClientType{
	public Silver() {
		discount = 0.9;
	}
	
}
class Normal extends ClientType{
	public Normal(){
		discount = 1;
	}
}
