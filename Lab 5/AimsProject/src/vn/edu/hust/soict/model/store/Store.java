package vn.edu.hust.soict.model.store;

import java.util.ArrayList;
import java.util.Scanner;

import vn.edu.hust.soict.model.media.Book;
import vn.edu.hust.soict.model.media.CompactDisc;
import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.model.media.Media;

public class Store {
	private ArrayList<Media> items; 
	private static Scanner scanner = new Scanner(System.in);
	private static final int CAPACITY = 100;
	
	public Store() {
		items = new ArrayList<Media>(CAPACITY);
	}
	
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (items.isEmpty()) {
            sb.append("The store is empty!");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Media media = items.get(i);
                sb.append((i + 1) + ". ID:" + media.getId() + ": "
                        + media.getTitle() + "-"
                        + media.getCategory() + "-" + media.getCost() + "$\n");
            }
        }
        return sb.toString();
    }
	
	public void removeMedia(Media media) {
		if(!items.contains(media)) {
			System.out.println("Media: "+ " does not exist!");
			return;
		}
		
		items.remove(media);
		System.out.println("Media: " + " is removed!");
	}
	
	public void viewStore() {
		System.out.println("**************************Store************************* ");
		System.out.println("Items In Store:");
		
		for(Media media: items) {
			System.out.println(media);
		}
		
		System.out.println("******************************************************* ");
	}
	
	public Media searchByTitle(String title) {
		
	    for (Media media : items) {
	        if (media.getTitle().contentEquals(title)) {
	            return media;
	        }
	    }
	    
	    return null;
	}
	
	public boolean removeMedia(String title) {
	    Media media = this.searchByTitle(title);
	    if(media==null) {
	    	return false;
	    }else {
	    	this.items.remove(media);
	    	return true;
	    }
	}

	public ArrayList<Media> getItemsInStore() {
		return items;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.items = itemsInStore;
	}
	
	public void add(DigitalVideoDisc digitalVideoDisc) {
		items.add(digitalVideoDisc);
	}

	public void add(Book book) {
		// TODO Auto-generated method stub
		items.add(book);
	}

	public void add(CompactDisc compactDisc) {
		// TODO Auto-generated method stub
		items.add(compactDisc);
	}

	public void addMedia(Media media) {
		// TODO Auto-generated method stub
		if(!items.contains(media))
		items.add(media);
	}
	
	
}
