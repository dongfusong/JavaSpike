package Calc;

//±í´ïÊ½Á´
class ExpressionChain{
	private int currentIndex = 0;
	private String content = null;
	
	public ExpressionChain(String string) {
		content = string;
	}
	
	int calcDigLen(int beginLength){
		int length = 0;
		while(beginLength + length != content.length() &&
				isDig(content.charAt(beginLength + length))){
			length++;
		}
		return length;
	}
	
	String getDigital(){
		int diglength = calcDigLen(currentIndex);
		String dig = content.substring(currentIndex, currentIndex + diglength);		
		return dig;
	}
	
	Element get(){
		assert(!empty());
		char symbol = skipSpace(content.charAt(currentIndex));
		if (isOper(symbol)){
			currentIndex++;
			return new Element(String.valueOf(symbol), Element.oper);
		}
		else if (isBracket(symbol)){
			currentIndex++;
			return new Element(String.valueOf(symbol), Element.bracket);			
		}		
		else{
			String dig = getDigital();
			currentIndex += dig.length();
			return new Element(dig, Element.digital);
		}
	}

	private boolean isDig(char content) {
		return content >= '0' && content <= '9';
	}

	private char skipSpace(char symbol) {
		while(isSpace(symbol)){
			currentIndex++;
			symbol = content.charAt(currentIndex);
		}
		return symbol;
	}
	
	private boolean isSpace(char symbol) {
		return symbol == ' ';
	}
	
	private boolean isBracket(char symbol) {
		return symbol == ')' || symbol == '(';
	}
	
	private boolean isOper(char symbol) {
		return symbol == '+' || symbol ==  '-' 
				|| symbol == '*' || symbol == '/' || symbol == '#';
	}
	
	public boolean empty() {
		return currentIndex == content.length();
	}
}