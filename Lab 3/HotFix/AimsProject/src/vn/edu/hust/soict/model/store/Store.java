package vn.edu.hust.soict.model.store;

import vn.edu.hust.soict.model.digitalvideodisc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore ;
	private int qty = 0;
	private static final int CAPACITY = 100;
	
	public Store() {
		itemsInStore = new DigitalVideoDisc[CAPACITY];
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		if(disc == null) {
			return;
		}else {
			if(this.qty >= CAPACITY) {
				System.out.println("Cannot add more item. Maximum amount of DVD in a store reached! ");
			}else {
				this.itemsInStore[qty]=disc;
				this.qty++;
				
			}
		}
		
	}
	
public void removeDVD(DigitalVideoDisc disc){
	
		
		int index = searchIndex(disc);
		if(index == Integer.MIN_VALUE) {
			System.out.println("Remove failed. Cannot find disc in store");
			return; 
		} 
		for(int i = index; i < qty - 1; i++){
			itemsInStore[i] = itemsInStore[i+1];
	    }
		qty--;
		
	}
	/**
	 * Helper method for finding the relevant index index of the Object DigitalVideoDisc to be deleted  
	 * @return index of the Object DigitalVideoDisc to be deleted.
	 * @throws Exception
	 */
	public int searchIndex(DigitalVideoDisc disc){
	
		for(int i=0 ;i < qty;i++) {
			if(itemsInStore[i].getTitle().contentEquals(disc.getTitle()) ) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public void viewStore() {
		System.out.println("**************************Store************************* ");
		System.out.println("Items In Store:");
		
		
		
		for(int i=0; i< this.qty;i++) {
			if(this.itemsInStore[i] != null) {
				System.out.println(this.itemsInStore[i]);
			}
		}
		
		System.out.println("******************************************************* ");
	}
	
	
}
