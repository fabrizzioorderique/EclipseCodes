package Josephus;

public class Person {
	//status will represent whether or not the person is alive
	// 0 - dead
	// 1 - alive
	private int status;
	private int originalPosition;
	
	public Person() {
		status = 1; //they all start out alive
	}
	public Person(int pos) {
		status = 1;
		originalPosition = pos;
	}
	public void kill() {
		status = 0;
	}
	public int getStatus() {
		return status;
	}
	public int getOgPos() {
		return originalPosition;
	}

} 
