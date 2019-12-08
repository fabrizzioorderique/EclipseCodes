import java.util.*;
import javax.swing.JOptionPane;
import SnakeGame.Entity; //class from another package within the project = packageName.className   
import MathPacket.Gcf;  //In order to use a class from another project, you have to put the project in the java path dependency
import MathPacket.Matrices;	

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
	
	//main
	public static void main(String[] args) {
		
	}
	
}
