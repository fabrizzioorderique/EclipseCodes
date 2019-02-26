package ticketPractice;

public class Runner {
	private static int numofTickets;
	public static void main(String[] args) {
		numofTickets = 5;
		Transactions t = new Transactions(5);
		double totalAmount = 0;
		for(int i = 0; i < t.ticketList.length;i++) {
			totalAmount += t.ticketList[i].getPrice();
		}
		System.out.println(totalAmount);
	}

}
