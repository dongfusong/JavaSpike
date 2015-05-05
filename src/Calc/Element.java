package Calc;

public class Element{
	
	public static final int digital = 0;
	public static final int bracket = 1;
	public static final int oper = 2;
	
	private String content;
	public int type;
	
	public Element(String content, int type) {
		this.content = content;
		this.type = type;
	}
	
	int getValue(){
		assert(type == digital);
		return Integer.valueOf(content);
	}
	
	boolean isDig(){
		return type == digital;			
	}
	
	boolean isBracket(){
		return type == bracket;		
	}
	
	boolean isOper(){
		return type == oper;
	}
	public String toString(){
		return content;
	}
}