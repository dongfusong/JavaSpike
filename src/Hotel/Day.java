package Hotel;

public class Day extends SingleCondition{
	int days = 0;
	
	public Day(String str) {
		days = Integer.valueOf(str).intValue();
	}
	@Override
	protected boolean fullfillSpec(Condition condition) {
		if (condition instanceof Day){
			return this.days >= ((Day)condition).days;
		}
		return false;
	}
	
	@Override
	protected boolean beFullfillSpec(Condition condition) {
		if (condition instanceof Day){
			return this.days < ((Day)condition).days;
		}
		return false;
	}
}
