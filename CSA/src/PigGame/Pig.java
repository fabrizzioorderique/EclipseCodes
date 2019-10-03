package PigGame;
/**
 * Plays the pig game
 *  user v comp
 *  each turn, the player 
 */

import java.util.Scanner;
import java.util.Random;

public class Pig
{
  public static void main(String[] args)
  {
     int playerScores = 0;
     int playerTotal = 0;
     int computerScores = 0;
     int computerTotal = 0;
     int dice;
     boolean gameOver = false;
     boolean turnOver = false;
     char repeat;
     String input;   
     Scanner keyboard  = new Scanner(System.in);
      
     Random rand = new Random();
       
     System.out.println("Welcome to the game of Pig!\n");
      
     while (gameOver == false)
     {    
        do
        {
           dice = rand.nextInt(6) + 1;
           System.out.println("You rolled: " + dice);
           if (dice == 1)
           {
              playerScores = 0;
              System.out.print("You lose your turn! ");
              System.out.println("Your total is " + playerTotal);
              turnOver = true;
              while(playerTotal < 100);
           }
           else
           {
              playerScores += dice;
              System.out.print("Your turn score is " +
                               playerScores);
              System.out.println(" If you hold you will have " +
                                 playerScores + " points.");
              System.out.println("Enter 'r' to roll " +
                                 "again, 'h' to hold.");
              input = keyboard.nextLine();
              repeat = input.charAt(0);
 
              if (repeat == 'h')
               
                 break;                               
           }
        } while(turnOver == false || dice != 1);
           playerTotal += playerScores;
           System.out.println("Your score is " +
                              playerTotal);   
           playerScores = 0;
        if (playerTotal >= 100)
        {
           System.out.println("YOU WIN!");
           gameOver = true;
           while(playerTotal >= 100);
        } 
         
        System.out.println();
        System.out.println("It is the computer's turn.");
        do
        {
           dice = rand.nextInt(6) + 1;
           System.out.println("The computer rolled: " +
                              dice);
           if(dice == 1)
           {
              computerScores = 0;
              System.out.print("The computer lost its turn!");
              System.out.print(" Computer total is " + 
                               computerTotal);
              turnOver = true;
              while(computerTotal < 100);
           }
           else
           {
              computerScores += dice;
              if(computerScores >= 20 || (computerTotal +
                 computerScores) >= 100)
                 System.out.println("The computer holds");
                 turnOver = true;
           }
        } while (dice != 1 || computerScores < 20);
            
           computerTotal += computerScores;
           System.out.println("The computer's score is " +
                              computerTotal + "\n");
           computerScores = 0;
        if (computerTotal >= 100)
        {
           System.out.println("THE COMPUTER WINS!");
           gameOver = true;
           while (computerTotal >= 100);
        }
        if(keyboard!=null)
        keyboard.close();
         
  }
}
}