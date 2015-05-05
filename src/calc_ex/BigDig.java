package calc_ex;

public class BigDig {
	StringBuilder str = null;
	
	public BigDig(String str) {
		this.str = new StringBuilder(str);
	}
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	int getValue(int index){
		if (index < length()){
			return charAt(index) - '0';
		}
		return 0;
	}
	
	String reverse(){
		return str.reverse().toString();
	}

}
