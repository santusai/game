/* 
Santhosh Janagam
Programming Assignment 4
Solution for Snakes and Ladder game
Submitted for CS585C, Fall 2016
 */
package game;

public class Snake {
	private Cell start = null;
	private Cell end = null;
	private int number = 0;
	private String name;
	
	// constructor 
	public Snake(){
		
	}

	public Snake(Cell start, Cell end, int number) {
		this.start = start;
		this.end = end;
		this.number = number;
		
	}

	public Cell getStart() {
		return start;
	}

	public Cell getEnd() {
		return end;
	}

	public int getNumber() {
		return number;
	}
	public String getName(){
		return "S"+ number;
	}
}
