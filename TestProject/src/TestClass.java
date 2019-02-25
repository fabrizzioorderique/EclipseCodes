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
}
