import java.util.Scanner;

public class DisplayDay {
	
	public static boolean checkLeap(int year) {
		if(year % 400 == 0) {
			return true;
		}else if(year % 100 == 0) {
			return false;
		}else if(year % 4 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkJan(String month) {
		if(month.equals("January")||month.equals("Jan.")||month.equals("Jan")||month.contentEquals("1")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkFeb(String month) {
		if(month.equals("February")||month.equals("Feb.")||month.equals("Feb")||month.equals("2")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkMar(String month) {
		if(month.equals("March")||month.equals("Mar.")||month.equals("Mar")||month.equals("3")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkApr(String month) {
		if(month.equals("April")||month.equals("Apr.")||month.equals("Apr")||month.equals("4")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkMay(String month) {
		if(month.equals("May")||month.equals("5")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDec(String month) {
		if(month.equals("December")||month.equals("Dec.")||month.equals("Dec")||month.equals("12")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkJune(String month) {
		if(month.equals("June")||month.equals("Jun")||month.equals("6")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkJuly(String month) {
		if(month.equals("July")||month.equals("Jul")||month.equals("7")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkAug(String month) {
		if(month.equals("August")||month.equals("Aug.")||month.equals("Aug")||month.equals("8")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOct(String month) {
		if(month.equals("October")||month.equals("Oct.")||month.equals("Oct")||month.equals("10")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSep(String month) {
		if(month.equals("September")||month.equals("Sept.")||month.equals("Sep")||month.equals("9")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkNov(String month) {
		if(month.equals("November")||month.equals("Nov.")||month.equals("Nov")||month.equals("11")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		boolean isRunning =  true ;
		
		while(isRunning) {
			System.out.println("Enter month and year(separate by a space))");
			String rawInput = sc.nextLine();
			String[] monthAndYear= rawInput.split(" ");
			
			String month=monthAndYear[0];
			String year = monthAndYear[1];
			
			int yearNum = Integer.parseInt(year);
			if(yearNum<0) {
				System.out.println("Invalid year. Please Enter Again");
				continue;
			}
			
			if(checkJan(month)||checkMar(month)||checkMay(month)||checkJuly(month)||
					checkAug(month)||checkOct(month)||checkDec(month)) {
				
				System.out.println("31 days");
				isRunning=false;
			}else if(checkFeb(month)) {
				if(checkLeap(yearNum)) {
					System.out.println("29 days");
					isRunning=false;
				}else {
					System.out.println("28 days");
					isRunning=false;
				}
			}else if(checkApr(month)||checkJune(month)||checkSep(month)||checkNov(month)) {
				System.out.println("30 days");
				isRunning=false;
			}else {
				System.out.println("Wrong month entered! Please enter again!");
				continue;
			}
			
		}
		
		
			
	}
	
	

	public static void main(String[] args) {
		DisplayDay.menu();
		
	}

}
