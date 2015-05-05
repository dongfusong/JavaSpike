package Hotel;

import java.util.LinkedList;

public class CompositeCondition implements Condition {
	
	LinkedList<Condition> conditions;
	public CompositeCondition() {
		conditions = new LinkedList<Condition>();
	}
	
	@Override	
	public boolean fullfill(Condition condition) {
		if (condition instanceof SingleCondition){
			for (Condition item : conditions){
				if (item.fullfill(condition)){
					return true;
				}
			}	
			return false;
		}
		else{
			return condition.befullfill(this);
		}		
	}
	
	@Override
	public boolean befullfill(Condition rhs) {
		for (Condition condition : conditions){
			if (false == rhs.fullfill(condition)){
				return false;
			}
		}
		return true;
	}
	
	public void add(Condition condition) {
		conditions.add(condition);		
	}
}
