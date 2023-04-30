package vn.edu.hust.soict.lab2.model;

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
	
	/*
	
	public void viewCart() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println("Object number "+(i+1)+" :"+itemsOrdered[i].getTitle());
		}
		
		System.out.println("Current quantity:"+this.qtyOrdered);
	}
	
	*/
	
	
}
