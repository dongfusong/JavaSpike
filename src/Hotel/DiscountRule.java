package Hotel;

import java.util.LinkedList;

public class DiscountRule {
	private LinkedList<Rule> rules;
	
	static DiscountRule instance = null;
	
	public static DiscountRule getInstance() {
		if (instance == null){
			instance = new DiscountRule();
		}
		return instance;
	}
	
	private DiscountRule(){
		rules = new LinkedList<Rule>();
	}
	
	void addCondition(Rule rule){
		rules.add(rule);
	}
	
	public double calc(Condition condition) {
		double discount = 1.0;
		for (Rule rule : rules){
			discount *= rule.discount(condition);
		}
		return discount;
	}
	
}
