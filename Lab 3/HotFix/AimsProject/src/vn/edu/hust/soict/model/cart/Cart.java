package vn.edu.hust.soict.model.cart;

import vn.edu.hust.soict.model.digitalvideodisc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(disc == null) {
			return;
		}else {
			if(this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("Cannot add more item. Maximum amount of DVD in a cart reached! ");
			}else {
				this.itemsOrdered[qtyOrdered]=disc;
				this.qtyOrdered++;
				
			}
		}
		
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		
		
		for(int i=0; i < dvdList.length ; i++ ) {
			
				addDigitalVideoDisc(dvdList[i]);
		}
		
	}
	

	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc ... list) {
		for(DigitalVideoDisc element:list) {
			addDigitalVideoDisc(element);
		}
	}
	*/
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
		
	}
	
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc){
	
		
		int index = searchIndex(disc);
		if(index == Integer.MIN_VALUE) {
			System.out.println("Remove failed. Cannot find disc in cart");
			return; 
		} 
		for(int i = index; i < qtyOrdered - 1; i++){
	        itemsOrdered[i] = itemsOrdered[i+1];
	    }
		qtyOrdered--;
		
	}
	/**
	 * Helper method for finding the relevant index index of the Object DigitalVideoDisc to be deleted  
	 * @return index of the Object DigitalVideoDisc to be deleted.
	 * @throws Exception
	 */
	public int searchIndex(DigitalVideoDisc disc){
	
		for(int i=0 ;i < qtyOrdered;i++) {
			if(itemsOrdered[i].getTitle().contentEquals(disc.getTitle()) ) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public float totalCost() {
		float total=0f;
		for(int i = 0; i < qtyOrdered ; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void ListOfDVDs() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println(itemsOrdered[i].getTitle());
		}
	}
	
	public void viewCart() {
		System.out.println("**************************CART************************* ");
		System.out.println("Ordered Items:");
		
		
		
		for(int i=0; i< this.qtyOrdered;i++) {
			if(this.itemsOrdered[i] != null) {
				System.out.println(this.itemsOrdered[i]);
			}
		}
		
		System.out.println("Total Cost: " + totalCost());
		System.out.println("******************************************************* ");
	}
	
	public void searchByID(int id) {
		boolean isFound = false;
		
		for(int i = 0; i < this.qtyOrdered ; i++) {
			if(this.itemsOrdered[i].getID() ==id) {
				isFound = true;
			}
		}
		
		if(isFound) {
			System.out.println(this.itemsOrdered[id-1]);
		}else {
			System.out.println("No such item with id = " + id);
		}
		
	}
	
	public void searchByTitle(String title) {
		boolean isFound = false;
		int index = 0;
		for(int i = 0; i < this.qtyOrdered ; i++) {
			if(this.itemsOrdered[i].isMatch(title)) {
				isFound = true;
				index = i;
			}
		}
		
		if(isFound) {
			System.out.println(this.itemsOrdered[index]);
		}else {
			System.out.println("No such item with title = " + title);
		}
	}
	
	
	
	
	
	
}
