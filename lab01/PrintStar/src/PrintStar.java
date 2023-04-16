import java.util.Scanner;

public class PrintStar {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter n:");
		int n = sc.nextInt();
		for(int i=1; i<=n;i++)
		{
			for(int k=n;k>=i;k--)
			{
				System.out.printf(" ");
			}
			
			int m = 2*i - 1;
			
			for(int j=1;j<=m;j++)
			{
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
}
