import java.util.*;
public class TestClass {
	
	public TestClass() {
		doSomething();
	}

	private void doSomething() {
		System.out.println("I did something: I was initialized :)");
	}
	
	private void countTo(int a) {
		for(int i = a; i< 0;i--) {
			System.out.println(i);
		}
	}
	
	private void whileTest() {
		int x = 0;
		do {
			x++;
			System.out.println(x);
		}while(x>10);
		System.out.println(0%3);
	}
}
