/* 
Santhosh Janagam
Programming Assignment 4
Solution for Snakes and Ladder game
Submitted for CS585C, Fall 2016
 */
package game;

public class Cell {

	private int number = 0;
	private Player player = null;
	private Ladder startLadder = null;
	private Ladder endLadder = null;
	private Snake startSnake = null;
	private Snake endSnake = null;
	
	public Cell(int number) {
		this.number = number;
	}	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Ladder getStartLadder() {
		return startLadder;
	}

	public void setStartLadder(Ladder startLadder) {
		this.startLadder = startLadder;
	}

	public Ladder getEndLadder() {
		return endLadder;
	}

	public void setEndLadder(Ladder endLadder) {
		this.endLadder = endLadder;
	}

	public Snake getStartSnake() {
		return startSnake;
	}

	public void setStartSnake(Snake startSnake) {
		this.startSnake = startSnake;
	}

	public Snake getEndSnake() {
		return endSnake;
	}

	public void setEndSnake(Snake endSnake) {
		this.endSnake = endSnake;
	}
	
	
	
	public void draw() {
		//create string for start ladder
		String Ladder1 = (startLadder !=null)?(startLadder.getName()): " "; 
		//create string for end ladder
		String Ladder2 = (endLadder !=null)?(endLadder.getName()): " ";
		//create string for start snake
		String Snake1 = (endSnake !=null)?(endSnake.getName()): " ";
		//create string for end snake
		String Snake2 =	(startSnake !=null)?(startSnake.getName()): " ";
		//create string for player
		String playerNumber="";
		playerNumber = playerNumber + ((player!=null)?player.getName():"");
		// printing all values
		System.out.printf("|%2d%2s%2s%2s%2s%2s", number, playerNumber, Ladder1,Ladder2,Snake2, Snake1 );
		
		// |nnnL1L2
	}
}
