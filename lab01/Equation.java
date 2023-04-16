package test;

import java.util.Scanner;
import java.math.*;

public class Equation {
	
	public void first_degree_eqn(double a1,double b1) {

		double result=0;
		
		System.out.println("Solving the linear eqn: ax+b=0 ");
	
		if(a1==0 && b1==0) {
			System.out.println("The equation has infinite solution.");
			
		}else if(a1==0 && b1!=0) {
			System.out.println("The equation has no solution.");
		}else {
			result = -b1/a1;
			System.out.println("The equation has one solution: x = -b/a =" + result);
		}
		
		
	}
	
	public void system_two_linear_eqn(double a11,double a12,double b1,double a21,double a22,double b2) {
		System.out.println("Solving system of linear equation:");
		System.out.println("a11 * x1 + a12 * x2 = b1 ");
		System.out.println("a21 * x1 + a22 * x2 = b2 ");
		if( ((a11*a11 + a12*a12) == 0)||((a21*a21 + a22*a22) == 0) ) {
			System.out.println("Not a system of linear equation!");
			return;
		}
		double d  = a11*a22 - a21*a12;
		double d1 = b1*a22 - b2*a12;
		double d2 = a11*b2 - a21*b1;
		if((d == 0) && (d1!=0)) {
			System.out.println("The equation has no solution");
			return;
			
		}else if(d == 0 && d1==0) {
			System.out.println("The equation has infinite solution");
			return;
			
		}else {
			
			
			double x1 = d1/d;
			double x2 = d2/d;
			
			System.out.println("The system have one solution:");
			System.out.println("x1 = "+x1);
			System.out.println("x2 = "+x2);
			return;
		}
		
		
	}
	
	public void second_degree_eqn(double a, double b, double c) {
		System.out.println("Solving the second degree equation with one variable");
		System.out.println("ax^2 + bx + c = 0");
		
		if(a==0) {
			System.out.println("Not a second degree equation.");
			return;
		}
		
		double delta = b*b -4*a*c;
		
		if(delta < 0) {
			System.out.println("The equation has no solution");
			
		}else if(delta ==0) {
			System.out.println("The equation has double solution:");
			System.out.println("x1 = x2 = "+ (-b/(2*a)));
		}else {
			System.out.println("The equation has 2 distinct solution:");
			System.out.println("x1 = "+ ((-b + Math.sqrt(delta)) /(2*a)));
			System.out.println("x2 = "+ ((-b - Math.sqrt(delta)) /(2*a)));
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Choose an option:");
		System.out.println("(1) Solve first degree linear equation");
		System.out.println("(2) Solve first degree system of two linear equation");
		System.out.println("(3) Solve second degree system ");
		
		Equation eq =  new Equation();
		int choice = 0;
		boolean isRunning=true;
		
		while(isRunning) {
			
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			
			choice = sc.nextInt();
	
			switch(choice) {
				case 1:
					double a = 0;
					double b = 0;
					System.out.println("Enter a:");
					a = sc.nextDouble();
					System.out.println("Enter b:");
					b = sc.nextDouble();
					
					eq.first_degree_eqn(a, b);
					
					break;
				
				case 2:
					double a11=0;
					double a12=0;
					double a21=0;
					double a22=0;
					double b1=0;
					double b2=0;
					
					System.out.println("Enter a11:");
					a11=sc.nextDouble();
					System.out.println("Enter a12:");
					a12=sc.nextDouble();
					System.out.println("Enter a21:");
					a21=sc.nextDouble();
					System.out.println("Enter a22:");
					a22=sc.nextDouble();
					System.out.println("Enter b1:");
					b1=sc.nextDouble();
					System.out.println("Enter b2:");
					b2=sc.nextDouble();
					
					eq.system_two_linear_eqn(a11, a12, b1, a21, a22, b2);
					
					
					break;
					
				case 3:
					a=0;
					b=0;
					double c=0;
					
					System.out.println("Enter a:");
					a = sc.nextDouble();
					System.out.println("Enter b:");
					b = sc.nextDouble();
					System.out.println("Enter c:");
					c = sc.nextDouble();
					eq.second_degree_eqn(a, b, c);
					
					
					
					break;
									
				case 4:
					isRunning=false;
					break;
					
				default:
					System.out.println("Invalid Choice!");
			}
			
			
		}
		
	}

}
