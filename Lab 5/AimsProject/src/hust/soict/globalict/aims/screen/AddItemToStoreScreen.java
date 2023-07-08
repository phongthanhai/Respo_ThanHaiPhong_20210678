package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public abstract class AddItemToStoreScreen extends JFrame {
	private String mediaType;
	
	JTextField titleInput;
	JTextField categoryInput;
	JTextField costInput;
	
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
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
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,2));

		JLabel title = new JLabel("Title");
		titleInput = new JTextField();
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER); // center the label
		title.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // add a border

		JLabel category = new JLabel("Category");
		categoryInput = new JTextField();
		category.setFont(new Font(category.getFont().getName(), Font.PLAIN, 30));
		category.setHorizontalAlignment(SwingConstants.CENTER); // center the label
		category.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // add a border

		JLabel cost = new JLabel("Cost");
		costInput = new JTextField();
		cost.setFont(new Font(cost.getFont().getName(), Font.PLAIN, 30));
		cost.setHorizontalAlignment(SwingConstants.CENTER); // center the label
		cost.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // add a border
		
		// Set the font size of the JTextField to 30
		titleInput.setFont(new Font(titleInput.getFont().getName(), Font.PLAIN, 30));
		categoryInput.setFont(new Font(categoryInput.getFont().getName(), Font.PLAIN, 30));
		costInput.setFont(new Font(costInput.getFont().getName(), Font.PLAIN, 30));
	
		center.add(title);
		center.add(titleInput);

		center.add(category);
		center.add(categoryInput);

		center.add(cost);
		center.add(costInput);

		return center;
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		 JLabel title = new JLabel("Add "+mediaType+" to STORE");
		 title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		 title.setForeground(Color.CYAN);
		 
		 header.add(Box.createRigidArea(new Dimension(10, 10)));
		 header.add(title);
		  
		 return header;
	}
}

