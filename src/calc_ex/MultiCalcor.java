package calc_ex;

public class MultiCalcor extends Calcor {
	private String multi;
	private int value = 0;
	
	public MultiCalcor(String multi, int value) {
		this.multi = multi;
		this.value = value;
	}
	
	@Override
	public int calc(int i, int carry) {
		System.out.println(getValue(multi, i) + "*" + value + "- carry:" + carry);
		return getValue(multi, i) * value + carry; 
	}

}
