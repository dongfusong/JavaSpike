package Calculator_ex;


class StringGetter implements PriotyRule{
	@Override
	public String calc(Expression expression) {
		return expression.get();
	}	
}
