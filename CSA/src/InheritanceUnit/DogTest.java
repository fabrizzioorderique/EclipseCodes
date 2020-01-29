package InheritanceUnit;
public class DogTest{
	public static void main(String[] args){
		Labrador lab = new Labrador("Lucy", "brown");
		System.out.println(lab.getName() + " says " + lab.speak());
		Yorkshire york = new Yorkshire("Daisy");
		System.out.println(york.getName() + " says " + york.speak());
	}
}

/*
   Problem 1
   a) it is not able to make an implicit call to the Dog class because
   	  this constructor takes in parameters. The method super(name) needs 
      to be added in order for the Dog constructor to execute. Note, the 
      super(name) method must be called before any other methods in the 
      Labrador constructor or else there will be an error.
   
   b) Here is what the Labrador constructor looks like after fixing the error:
	  	public Labrador(String name,  String color){
			super(name);
			this.color = color;
		}
	  Here is the code inside the main method of DogTest to make the Dog,
	    Labrador, and Yorkshire speak:
	  	Dog dog = new Dog("Spike");
		System.out.println(dog.getName() + " says " + dog.speak());
		Labrador lab = new Labrador("Lucy", "brown");
		System.out.println(lab.getName() + " says " + lab.speak());
		Yorkshire york = new Yorkshire("Daisy");
		System.out.println(york.getName() + " says " + york.speak());
  
   Problem 2
   The problem that arises is that the method avgBreedWeight() is attempting
   to return a non static variable. In order to fix this, we must make breedWeigt
   static. 
   
   Problem 3
   Here are the changes I made:
   > made the dog class abstract and added the abstract avgBreedWeight() method
   > added an auto-generated method stub (to implement the abstract method) to 
     the Yorkshire class
   > Got rid of the Dog object in the DogTest because you can't instantiate 
     an object from an abstract class.
  */
