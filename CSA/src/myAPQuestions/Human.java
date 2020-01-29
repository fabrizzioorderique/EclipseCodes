package myAPQuestions;

public class Human extends LivingObject{

	public Human(String s) {
		super(s);
		System.out.println("human created");
	}

	@Override
	public void speak() {
		System.out.println(" i am human ");
	}

	
}
