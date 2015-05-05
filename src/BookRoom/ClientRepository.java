package BookRoom;

class ClientRepository{
	static private ClientRepository instance = null; 
	
	static public ClientRepository getInstance(){
		if (null == instance){
			instance = new ClientRepository();
		}		
		return instance;
	}
	private ClientRepository() {
		// TODO Auto-generated constructor stub
	}
	public ClientInfo get(String name){
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.increaseMark(10005);
		return clientInfo;
	}
}