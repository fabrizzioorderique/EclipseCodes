package RandProjectsPackage;

public class Ticket {
	private String myRow;
	private int mySeat;
	private double myPrice;
	
	public Ticket(String row, int seat, double price) {
		myRow = row;
		mySeat = seat;
		myPrice = price;
	}
	
	public String getRow() {
		return myRow;
	}
	public int getSeat() {
		return mySeat;
	}
	public double getPrice() {
		return myPrice;
	}
}
