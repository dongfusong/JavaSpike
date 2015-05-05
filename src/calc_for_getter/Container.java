package calc_for_getter;

public class Container{
	private String[] contents = null;
	int currentIndex = 0;
	public Container(String[] contents) {
		this.contents = contents;
	}
	public int next() {
		return Integer.valueOf(
				contents[currentIndex++]);
	}

	public boolean empty() {
		return currentIndex == contents.length;
	}

	public String nextSymbol() {
		return contents[currentIndex++];
	}

	public void moveBack(int i) {
		currentIndex -= i;
		assert(currentIndex >= 0);
	}
	
}