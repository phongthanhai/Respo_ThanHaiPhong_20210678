package vn.edu.hust.soict.test.carttest;

import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.digitalvideodisc.DigitalVideoDisc;

public class CartTest {
	
	public static void main(String[] args) {
		Cart cart=new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Alers", 87, 19.95f);
	    cart.addDigitalVideoDisc(dvd1);
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	    cart.addDigitalVideoDisc(dvd2);
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
	    cart.addDigitalVideoDisc(dvd3);
	    
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Insidious", "Horror",30.24f);
	    cart.addDigitalVideoDisc(dvd4);
	    
	    cart.viewCart();
	    
	    //Test search by id:
	    System.out.println("Search for id = 0 ");
	    cart.searchByID(0);
	    
	    System.out.println("Search for id = 4");
	    cart.searchByID(4);
	    //Test search by title:
	    System.out.println("Search for title: The lion king");
	    cart.searchByTitle("The Lion King");
	    
	    System.out.println("Search for title: Amnesia");
	    cart.searchByTitle("Amnesia");
	}
	
	
}
