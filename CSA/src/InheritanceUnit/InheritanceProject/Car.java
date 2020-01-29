package InheritanceUnit.InheritanceProject;

public class Car extends Vehicle{
	//variables specific to cars
	protected String model;
	protected int milage;
	//default constructor
	public Car() {
		super();
		model = "BMW";
	}
	public Car(int w, int s, double c, String model, int m) {
		super(w,s,c);
		this.model = model;
		milage = m;
	}
	public void makeSound() {
		System.out.println("Vroom Vroom!");
	}
	public void startCar() {
		System.out.println("Car has started!");
		makeSound();
	}
	public void rollDownWindow() {
		System.out.println("Windows are down.");
	}
	public String toString() {
		return super.toString()+" and has "+milage+" miles";
	}
	//getter methods
	public String getModel() {return model;}
	public int getMilage() {return milage;} 
}
