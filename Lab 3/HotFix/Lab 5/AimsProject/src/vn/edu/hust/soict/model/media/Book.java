package vn.edu.hust.soict.model.media;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	
	public Book(int id, String title,String category,float cost) {
		super(id,title,category,cost);
	}
	
	public Book(int id, String title,String category,float cost,ArrayList<String> authors) {
		super(id,title,category,cost);
		this.authors=authors;
	}

	public List<String> getAuthors() {
		return authors;
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author: "+ authorName + " already existed!");
			return;
		}
		authors.add(authorName);
		System.out.println("Author: "+ authorName + " is added!");
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("Author: "+ authorName + " does not exist!");
			return;
		}
		
		authors.remove(authorName);
	}
	
	public String showAuthors() {
		String authors = String.join(", ", this.authors);
		return authors;
	}
	
	public String toString() {
		return super.toString() + " Author: "+ showAuthors() ;
	}
	
	public static Book createBook() {
		System.out.println("Choose type of book:");
		System.out.println("1. Book(id,title,category,cost) ");
		System.out.println("2. Book(id,title,category,cost,List of authors)");
		System.out.println("Choose 1 or 2");
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid choice");
		}
		option = sc.nextInt();
		
		String rawInput=null;
		String input[] = null;
		Book book1 = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		switch(option) {
		
			case 1:
				System.out.println("Enter id, title, category, cost (Separated by \",\")");
			try {
				
				rawInput = reader.readLine();
				input = rawInput.split(",");
				int id = Integer.parseInt(input[0]);
				String title = input[1];
				String category = input[2];
				float cost = Float.parseFloat(input[3]);
				book1 = new Book(id,title,category,cost);
				
				System.out.println("-----------------------------");
				System.out.println("Choose an option:");
				System.out.println("1. Add a media to the store");
				System.out.println("2. Remove a media from the store");
				System.out.println("3. Go back");
				System.out.println("-----------------------------");
				
				return book1;
				
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
			
				int id = Integer.parseInt(input[0]);
				String title = input[1];
				String category = input[2];
				float cost = Float.parseFloat(input[3]);
				
				book1 = new Book(id,title,category,cost);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				System.out.println("Enter author name(Separate by , )");
			try {
				rawInput = reader.readLine();
				input = rawInput.split(",");
				for(int i = 0; i< input.length ; i++) {
					book1.addAuthor(input[i]);
				}
				
				System.out.println("-----------------------------");
				System.out.println("Choose an option:");
				System.out.println("1. Add a media to the store");
				System.out.println("2. Remove a media from the store");
				System.out.println("3. Go back");
				System.out.println("-----------------------------");
				
				return book1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				return null;
				
				
		}
		return book1;
		
		
	}
	
	

}
