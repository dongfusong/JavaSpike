package BookRoom;

import org.eclipse.jdt.annotation.Nullable;

class ClientInfo{
	static private ClientType diamond = new DiamondClient();
	static private ClientType golden = new Golden();
	static private ClientType silver = new Silver();
	static private ClientType normal = new Normal();
	
	@Nullable
	private ClientType clientType = null;
	private int mark = 0;
	
	public ClientInfo() {
		clientType = normal;
	}
	
	void increaseMark(double totalFee){
		mark += totalFee;
		if (mark >= 30000){
			clientType = diamond;
		}else if(mark >= 10000){
			clientType = golden;
		}else if (mark >= 4000){
			clientType = silver;
		}else{
			clientType = normal;
		}
	}
	
	double discount(RoomInfo room){
		return clientType.discount(room);
		
	}

}