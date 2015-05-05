package Hotel;

public abstract class SingleCondition implements Condition {

	public boolean fullfill(Condition rhs){
		if (rhs instanceof SingleCondition){
			return fullfillSpec(rhs);
		}
		else{
			return rhs.fullfill(this);
		}
	}

	public boolean befullfill(Condition rhs){
		if (rhs instanceof SingleCondition){
			return beFullfillSpec(rhs);
		}
		else{
			return rhs.befullfill(this);
		}
	}
	
	protected abstract boolean fullfillSpec(Condition condition);
	protected abstract boolean beFullfillSpec(Condition condition);
}
