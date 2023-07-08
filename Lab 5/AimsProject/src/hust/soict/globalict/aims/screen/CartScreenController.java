package hust.soict.globalict.aims.screen;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.media.Playable;

public class CartScreenController {
	
	private Cart cart;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private Label totalCost;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private ToggleGroup filterCategory;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		tblMedia.setItems(this.cart.getItemsOrdered());
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		totalCost.setText(String.format("%.2f", this.cart.totalCost())+"$");
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) 
					{
						if(newValue != null) {
							updateButtonBar(newValue);
						}
		}});
			
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {	
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	public void buttonRemovePress(ActionEvent event) {
		System.out.println("removed");
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(String.format("%.2f", this.cart.totalCost())+"$");
	}
	
	@FXML
    void placeOrderButtonPressed(ActionEvent event) {
	 	JDialog playScreen = new JDialog();
		playScreen.setTitle("Order");

		JLabel content = new JLabel("Ordered successfully");
		content.setHorizontalAlignment(SwingConstants.CENTER);
		playScreen.add(content);
		totalCost.setText("0$");
		this.cart.getItemsOrdered().clear();
		playScreen.setSize(400,400);
		playScreen.setVisible(true);
    }
	
	@FXML
    void playButtonPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
	 	JDialog playScreen = new JDialog();
		playScreen.setTitle("Information");

		JLabel content = new JLabel(media.toString());
		content.setHorizontalAlignment(SwingConstants.CENTER);
		playScreen.add(content);

		playScreen.setSize(400,400);
		playScreen.setVisible(true);
    }

    @FXML
    void viewCart(ActionEvent event) {
    }

    @FXML
    void viewStore(ActionEvent event) {
    	
    	new StoreScreen(StoreScreen.getStore());
    }
    
    @FXML
    void bookScreen(ActionEvent event) {
    	new AddBookToStoreScreen();
    }
    
    @FXML
    void cdScreen(ActionEvent event) {
    	new AddCompactDiscToStoreScreen();
    }

    @FXML
    void dvdScreen(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen();
    }
	
}
