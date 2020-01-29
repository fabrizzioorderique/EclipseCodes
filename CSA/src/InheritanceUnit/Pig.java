package InheritanceUnit;
//Pig is a child class of animal 
public class Pig extends Animal {
	//pig constructor calls all other constructors before it
	public Pig() {
		System.out.println("But not just any animal... I am a pig!");
	}
	//pig sound method
	public void makeSound() {
		System.out.println("Oink Oink!");
	}
}
