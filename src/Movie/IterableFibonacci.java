package Movie;

import java.util.Iterator;

public class IterableFibonacci implements Iterable<Integer>{
	private int n= 0;
	public IterableFibonacci(int count ) {
		this.n = count;
	}	
	//����������������
	public Iterator<Integer> iterator() {
	    return new Iterator<Integer>(){
	      public boolean hasNext() { return n > 0; }
	   	  public Integer next() {
	   		  	n--;
	   	    return IterableFibonacci.this.next();
	   	  }
	   	@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}    	
	    };
			    
	}	
	public Integer next(){
		return 1;
	}
}
