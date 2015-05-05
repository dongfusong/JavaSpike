package Railway;

import java.util.LinkedList;

public class Node {
	private static final int invalid_hopCount = Integer.MAX_VALUE;
	private String name = null;
	Node neighbor = null;
	public Node(String name) {
		this.name = name;
	}
	
	public boolean canReach(String dstName) {
		return invalid_hopCount != hopCount(dstName);
	}

	
	public int hopCount(String dstName){
		Path path = new Path();
		return hopCount(dstName, path);
	}
	
	private int hopCount(String dstName, Path path) {
		if (path.contains(this)){
			return invalid_hopCount;
		}
		path.add(this);
		if (dstName == name){
			return 0;
		}
		if (neighbor != null ){
			int hopCount = neighbor.hopCount(dstName);
			if (hopCount != invalid_hopCount){
				return hopCount + 1;
			}			
		}
		return invalid_hopCount;
	}

	public void addNeighbor(Node rhs) {
		neighbor = rhs;
	}

}
