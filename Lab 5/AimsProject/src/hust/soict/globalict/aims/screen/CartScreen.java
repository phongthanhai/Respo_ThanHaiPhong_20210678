package hust.soict.globalict.aims.screen;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.media.*;

public class CartScreen extends JFrame {
	
	private static Cart cart = new Cart();
	
	
	public static Cart getCart() {
		return cart;
	}
	public CartScreen() {
		super();
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setSize(1024, 768);
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		cart.add(new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 120, 10.99f));
		cart.add(new DigitalVideoDisc("Star Wars: A New Hope", "Sci-Fi", "George Lucas", 121, 9.99f));
		cart.add(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 178, 12.99f));
		
		cart.add(new Book("To Kill a Mockingbird", "Fiction", 8.99f));
		cart.add(new Book("The Hunger Games", "Young Adult", 12.99f));
		cart.add(new Book("The Da Vinci Code", "Mystery", 10.99f));

		
		ArrayList<Track> cd1Tracks = new ArrayList<>();
		cd1Tracks.add(new Track("Track 1", 3.30f));
		cd1Tracks.add(new Track("Track 2", 4.20f));
		cd1Tracks.add(new Track("Track 3", 5.15f));
		cart.add(new CompactDisc("Album 1", "Rock", 15.99f, "Led Zeppelin", cd1Tracks));
		
		ArrayList<Track> cd2Tracks = new ArrayList<>();
		cd2Tracks.add(new Track("Track 1", 3.50f));
		cd2Tracks.add(new Track("Track 2", 4.10f));
		cd2Tracks.add(new Track("Track 3", 4.45f));
		cart.add(new CompactDisc("Album 2", "Pop", 12.99f, "Taylor Swift", cd2Tracks));

		ArrayList<Track> cd3Tracks = new ArrayList<>();
		cd3Tracks.add(new Track("Track 1", 4.00f));
		cd3Tracks.add(new Track("Track 2", 5.20f));
		cd3Tracks.add(new Track("Track 3", 6.45f));
		cart.add(new CompactDisc("Album 3", "Electronic", 9.99f, "Daft Punk", cd3Tracks));
		new CartScreen();
	}
	
}