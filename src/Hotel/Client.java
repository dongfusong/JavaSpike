package Hotel;

public class Client extends SingleCondition{
	String client = null;
	public Client(String clientInfo) {
		client = clientInfo;
	}
	
	@Override
	protected boolean fullfillSpec(Condition condition) {
		if (condition instanceof Client){
			Client clientInfo = (Client)condition;
			return clientInfo.client == client;
		}
		return false;
	}
	
	@Override
	protected boolean beFullfillSpec(Condition condition) {
		return fullfillSpec(condition);
	}
}

