package myAPQuestions;

public class LivingObject{
	String name;
	public LivingObject(String s){
		name = s;
		System.out.println("living obj created");
	}
	public void speak() {};
	public void doSomething() {
		System.out.println("did something");
	}
}