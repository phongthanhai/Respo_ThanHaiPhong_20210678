package test;

import java.util.Scanner;

public class Calculator {
	
	public double sum(double a, double b) {
		return a+b;
	}
	
	public double difference(double a, double b) {
		if(a>=b) {
			return a-b;
		}else {
			return b-a;
		}
	}
	
	public double product(double a,double b) {
		return a*b;
	}
	
	public double quotient(double dividend,double divisor) throws ArithmeticException {
		
		if(divisor==0) {
			throw new ArithmeticException("Arithmetic Exception");
		}else {
			return dividend/divisor;
		}
		
	}

	public static void main(String[] args) {
		Calculator cal=new Calculator();
		
		int choice=0;
		boolean isRunning=true;
		while(isRunning) {
			
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter 1 for addition");
			System.out.println("Enter 2 for difference");
			System.out.println("Enter 3 for product");
			System.out.println("Enter 4 for division");
			System.out.println("Enter 5 to exit");
			
			choice = sc.nextInt();
			double a=0;
			double b=0;
			double result;
			
			switch(choice) {
				case 1:
					System.out.println("Enter a:");
					a=sc.nextDouble();
					System.out.println("Enter b:");
					b=sc.nextDouble();
					
					result=cal.sum(a,b);
					System.out.println("Sum of: " + a + " and" +b + " is: " + result);
					break;
				
				case 2:
					System.out.println("Enter a:");
					a=sc.nextDouble();
					System.out.println("Enter b:");
					b=sc.nextDouble();
					
					result=cal.difference(a,b);
					System.out.println("Difference of :" + a + " and" +b + " is: " + result);
					break;
					
				case 3:
					System.out.println("Enter a:");
					a=sc.nextDouble();
					System.out.println("Enter b:");
					b=sc.nextDouble();
					
					result=cal.product(a,b);
					System.out.println("Product of:" + a + " and" +b + " is: " + result);
					break;
				
				case 4:
					System.out.println("Enter dividend: ");
					a=sc.nextDouble();
					System.out.println("Enter divisor: ");
					b=sc.nextDouble();
					
					try {
						result=cal.quotient(a, b);
						System.out.println(result);
						
					}catch(ArithmeticException e) {
						System.out.println("Divisor cannot be 0!");
						
						e.printStackTrace();
					}
					
					break;
				
				case 5:
					isRunning=false;
					break;
					
				default:
					System.out.println("Invalid Choice!");
			}
			
			
		}
	}
		
	
}
