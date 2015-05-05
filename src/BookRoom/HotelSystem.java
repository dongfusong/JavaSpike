package BookRoom;

import java.util.LinkedList;

class HotelSystem{
	static private HotelSystem instance = null;
	private HotelSystem(){
		
	}
	static HotelSystem getInstance(){
		if (instance == null){
			instance = new HotelSystem();
		}
		return instance;
	}
	
	double calcFee(double discount, double fee, int days){
		System.out.println(discount + " " + fee + " " + days);
		return discount * fee * days;
	}
	
	double calcFee(ClientInfo clientInfo, LiveDays days, LinkedList<RoomInfo> rooms){
		double totalFee = 0;
		for (RoomInfo room : rooms){
			totalFee += calcFee(clientInfo.discount(room) * days.discount(room), 
				room.getFee(), days.value());
		}
		return totalFee;
	}
	
	double bookRoom(String str){
		Parser parser = new Parser(str);
		ClientInfo clientInfo = parser.getClientInfo();
		double totalFee = calcFee(clientInfo, parser.getDays(), parser.getRooms());
		clientInfo.increaseMark(totalFee);
		return totalFee;
	}
}