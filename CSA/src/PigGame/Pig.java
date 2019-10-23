package PigGame;
/**
 * 	Plays the pig game
 *  user v computer
 *  each turn, the player 
 *  
 *  @author fabri
 */
import java.util.Scanner;

public class Pig{
	static int playerScore = 0;
	static int computerScore = 0;
	static int pRoundScore = 0;
	static int cRoundScore = 0;
	static String player;
	static PairOfDice dice = new PairOfDice();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args){
		while(true) {
		playersTurn();
		System.out.println();
		if(playerScore >= 100) {break;}
		computersTurn();
		System.out.println();
		if(computerScore >= 100) {break;}
		}
		printWinner();
	}
	public static void playersTurn() {
	  player = "You";
	  System.out.println(player + " roll the dice.");
	  pRoundScore += dice.rollPair();
	  dice.printRoll();
	  if(dice.getVal(dice.getDie1()) == 1 || dice.getVal(dice.getDie2()) == 1) { 
		  if(dice.getVal(dice.getDie1()) == 1 && dice.getVal(dice.getDie2()) == 1) {
			  System.out.println(player + " rolled double 1's! You lost ALL your points!");
			  playerScore = 0;
			  return;
		  }
		  System.out.println(player + " rolled a 1! You lost your round points.");
		  pRoundScore = 0;
		  return;
	  }
	  System.out.println("Your round score is: " + pRoundScore);
	  System.out.println("Would you like to roll again for the chance at more points or keep your points? (r/k)");
	  String response = s.next();
	  if(response.equalsIgnoreCase("r")) {
		  playersTurn();
	  }else if(response.equalsIgnoreCase("k")){
		  playerScore += pRoundScore;
		  System.out.println("Your total score is now: " + playerScore);
		  pRoundScore = 0;
		  return;
	  }else {
		  System.out.println("There was an error with your response. Points were kept as default move.");
		  playerScore += pRoundScore;
		  System.out.println("Your total score is now: " + playerScore);
		  pRoundScore = 0;
		  return;
	  }	  
  }
	public static void computersTurn() {
	  player = "Computer";
	  cRoundScore = 0;
	  while(!(cRoundScore > 19)) {
		  System.out.println(player + " chooses to roll.");
		  cRoundScore += dice.rollPair();
		  dice.printRoll();
		  if(dice.getVal(dice.getDie1()) == 1 || dice.getVal(dice.getDie2()) == 1) { 
			  if(dice.getVal(dice.getDie1()) == 1 && dice.getVal(dice.getDie2()) == 1) {
				  System.out.println(player + " rolled double 1's! " + player + " lost ALL its points!");
				  computerScore = 0;
				  return;
			  }
			  System.out.println(player + " rolled a 1! " + player + " lost its round points.");
			  cRoundScore = 0;
			  return;
		  }
		  System.out.println("Computer round score is: " + cRoundScore);
	  }
	  System.out.println(player + " chooses to keep its points.");
	  computerScore += cRoundScore;
	  System.out.println("Computer's total score is now: " + computerScore);
	  cRoundScore = 0;
	  return;
	}
	public static void printWinner() {
		if(playerScore > 100) {player = "You";}
		if(computerScore > 100) {player = "Computer";}
		System.out.println(player + " WINS!");
	}
}