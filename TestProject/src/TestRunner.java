import MathPacket.Gcf;  //In order to use a class from another project, you have to put the project in the java path dependency
import MathPacket.Matrices;
import Josephus.*;
import java.io.File;
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
	
	 //"C:\\Users\\3223027017\\Documents\\PieroBio.txt"
    //"C:\\Users\\3223027017\\Documents\\namedata.txt"
   //"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\familydata.txt”
    static String name;
    static String ranks;
    public static void main(String[] args) throws Exception{
        
        File file = new File("C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\familydata.txt"); 
        Scanner sc = new Scanner(file); 
        // we just need to use \\Z as delimiter 
        sc.useDelimiter("\\Z"); 
      
        System.out.println(sc.next());
        
    } 
    public static void printLine(String aLine){
        System.out.println(aLine);    
    }
    public static void breakString(String l){
        int firstSpace = l.indexOf(" ");
        name = l.substring(0,firstSpace);
        ranks = l.substring(firstSpace + 1);
    }
    public static void printArray(String[] arr){
        for(String n : arr) System.out.print(n + " ");
    }

}