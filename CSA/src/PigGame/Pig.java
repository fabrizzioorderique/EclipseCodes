package PigGame;
/**
 * Plays the pig game
 *  user v comp
 *  each turn, the player 
 */

import java.util.Scanner;
import java.util.Random;

public class Pig{
	static int playerScore = 0;
	static int computerScore = 0;
	static int pRoundScore = 0;
	static int cRoundScore = 0;
	static PairOfDice dice = new PairOfDice();
	
	public static void main(String[] args){
		//while(playerScore < 100 && computerScore < 100) {}
		playersTurn();
	  }
  public static void playersTurn() {
	  pRoundScore += dice.rollPair();
	  System.out.println("Your dice showed a: " + dice.d1Val + " and " + dice.d2Val);
	  System.out.println("Your round score is: " + pRoundScore);
  }
}