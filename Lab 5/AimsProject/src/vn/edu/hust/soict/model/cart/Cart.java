package vn.edu.hust.soict.model.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vn.edu.hust.soict.model.media.Book;
import vn.edu.hust.soict.model.media.CompactDisc;
import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.media.MediaComparatorByTitleCost;
import vn.edu.hust.soict.model.media.Track;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 50;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	
	public void addMedia(Media newMedia) {
		if(itemsOrdered.contains(newMedia)) {
			System.out.println("Media: " + newMedia.getTitle() + " already existed!");
			return;
		}
		itemsOrdered.add(newMedia);
		System.out.println("Media: " + newMedia.getTitle() + " is added!");
	}
	
	public void removeMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			System.out.println("Media: "+ media.getTitle() + " does not exist!");
			return;
		}
		
		itemsOrdered.remove(media);
		System.out.println("Media: " + media.getTitle() + " is removed!");
	}
	
	public Media searchByTitle(String title) {
		
	    for (Media media : itemsOrdered) {
	        if (media.getTitle().contentEquals(title)) {
	            return media;
	        }
	    }
	    
	    return null;
	}
	
	public void viewCart() {
		System.out.println("**************************Cart************************* ");
		System.out.println("Items In Cart:");
		
		for(Media media: itemsOrdered) {
			System.out.println(media);
		}
		
		System.out.println("******************************************************* ");
	}


	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	
	public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public ArrayList<Media> filterByID(int id) {
        ArrayList<Media> filtered = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                filtered.add(media);
            }
        
        }
        for (Media media: filtered) {
        	System.out.println(media.toString());
        }
        return filtered;
    }

    public ArrayList<Media> filterByTitle(String title) {
    	
        ArrayList<Media> filtered = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                filtered.add(media);
            }
        }
        for (Media media: filtered) {
        	System.out.println(media.toString());
        }
        return filtered;
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    
    public void add(DigitalVideoDisc digitalVideoDisc) {
		itemsOrdered.add(digitalVideoDisc);
	}

	public void add(Book book) {
		// TODO Auto-generated method stub
		itemsOrdered.add(book);
	}

	public void add(CompactDisc compactDisc) {
		// TODO Auto-generated method stub
		itemsOrdered.add(compactDisc);
	}
	
	
	
}
