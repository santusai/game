/* 
Santhosh Janagam
Programming Assignment 4
Solution for Snakes and Ladder game
Submitted for CS585C, Fall 2016
 */
package game;

import java.util.Random;

public class Dice {
	static final int MAX_VAL = 6;
	static final int MIN_VAL = 1;

	private Random rand = new Random();
	
	public int roll() {
		return MIN_VAL + rand.nextInt(MAX_VAL - MIN_VAL + 1);
	}
	//public static void main(String [] args){
		//Dice dice = new Dice();
		//System.out.println(dice.roll());   // this line gives dice random value   
	//}
}
