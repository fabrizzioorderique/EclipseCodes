package InheritanceUnit.InheritanceProject;
public class Vehicle {
	//all vehicles created will have these variable
	protected int numOfWheels;
	protected int numOfSeats;
	protected double cost;
	//no name default constructor
	public Vehicle() {
		numOfWheels = 4;
		numOfSeats = 4;
		cost = 10000;
	}
	public Vehicle(int w, int s, double c) {
		numOfWheels = w;
		numOfSeats = s;
		cost = c;
	}
	public void makeSound() {
		System.out.println("Vroommm");
	}
	public void increasePrice(double amount) {
		cost += amount;
	}
	public String toString() {
		return "This vehicle has "+numOfSeats+" seats and "
				+numOfWheels+" wheels and costs "+cost+" dollars";
	}
	//getter methods
	public double getCost() {return cost;}
	public int getNumWheels() {return numOfWheels;}
	public int getNumSeats() {return numOfSeats;}
}	
