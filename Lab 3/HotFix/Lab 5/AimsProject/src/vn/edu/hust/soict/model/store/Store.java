package vn.edu.hust.soict.model.store;

import java.util.ArrayList;

import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.model.media.Media;

public class Store {
	
	public Store(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	private static final int CAPACITY = 100;
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<Media>(CAPACITY);
	}
	
	public void addMedia(Media newMedia) {
		if(itemsInStore.contains(newMedia)) {
			System.out.println("Media: " + " already existed!");
			return;
		}
		itemsInStore.add(newMedia);
		System.out.println("Media: " + " is added!");
	}
	
	public void removeMedia(Media media) {
		if(!itemsInStore.contains(media)) {
			System.out.println("Media: "+ " does not exist!");
			return;
		}
		
		itemsInStore.remove(media);
		System.out.println("Media: " + " is removed!");
	}
	
	public void viewStore() {
		System.out.println("**************************Store************************* ");
		System.out.println("Items In Store:");
		
		for(Media media: itemsInStore) {
			System.out.println(media);
		}
		
		System.out.println("******************************************************* ");
	}
	
	public Media searchByTitle(String title) {
		
	    for (Media media : itemsInStore) {
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
	    	this.itemsInStore.remove(media);
	    	return true;
	    }
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}
	
	
}
