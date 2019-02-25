import java.util.Scanner;

public class MainTestClass {
	public static String[] familyMembers;
	public static void main(String[] args) {
		//Creates new Scanner object
		Scanner in = new Scanner(System.in);
		//Test prints
		System.out.println("It's working!");
		//Asks for how many family members to create and initializes list
		System.out.print("How many family members would you like to create? ");
		int a = in.nextInt();
		familyMembers = new String[a];
		System.out.println("Type in family member names: ");
		for(int i = 0; i < a;i++) {
			String g = in.next();
			familyMembers[i] = g;
		}
		//Prints list with last names
		for(int i=0;i<familyMembers.length;i++) {
			System.out.print(familyMembers[i]+" ");
		}
	}
}
