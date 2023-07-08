package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost()+ "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btn = new ButtonListener();
		
		JButton addButton = new JButton("Add to cart");
		addButton.addActionListener(btn);
		
		JButton playButton = new JButton("Play");
		playButton.addActionListener(btn);
		
		container.add(addButton);
		if(media instanceof Playable) {
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String action = e.getActionCommand();
			if(action.equals("Add to cart")) {
				CartScreen.getCart().addMedia(media);
			}
			else if(action.equals("Play")) {
				System.out.println("CLicked");
				JDialog playScreen = new JDialog();
				playScreen.setTitle("Information");
				
				JLabel content = new JLabel(media.toString());
				content.setHorizontalAlignment(SwingConstants.CENTER);
				playScreen.add(content);

				playScreen.setSize(400,400);
				playScreen.setVisible(true);
			}
		}
		
	}
}