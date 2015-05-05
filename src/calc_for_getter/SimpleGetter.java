package calc_for_getter;


public class SimpleGetter implements Getter{
	public int get(Container con){
		return con.next();
	}	
}
