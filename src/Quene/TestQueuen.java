package Quene;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

class Table{
	class Position{
		public int row;
		public int col;
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static final int maxCol = 8;
	public static final int maxRow = 8;

	private int[][] array = new int[maxRow][maxCol];

	void set(int rowIndex, int colIndex){
		array[rowIndex][colIndex] = 1;
	}
	
	void addTo(LinkedList<Position> scope, int row, int col){
		scope.add(new Position(row, col));
	}
	
	LinkedList<Position> getScope(int row, int col){
		LinkedList<Position> scope = new LinkedList<Table.Position>();
		for (int i = col; i >= 0; i--){
			addTo(scope, row, i);
		}
		int i = row;
		int j = col;
		while (i >= 0  && j >= 0){
			addTo(scope, i--, j--);
		}
		i = row;
		j = col;
		while(i < maxRow && j >= 0){
			addTo(scope, i++, j--);
		}
		return scope;
	}
	
	boolean isConfilct(int row, int col){
		return isConfilct(getScope(row, col));
	}
	
	boolean isConfilct(LinkedList<Position> scope){
		for (Position pos : scope){
			if (array[pos.row][pos.col] != 0){
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected Table clone(){
		Table table = new Table();
		for (int i = 0; i < maxRow; i++){
			for (int j = 0; j < maxCol; j++){
				table.array[i][j] = array[i][j];
			}
		}
		return table;
	}
	public void output() {
		for (int i = 0; i < maxRow; i++){
			for (int j = 0; j < maxCol; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println("\n");
		}
		System.out.println("---------------");
	}
	
}
class Queue{
	class Times{
		private int times = 0;
		public Times(int times){
			this.times = times;
		}
		
		int value(){
			return times;
		}
		public void increase() {
			times++;
		}
	}

	public int calc(){
		Table table = new Table();
		Times times = new Times(0);
		calc(table, 0, times);
		return times.value();
	}

	private void calc(Table table, int col, Times times) {
		if (col == Table.maxCol){
			table.output();
			times.increase();
			return;
		}
		for (int i = 0; i < Table.maxRow; i++){
			Table newTable = table.clone();
			if (!newTable.isConfilct(i, col)){
				newTable.set(i, col);
				calc(newTable, col+1, times);
			}
		}
	}
}
public class TestQueuen {
	@Test
	public void test() {
		Queue q = new Queue();
		int options = q.calc();
		assertEquals(92, options);
	}
}
