package calc_ex;

import org.eclipse.jdt.annotation.Nullable;

public class AddCalcor extends Calcor{
	@Nullable
	private String adderA;
	
	@Nullable
	private String adderB;
	
	public AddCalcor(String a, String b) {
		adderA = a;
		adderB = b;
	}

	@Override
	public int calc(int i, int carry) {
		return getValue(adderA, i) + getValue(adderB, i) + carry;
	}

}
