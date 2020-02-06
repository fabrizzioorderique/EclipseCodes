package dataLab;

public class Tesla extends Vehicle{

	public Tesla(String make, String model, float combE) {
		super(make, model, combE);
	}
	public String toString() {
		return getMake() + " "+ super.toString();
	}

}
