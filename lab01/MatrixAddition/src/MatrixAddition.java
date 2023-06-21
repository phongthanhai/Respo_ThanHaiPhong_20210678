import java.util.Scanner;

public class MatrixAddition {
	
	public int[][] addTwoMatrices(int[][] first,int [][] second,int row,int col) {
		int[][] sum = new int[row][col];
		
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				sum[i][j] = first[i][j] + second[i][j];
			}
		}
		
		return sum;
		
	}
	
	public void printMatrix(int[][] mat,int row,int col) {
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				System.out.print(mat[i][j] + "   ");
				if(j == col - 1){
					System.out.println();
					System.out.println();
					
				}
				
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		int rowNum;
		int colNum;
		int[][] mat1 = null;
		int[][] mat2 = null;
		
		MatrixAddition obj = new MatrixAddition();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter number of rows:");
		rowNum = sc.nextInt();
		System.out.println("Enter number of columns:");
		colNum = sc.nextInt();
		
		mat1 = new int[rowNum][colNum];
		mat2 = new int[rowNum][colNum];
		
		for(int i=0; i < rowNum; i++) {
			for(int j=0; j < colNum; j++) {
				System.out.println("Enter a"+ (i+1) + (j+1));
				mat1[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("First Matrix");
		obj.printMatrix(mat1, rowNum, colNum);
		
		for(int i=0; i < rowNum; i++) {
			for(int j=0; j < colNum; j++) {
				System.out.println("Enter b"+ (i+1) + (j+1));
				mat2[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("Second Matrix");
		obj.printMatrix(mat2, rowNum, colNum);
		
		int[][] result = new int[rowNum][colNum];
		
		result=obj.addTwoMatrices(mat1, mat2, rowNum, colNum);
		System.out.println("Sum Matrix is");
		obj.printMatrix(result, rowNum, colNum);
	}
}
