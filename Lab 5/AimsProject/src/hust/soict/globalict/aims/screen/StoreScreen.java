package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.store.Store;

public class StoreScreen extends JFrame {
	private static Store store = new Store();
	
	public static Store getStore() {
		return store;
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());		
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update store");
		
		JMenuItem book = new JMenuItem("Add Book");
		smUpdateStore.add(book);
		book.addActionListener(e -> {
			this.dispose();
			new AddBookToStoreScreen();
		});
		
		JMenuItem cd = new JMenuItem("Add CD");
		smUpdateStore.add(cd);
		cd.addActionListener(e -> {
			this.dispose();
			new AddCompactDiscToStoreScreen();
		});
		
		JMenuItem dvd = new JMenuItem("Add DVD");
		smUpdateStore.add(dvd);
		dvd.addActionListener(e -> {
			this.dispose();
			new AddDigitalVideoDiscToStoreScreen();
		});
		
		menu.add(smUpdateStore);
		JMenuItem viewStore = new JMenuItem("View Store");
		menu.add(viewStore);
		viewStore.addActionListener(e -> {
			this.dispose();
			new StoreScreen(StoreScreen.getStore());
			});
		JMenuItem viewCart = new JMenuItem("View Cart");
		menu.add(viewCart);
		viewCart.addActionListener(e -> {
			this.dispose();
			new CartScreen();
		});
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		 JLabel title = new JLabel("AIMS");
		 title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		 title.setForeground(Color.CYAN);
		 
		 JButton cart = new JButton("View Cart");
		 cart.setPreferredSize(new Dimension(100, 50));
		 cart.setMaximumSize(new Dimension(100, 50));
		 cart.addActionListener(e -> {
				this.dispose();
				new CartScreen();
			});
		 
		 header.add(Box.createRigidArea(new Dimension(10, 10)));
		 header.add(title);
		 header.add(Box.createHorizontalGlue());
		 header.add(cart);
		 header.add(Box.createRigidArea(new Dimension(10, 10)));
		  
		 return header;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	public StoreScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
