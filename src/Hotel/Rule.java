package Hotel;

class Rule{
	private Condition condition = null;
	double discount = 0;
	
	public Rule(Condition condition, double discount) {
		this.condition = condition;
		this.discount = discount;
	}

	public double discount(Condition rhs) {
		if (true == condition.befullfill(rhs)){
			return discount;
		}
		return 1;
	}
}
