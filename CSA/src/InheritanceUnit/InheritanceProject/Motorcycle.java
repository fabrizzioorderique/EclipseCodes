package InheritanceUnit.InheritanceProject;
public class Motorcycle extends Vehicle{
	private String model;
	private String color;
	public Motorcycle() {
		super();
		numOfSeats = 1;
		numOfWheels = 2;
	}
	public Motorcycle(String m, String c) {
		super();
		numOfSeats = 1;
		numOfWheels = 2;
		model = m;
		color = c;
	}
	public void makeSound() {
		System.out.println("RRrrrRRR");
	}
	public void drift() {
		System.out.println("driftinggg...");
	}
	public void wheelie() {
		numOfWheels = 1;
		System.out.println("Performing wheelie...");
	}
	//getter methods
	public String getModel() {return model;}
	public String getColor() {return color;}
}
