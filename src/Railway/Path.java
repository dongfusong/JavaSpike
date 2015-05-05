package Railway;

import java.util.LinkedList;

public class Path {
	private LinkedList<Node> path;
	boolean contains(Node node){
		return path.contains(node);
	}
	public void add(Node node) {
		path.add(node);
	}

}
