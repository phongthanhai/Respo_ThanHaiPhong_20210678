package vn.edu.hust.soict.test.carttest;

import java.awt.List;
import java.util.ArrayList;

import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.media.Book;
import vn.edu.hust.soict.model.media.CompactDisc;
import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.media.Track;

public class CartTest {
	
	public static void main(String[] args) {
		Cart cart=new Cart();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Aladdin", "Animation", "Disney", 120, 87.5f);
		
		Book book = new Book(1,"IT","Horror",19.5f);
		book.addAuthor("Stephen King");
		book.addAuthor("Victor Mayes");
		
		CompactDisc cd = new CompactDisc(2, "EDM Collection","Music",20.25f);
		Track track1 = new Track("Animals",20);
		cd.addTrack(track1);
		Track track2 = new Track("Turn Up The Speakers",20);
		cd.addTrack(track2);
		
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);
		
		for(Media e: cart.getItemsOrdered()) {
			System.out.println(e);
		}
		
	}
	
	
}
