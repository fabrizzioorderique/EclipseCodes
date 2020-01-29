package InheritanceUnit.InheritanceProject;

public class Train extends Vehicle{
	protected int railings;
	protected boolean moving;
	public Train() {
		super();
		railings = 0;
		moving = true;
	}
	public Train(int r, boolean b) {
		super();
		railings = r;
		moving = b;
	}
	public void makeSound() {
		System.out.println("HoooOOOONNNK!");
	}
	public void stopTrain() {
		System.out.println("Train was stopped");
		moving = false;
	}
	public String toString() {
		String move;
		if(moving == true) {move = "moving";}
		else {move = "not moving";}
		return super.toString()+" and is "+move;
	}
	public int getRailings() {return railings;}
}
