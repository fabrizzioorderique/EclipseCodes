package Josephus;

import java.util.ArrayList;
import java.util.Scanner;


public class JosephusRunner {
	public static Scanner s = new Scanner(System.in);
	public static ArrayList<Person> people = new ArrayList<>();
	public static int totalPeople;
	
	public static void main(String args[]) {
		System.out.println("How many people are in the circle?");
		totalPeople = s.nextInt();
		for(int i = 0; i < totalPeople; i++) {
			people.add(new Person(i));
		}
		printStatuses();

	}
	//for testing
	public static void printStatuses() {
		for(Person p: people) {
			System.out.print(p.getStatus()+" ");
		}
		System.out.println();
	}
	
	// k represents every kth person dies

}
