package InheritanceUnit.InheritanceProject;

public class VehicleRunner {
	public static void main(String[] args) {
		//Parent class
		Vehicle v = new Vehicle();
		v.increasePrice(399);
		System.out.println(v);
		v.makeSound();
		System.out.println();
		//Child Car class
		Car c = new Car();
		System.out.println(c);
		c.rollDownWindow();
		System.out.println();
		//Car subclass BMW
		BMW fabri = new BMW(100);
		fabri.startCar();
		System.out.println(fabri.race(new BMW()));
		System.out.println();
		//Child Motorcycle class
		Motorcycle m = new Motorcycle();
		m.drift();
		m.wheelie();
		System.out.println();
		//Child Train class
		Train mitchell = new Train(4,true);
		mitchell.stopTrain();
		System.out.println(mitchell);
		mitchell.makeSound();
		System.out.println();

	}

}
