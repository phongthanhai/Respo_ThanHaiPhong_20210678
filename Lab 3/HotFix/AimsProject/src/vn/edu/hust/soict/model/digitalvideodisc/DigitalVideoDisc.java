package vn.edu.hust.soict.model.digitalvideodisc;

public class DigitalVideoDisc {
	
	private static int nbDigitalVideoDiscs = 0; 
	
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public String toString() {
		return this.id + ". DVD" + " - " + this.title + " - " + this.category +
				" -  " + this.director + " - " + this.length + ": " + this.cost + " $";
	}
	
	public boolean isMatch(String title) {
		if(this.title.contentEquals(title)) {
			return true;
		}
		
		return false;

	}
	
	
	
	

}
