import MathPacket.Gcf;  //In order to use a class from another project, you have to put the project in the java path dependency
import MathPacket.Matrices;
import SocialSecurityProject.NameRecord1;
import Josephus.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TestRunner {
	
	//Example uses of my math programs
	public static void runGcf() {
		Gcf g = new Gcf(5,3);
		System.out.println(g.calculateGcf(8,4));
	}
	public static void runMatrices() {
		//creates an object of the class
		Matrices m = new Matrices();
		
		//initializes test variables
		double[][] my2x2 = new double[][] {
			{1,2},
			{3,4},
		};
		double[][] my3x3 = new double[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9},
		};
		double[][] my3x2 = new double[][] {
			{3,2},
			{2,3},
			{1,5},
		};
		double[][] my4x4 = new double[][] {	//determinant 1030
			{6,5,17,2},
			{5,6,7,8},
			{9,10,6,12},
			{13,14,15,6}
		};
		double[][] myNew3x3 = m.multiplyMatrix(2,my3x3);
		
		//actual testing
		//m.printMatrix(m.multiplyMatrices(my3x3, my3x2));
		//System.out.println(m.getDeterminant(my4x4));
		//m.printMatrix(m.transpose(my3x2));
		m.printMatrix(m.subtractMatrices(my3x3,myNew3x3));
	}	
	
	static ArrayList<NameRecord1> nameData = new ArrayList<>(11);
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\namedata.txt");
		createData(file);
	}
	public static void createData(File f) throws Exception {
		String currentLine;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){ 
			currentLine = sc.nextLine();
            nameData.add(new NameRecord1(currentLine));
        }
		testArrayData(nameData);
	}
	public static void testArrayData(ArrayList<NameRecord1> arr) {
		for(NameRecord1 n : arr) {
			System.out.print(n.getName()+" ");
			n.printRanks();
			System.out.println();
		}
	}
}