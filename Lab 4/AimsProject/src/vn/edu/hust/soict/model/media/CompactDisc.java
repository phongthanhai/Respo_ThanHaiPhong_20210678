package vn.edu.hust.soict.model.media;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title,String category,String director,float cost, int length,ArrayList<Track> tracks) {
		super(id,title,category,director,cost,length);
		this.tracks=tracks;
	}
	
	public CompactDisc(int id,String title,String category,float cost) {
		super(id,title,category,cost);
	}
	
	
	public void addTrack(Track newTrack) {
		if(tracks.contains(newTrack)) {
			System.out.println("Track: " + newTrack.getTitle() + " already existed!");
			return;
		}
		tracks.add(newTrack);
		System.out.println("Track: " + newTrack.getTitle() + " is added!");
	}
	
	public void removeTrack(Track newTrack) {
		if(!tracks.contains(newTrack)) {
			System.out.println("Track: "+ newTrack.getTitle() + " does not exist!");
			return;
		}
		
		tracks.remove(newTrack);
	}
	
	public int getLength() {
		int sum=0;
		for(Track e:tracks) {
			sum = sum + e.getLength();
		}
		return sum;
	}

	@Override
	public void play() {
		System.out.println("Number of tracks in current CD: "+this.tracks.size());
		System.out.println("Artist: "+this.artist);
		
		System.out.println("Playing tracks in current CD:");
		
		for(Track e:tracks) {
			e.play();
		}
		
	}
	
	public String viewTracks() {
		String output="";
		for(Track e:tracks) {
			output = output  + e.toString()+ " , ";
		}
		return output;
	}
	
	public static CompactDisc createCD() {
		
		System.out.println("Choose type of CD:");
		System.out.println("1. CompactDisc(id,title,category,director,cost,length,List of tracks) ");
		System.out.println("2. CompactDisc(id,title,category,cost))");
		System.out.println("Choose 1 or 2");
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid choice ! Enter Again");
		}
		option = sc.nextInt();
		
		String rawInput=null;
		String input[] = null;
		CompactDisc cd1 = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		switch(option) {
		
			case 1:
				ArrayList<Track> tracks = new ArrayList<Track>();
				
				System.out.println("Enter number of tracks:");
				
				while(!sc.hasNextInt()) {
					sc.nextLine();
					System.out.println("Invalid choice");
				}
				
				int num = sc.nextInt();
				int sumLength = 0;
				
				for(int i=0; i< num; i++) {
					System.out.println("Track: " + (i+1));
					tracks.add(Track.createTrack());
				}
				
				for(Track e: tracks) {
					sumLength += e.getLength();
				}
				
				System.out.println("Enter id, title, category,director, cost(Separated by \",\")");
				
				try {
					rawInput = reader.readLine();
					input = rawInput.split(",");
					cd1 = new CompactDisc(Integer.parseInt(input[0]),input[1],input[2],input[3],
							Float.parseFloat(input[4]),
							sumLength,tracks);
					System.out.println("-----------------------------");
					System.out.println("Choose an option:");
					System.out.println("1. Add a media to the store");
					System.out.println("2. Remove a media from the store");
					System.out.println("3. Go back");
					System.out.println("-----------------------------");
					return cd1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 2:
				System.out.println("Enter id, title, category, cost (Separated by \",\")");
				
				try {
					rawInput = reader.readLine();
					input = rawInput.split(",");
					cd1 = new CompactDisc(Integer.parseInt(input[0]),input[1],input[2],Float.parseFloat(input[3]));
					System.out.println("-----------------------------");
					System.out.println("Choose an option:");
					System.out.println("1. Add a media to the store");
					System.out.println("2. Remove a media from the store");
					System.out.println("3. Go back");
					System.out.println("-----------------------------");
					return cd1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			
			default:
				
					System.out.println("Failed to create");
					return null;
				
				
				
		}
		return cd1;
		
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " ; Artist: " + this.artist + " ; Tracks: " + this.viewTracks();
	}
	
	

}
