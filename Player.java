/* 
Santhosh Janagam
Programming Assignment 4
Solution for Snakes and Ladder game
Submitted for CS585C, Fall 2016
 */
package game;

public class Player {
	private char name = ' ';
	private int currentPosition = 0;
	private int firstMove =0;
	public Player(){
		
	}
	
	public Player(char name) {
		this.name = name;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public int getFirstMove() {
		return firstMove;
	}

	public void setFirstMove(int firstMove) {
		this.firstMove = firstMove;
	}
	
}
