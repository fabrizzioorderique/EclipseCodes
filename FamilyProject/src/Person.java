public class Person {
	String fName;
	String lName;
	int age;
	double height;
	Person(){
		System.out.println("New Person Created");
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
