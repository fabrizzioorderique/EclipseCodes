/**
* Use this class to manipulate matrices
* Program features: 
* 
* @author Piero Orderique
* @version 1
* @date 8/17/19
*
*/
package MathPacket;
public class Matrices {
	private static double[][] mainMatrix,matrix1,matrix2;
	
	public void setMatrix(double[][] matrix){
		mainMatrix = matrix;
	}
	
	public void printMatrix(double[][] matrix){
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public double getDeterminant(double[][] matrix) {
		double answer = 0;
		//checks to see that it is a square matrix
		if(matrix[0].length != matrix.length) {
			System.out.println("Error finding determinant. Returned zero.");
			return 0;
		//determinant of simple 2x2
		}else if(matrix.length == 2){
			return (matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]);
		//determinant of NxN where N > 2
		}else {
			int C;
			int sign = 1;
			for(int col = 0; col < matrix[0].length; col++) {
				//makes the subMatrix
				double[][] subMatrix = new double[matrix[0].length - 1][matrix.length - 1];
				for(int r = 1; r < matrix.length; r++) {
					C = 0;
					for(int c = 0; c < matrix[0].length; c++) {
						if(c == col) {}
						else {
							subMatrix[r-1][C] = matrix[r][c];
							C++;
						}
					}
				}
				answer += (matrix[0][col] * getDeterminant(subMatrix) * sign);
				sign *= -1;
			}
		}
		return answer;
	}
	
	public double[][] transpose(double[][] matrix) {
		double[][] answer = new double[matrix[0].length][matrix.length];
		for(int row = 0; row < answer.length; row++) {
			for(int col = 0; col < answer[row].length; col++) {
				answer[row][col] = matrix[col][row];
			}
		}
		return answer;
	}
	
	public double[][] addMatrices(double[][] m1, double[][] m2){
		double[][] answer = new double[m1.length][m1[0].length];
		//checks to see if they are same dimension
		if(m1.length != m2.length || m1[0].length != m2[0].length) {
			System.out.println("Error finding determinant. Returned zero matrix.");
			return answer;
		}
		for(int row = 0; row < answer.length; row++) {
			for(int col = 0; col < answer[row].length; col++) {
				answer[row][col] = (m1[row][col] + m2[row][col]);
			}
		}
		return answer;
	}
	
	public double[][] subtractMatrices(double[][] m1, double[][] m2){
		double[][] answer = new double[m1.length][m1[0].length];
		//checks to see if they are same dimension
		if(m1.length != m2.length || m1[0].length != m2[0].length) {
			System.out.println("Error finding determinant. Returned zero matrix.");
			return answer;
		}
		for(int row = 0; row < answer.length; row++) {
			for(int col = 0; col < answer[row].length; col++) {
				answer[row][col] = (m1[row][col] - m2[row][col]);
			}
		}
		return answer;
	}
	
	public double[][] multiplyMatrix(double c, double[][] matrix){
		double[][] answer = new double[matrix[0].length][matrix.length];
		for(int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				answer[row][col] = matrix[row][col] * c;
			}
		}
		return answer;
	}
	
	public double[][] multiplyMatrices(double[][] m1, double[][] m2){
		double[][] answer;
		//checks to see if multiplication is possible
		if(m1[0].length != m2.length) { 
			System.out.println("Error multiplying matrices. Returned zero matrix."); 
			answer = new double[m1[0].length][m1[0].length];
			return answer;			}
		answer = new double[m1.length][m2[0].length]; 
		return answer;
	}
}