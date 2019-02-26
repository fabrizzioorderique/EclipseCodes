package ticketPractice;
/**
 * This is the Runner class for the ticket package. It uses the Ticket
 * and Transactions classes to do whatever you wish. These are practice
 * codes for a future project I plan to do which includes building a
 * program to use at bfoods. 
 * 
 * @author fabri
 * @date 26 February 2019
 */

import java.util.Scanner;
public class Runner {
	private static int numOfTickets;
	private static Scanner input;
	private static int askNum() {
		System.out.println("How many tickets would you like to purchase?");
		input = new Scanner(System.in);
		return input.nextInt();
	}
	public static void main(String[] args) {
		numOfTickets = askNum();
		Transactions t = new Transactions(numOfTickets);
		//calculates the total price
		double totalAmount = 0;
		for(int i = 0; i < t.ticketList.length;i++) {
			totalAmount += t.ticketList[i].getPrice();
		}
		System.out.println(totalAmount);
	}

}
