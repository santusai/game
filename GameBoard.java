/* 
Santhosh Janagam
Programming Assignment 4
Solution for Snakes and Ladder game
Submitted for CS585C, Fall 2016
 */
package game;
import java.util.*;
public class GameBoard {

	private static final int NUM_ROWS = 10;
	private static final int NUM_COLS = 10;
	private static final int NUM_CELLS = NUM_ROWS * NUM_COLS;
	private static final int NUM_LADDERS = 5;
	private static final int NUM_SNAKES = 5;

	// 2-d array for the gameboard
	private Cell[][] matrix = new Cell[NUM_ROWS][NUM_COLS];
	private Player[] players;
	private int currPlayer = 0;
	private int rolledDiceValue;
	
	// dice
	private Dice dice = new Dice();
	
	// snakes and ladders
	private Ladder[] ladders;
	private Snake[] snakes;
		
	public GameBoard(int numPlayers) {
		
		// create an array of players
		players = new Player[numPlayers];
		for (int num = 0; num < players.length; ++num) {
			players[num] = new Player((char)('A' + num));
		}
		
		// create the board (2-d array of Cell)
		for (int cellNum = 1; cellNum <= 100; cellNum++) {
			int val = NUM_CELLS - cellNum;
			int row = val / NUM_COLS;
			int col = val % NUM_COLS;
			
			if (row % 2 != 0) {
				col = NUM_COLS - col - 1;
			}
			
			matrix[row][col] = new Cell(cellNum);
		}

		// create 5 snakes
		// 99 - 4
		snakes = new Snake[NUM_SNAKES];
		snakes[0] = new Snake(getCell(99), getCell(4), 1);
		getCell(99).setStartSnake(snakes[0]);
		getCell(4).setEndSnake(snakes[0]);
		
		snakes[1] = new Snake(getCell(34), getCell(8), 2);
		getCell(34).setStartSnake(snakes[1]);
		getCell(8).setEndSnake(snakes[1]);
		
		snakes[2] = new Snake(getCell(68), getCell(24), 3);
		getCell(68).setStartSnake(snakes[2]);
		getCell(24).setEndSnake(snakes[2]);
		
		// 2 extra snakes added here
		snakes[3] = new Snake(getCell(61), getCell(15), 4);
		getCell(61).setStartSnake(snakes[3]);
		getCell(15).setEndSnake(snakes[3]);
		
		snakes[4] = new Snake(getCell(93), getCell(6), 5);
		getCell(93).setStartSnake(snakes[4]);
		getCell(6).setEndSnake(snakes[4]);
		
		
		
		// create 5 ladders
		ladders = new Ladder[NUM_LADDERS];
		ladders[0] = new Ladder(getCell(7), getCell(33), 1);
		getCell(7).setStartLadder(ladders[0]);
		getCell(33).setEndLadder(ladders[0]);		
		
		ladders[1] = new Ladder(getCell(58), getCell(95), 2);
		getCell(58).setStartLadder(ladders[1]);
		getCell(95).setEndLadder(ladders[1]);
		
		ladders[2] = new Ladder(getCell(38), getCell(75), 3);
		getCell(38).setStartLadder(ladders[2]);
		getCell(75).setEndLadder(ladders[2]);
		
		// 2 extra ladders added here
		ladders[3] = new Ladder(getCell(27), getCell(51), 4);
		getCell(27).setStartLadder(ladders[3]);
		getCell(51).setEndLadder(ladders[3]);
		
		ladders[4] = new Ladder(getCell(44), getCell(88), 5);
		getCell(44).setStartLadder(ladders[4]);
		getCell(88).setEndLadder(ladders[4]);
	}
	
	private Cell getCell(int cellNum) {
		int val = NUM_CELLS - cellNum;
		int row = val / NUM_COLS;
		int col = val % NUM_COLS;
		
		if (row % 2 != 0) {
			col = NUM_COLS - col - 1;
		}
		
		return matrix[row][col];
	}
	public Cell modifySnakeValue(Cell succedingCell) {
		succedingCell=succedingCell.getStartSnake().getEnd();
		return succedingCell;
	}

	public Cell modifyLadderValue(Cell succedingCell) {
		succedingCell=succedingCell.getStartLadder().getEnd();
		return succedingCell;
	}
	// return the name of the winner
	public String play() {
		String gameWinner="";
		boolean gameOver = false;
		while (!gameOver) 
		{
			// Draw the board
			drawBoard();			
			// *** START OF LOOP BODY
			// Remember that a player than have more than one turn
			// before the next player has a turn
			for(currPlayer = 0;currPlayer<players.length;)
			{
				// TODO: current player rolls the dice
				rolledDiceValue=dice.roll(); 
				System.out.println("Dice value of: "+players[currPlayer].getName()+" is = "+rolledDiceValue);
				// If player is not active
				if(players[currPlayer].getFirstMove()==0)
				{
					// if dice is 6
					if(rolledDiceValue==6)
					{
						//Set the player to Active
						players[currPlayer].setFirstMove(1);
						if(getCell(1).getPlayer()==null)
						{
							// Move the player to by the number of cells
							// from current cell.
							players[currPlayer].setCurrentPosition(1);
						}
						
						players[currPlayer].setCurrentPosition(rolledDiceValue);
					}						
				}
				// ELSE
				
				else
				{
					if(move())
					{
						gameWinner=players[currPlayer].getName()+"";
						gameOver=true;
						break;
					}
				}
				 
				// TODO: If dice is not 6
				// don't change the current player
				// ELSE select the next player			
				if(rolledDiceValue!=6)
					currPlayer++;
			}		
				
		}				
		// *** END OF LOOP BODY			
		// TODO: return name of the winner
		return gameWinner;			
	}	
	
	// this method i get some problem while doing in player class so i had taken here
	// to move player i had added extra two methods modified values of snake and ladder methods.
	// by observing players current position with next position move method works.
	public boolean move() {
		int playerCurrentPosition=players[currPlayer].getCurrentPosition();
		int playerNextPosition=playerCurrentPosition+rolledDiceValue;	
		// if destination cell is >= 100, player is the winner, game over.
		if(playerNextPosition>=100)
		{
			getCell(playerCurrentPosition).setPlayer(null);
			// return true if this player win
			return true;
		}
		Cell succedingCell=getCell(playerNextPosition); // reference from friend
		if(succedingCell.getPlayer()==null)
		{
			if(succedingCell.getStartSnake()==null && succedingCell.getStartLadder()==null)
			{
				succedingCell.setPlayer(players[currPlayer]);
				getCell(playerCurrentPosition).setPlayer(null);
				players[currPlayer].setCurrentPosition(succedingCell.getNumber());
			}
			else
			{
				if(succedingCell.getStartLadder()!=null)
					succedingCell=modifyLadderValue(succedingCell);
				if(succedingCell.getStartSnake()!=null)
					succedingCell=modifySnakeValue(succedingCell);
				if(succedingCell.getPlayer()==null)
				{
					succedingCell.setPlayer(players[currPlayer]);
					getCell(playerCurrentPosition).setPlayer(null);
					players[currPlayer].setCurrentPosition(succedingCell.getNumber());
				}
			}
		}
		return false;
	}
	
	private void drawBoard() {
		
		// draw a line on top using dashes
		//---------------------			
		for (Cell[] row: matrix) {
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			for (Cell col: row) {
				col.draw();
			}
			System.out.println("|");
			
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println();
		// draw a line at the bottom using dashes
		//---------------------		
	}
	
}
