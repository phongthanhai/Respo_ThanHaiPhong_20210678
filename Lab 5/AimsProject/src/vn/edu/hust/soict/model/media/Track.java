package vn.edu.hust.soict.model.media;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Track implements Playable {
	private String title; 
	private float length;
	
	
	public Track(String title, float f) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.length=f;
	}


	public String getTitle() {
		return title;
	}


	public float getLength() {
		return length;
	}

	@Override
	public boolean equals(Object e) {
		if(e == this) {
			return true;
		}
		
		if(!(e instanceof Track)) {
			return false;
		}
		
		Track trk = (Track) e;
		return (this.title.contentEquals(trk.title))&& (this.length == trk.length);
	}
	
	public static Track createTrack() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String rawInput=null;
		String input[] = null;
		Track newTrack = null;
		
		System.out.println("Enter title,length (Separated by \",\")");
		try {
			rawInput = reader.readLine();
			input = rawInput.split(",");
			newTrack = new Track(input[0],Integer.parseInt(input[1]));
			return newTrack;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newTrack;
	}
	

	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle()); 
		System.out.println("Track length: " + this.getLength()); 
	}
	
	@Override
	public String toString() {
		return  "Title: " + this.title + " ; Length: " + this.length;
	}
	
	

}
