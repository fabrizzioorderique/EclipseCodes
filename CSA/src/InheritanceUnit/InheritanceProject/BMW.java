package InheritanceUnit.InheritanceProject;
public class BMW extends Car{
	private int topSpeed;
	public BMW() {
		super();
		topSpeed = 200;
	}
	public BMW(int w, int s, double c, String model, int m, int t) {
		super(w,s,c,model,m);
		topSpeed = t;
	}
	public BMW(int t) {
		super();
		topSpeed = t;
	}
	public String race(BMW b) {
		String winner;
		if(b.getTopSpeed()>topSpeed) {
			winner = "The other BMW";
		}else if(b.getTopSpeed()<topSpeed){
			winner = "This BMW";
		}else {winner = "no one";}
		return winner+" is the winner";
	}
	public void turnOnRadio() {
		System.out.println("Bon Jovi is singing!");
	}
	public void makeSound() {
		System.out.println("VROOOooOOMMMMMM!!!!");
	}
	public int getTopSpeed() {return topSpeed;}
}
