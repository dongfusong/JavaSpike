package calc_ex;

public abstract class Calcor {
	public abstract int calc(int i, int carry);
	int getValue(String str, int index){
		if (index < str.length()){
			return str.charAt(index) - '0';
		}
		return 0;
	}
	
}


