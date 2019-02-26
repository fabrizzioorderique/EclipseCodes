package RandProjectsPackage;

public class Transactions {
	private int numOfTickets;
	Ticket[] ticketList;
	
	public Transactions(int numOfTickets) {
		this.numOfTickets = numOfTickets;
		ticketList = new Ticket[this.numOfTickets];
		fillTicketList();
	}
	private void fillTicketList() {
		for(int i = 0; i < numOfTickets;i++) {
			ticketList[i] = new Ticket("n/a",i,i*10);
		}
	}
}
