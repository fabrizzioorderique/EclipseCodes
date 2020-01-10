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
	}
	//for testing
	public static void printStatuses() {
		for(Person p: people) {
			System.out.println(p.getStatus());
		}
	}
	
	// k represents every kth person dies
	public static int runGame(int k) {
		if(k > people.size()) return -1;
		/*if(people.size() == 1) return people.get(0).getOgPos();
		//take out every ith person and shift list around. 
		for(int i = k-1; i < people.size(); i+=k){
			people.remove(i);
		}*/
		int i = k;
		while(i < people.size())
		return runGame(k);
	}
}
