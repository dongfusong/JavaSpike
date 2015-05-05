package calc_ex;

class Decimal{
	String rest;
	int carry;
	public Decimal(String rest, int carry){
		this.rest = rest;
		this.carry = carry;
	}
	public static Decimal toDecimal(int value) {
		return new Decimal(String.valueOf(value % 10), value / 10);
	}
}

