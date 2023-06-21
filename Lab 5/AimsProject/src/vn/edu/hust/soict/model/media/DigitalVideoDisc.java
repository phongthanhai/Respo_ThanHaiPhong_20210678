package vn.edu.hust.soict.model.media;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{
	
	private static int nbDigitalVideoDiscs = 0; 
	
	private String director;
	private int length;
	
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs++,title,category,cost);
		
		this.director = director;
		this.length = length;
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		setId(DigitalVideoDisc.nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		setId(DigitalVideoDisc.nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,cost);
		this.director = director;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		setId(DigitalVideoDisc.nbDigitalVideoDiscs);
	}
	
	public boolean isMatch(String title) {
		if(getTitle().contentEquals(title)) {
			return true;
		}
		return false;

	}
	
	public static DigitalVideoDisc createDVD() {
		
		System.out.println("Choose type of DVD:");
		System.out.println("1. DigitalVideoDisc(title,category,director,length,cost) ");
		System.out.println("2. DigitalVideoDisc(title)");
		System.out.println("3. DigitalVideoDisc(title,category,cost)");
		System.out.println("4. DigitalVideoDisc(title,category,director,cost)");
		System.out.println("Choose 1,2,3,4");
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Invalid choice");
		}
		
		option = sc.nextInt();
		
		String rawInput=null;
		String input[] = null;
		DigitalVideoDisc dvd1 = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		switch(option) {
		
			case 1:
				System.out.println("Enter title, category, director, length, cost (Separated by \",\")");
				try {
					rawInput = reader.readLine();
					input = rawInput.split(",");
					dvd1 = new DigitalVideoDisc(input[0],input[1],input[2],Integer.parseInt(input[3]),Float.parseFloat(input[4]));
					
					System.out.println("-----------------------------");
					System.out.println("Choose an option:");
					System.out.println("1. Add a media to the store");
					System.out.println("2. Remove a media from the store");
					System.out.println("3. Go back");
					System.out.println("-----------------------------");
					
					return dvd1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				
				System.out.println("Enter title");
			try {
				rawInput = reader.readLine();
				dvd1 = new DigitalVideoDisc(rawInput);
				
				System.out.println("-----------------------------");
				System.out.println("Choose an option:");
				System.out.println("1. Add a media to the store");
				System.out.println("2. Remove a media from the store");
				System.out.println("3. Go back");
				System.out.println("-----------------------------");
				
				return dvd1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			
			case 3:
				System.out.println("Enter title, category, cost (Separated by \",\")");
			try {
				rawInput = reader.readLine();
				input = rawInput.split(",");
				dvd1 = new DigitalVideoDisc(input[0],input[1],Float.parseFloat(input[2]));
				
				System.out.println("-----------------------------");
				System.out.println("Choose an option:");
				System.out.println("1. Add a media to the store");
				System.out.println("2. Remove a media from the store");
				System.out.println("3. Go back");
				System.out.println("-----------------------------");
				
				return dvd1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;

			case 4:
				System.out.println("Enter title,category,director,cost (Separated by \",\")");
			try {
				rawInput = reader.readLine();
				input = rawInput.split(",");
				
				dvd1 = new DigitalVideoDisc(input[0],input[1],input[2],
						Float.parseFloat(input[3]));				
				System.out.println("-----------------------------");
				System.out.println("Choose an option:");
				System.out.println("1. Add a media to the store");
				System.out.println("2. Remove a media from the store");
				System.out.println("3. Go back");
				System.out.println("-----------------------------");
				
				return dvd1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
				
			default:
				System.out.println("Failed to create!");
				return null;
				
				
		}
		return dvd1;
		
		
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
        System.out.println("DVD length: " + this.getLength()); 
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	

}
