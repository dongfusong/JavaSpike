package calc_for_getter;


public class Calcer implements Getter{
	private String[] symbols = null;
	private Getter getter = null;
	
	public Calcer(String[] symbols, Getter getter) {
		this.symbols = symbols;
		this.getter = getter;
	}
	
	int calc(int next, String symbol2, int value2){
		if (symbol2.equals("+")){
			return next + value2; 
		}
		else if (symbol2.equals("-")){
			return next - value2;
		}
		else if (symbol2.equals("*")){
			return next * value2;
		}
		else{
			return next / value2;
		}
	}
	
	@Override
	public int get(Container con) {
		int value = getter.get(con);
		while (!con.empty()){
			String symbol = con.nextSymbol();
			if (isForMe(symbol)){
				value = calc(value, symbol, getter.get(con));				
			}else{
				con.moveBack(1);
				break;				
			}
		}
		return value;
	}

	private boolean isForMe(String symbol) {
		for (String item : symbols){
			if (item.equals(symbol)){
				return true;
			}
		}
		return false;
	}
}
