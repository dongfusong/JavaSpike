package BookRoom;

import java.util.LinkedList;

class Parser{
	private static final int CLIENT_INFO = 0;
	private static final int ROOM_INFO = 1;
	private static final int DATA_INFO = 2;
	private static final int PERIOD_INFO = 3;
	
	private String array[] = null;
	private String roomInfo[] = null;

	
	public Parser(String content){
		array = content.split(" ");
		roomInfo = array[ROOM_INFO].split("&");
	}
	
	ClientInfo getClientInfo(){
		return ClientRepository.getInstance().get(array[CLIENT_INFO]);		
	}
	
	LinkedList<RoomInfo> getRooms(){
		LinkedList<RoomInfo> rooms = new LinkedList<RoomInfo>();
		for (String item : roomInfo){
			rooms.add(new RoomInfo(String.valueOf(item.charAt(0)),  item.charAt(1) - '0'));
		}
		return rooms;
	}
	
	LiveDays getDays(){
		return new LiveDays(Integer.valueOf(array[PERIOD_INFO]));
	}
	
	String getData(){
		return array[DATA_INFO];
	}
}