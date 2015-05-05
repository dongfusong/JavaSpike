package Calculator_ex;

public class Expression {
	String[] segments = null;
	int currentIndex = 0;
	public Expression(String string) {
		segments = string.split(" ");	
	}

	public String get() {
		return segments[currentIndex++];
	}

	public boolean empty() {
		return currentIndex == segments.length;
	}

	public void moveBack() {
		currentIndex--;
	}

}

