package InheritanceUnit;

public class Farm {
	public static void main(String[] args) {
		Pig wilbur = new Pig();
		//calls a method from highest level class
		wilbur.sleep();
		//calls a method specifically from the pig class
		wilbur.makeSound();
	}
}
