package ticketPractice;

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
		double totalAmount = 0;
		for(int i = 0; i < t.ticketList.length;i++) {
			totalAmount += t.ticketList[i].getPrice();
		}
		System.out.println(totalAmount);
	}

}
