package vn.edu.hust.soict.model.media;

public class Disc extends Media {
	private String director;
	private float length;
	
	public Disc(int id, String title,String category,String director,float cost, float length) {
		// TODO Auto-generated constructor stub
		super(id,title,category,cost);
		this.director=director;
		this.length=length;
	}
	
	public Disc(int id,String title,String category,float cost) {
		super(id,title,category,cost);
	}
	
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title,String category,float cost) {
		super(title,category,cost);
	}

	public String getDirector() {
		return director;
	}

	public float getLength() {
		return length;
	}
	
	@Override
	public String toString() {
		return super.toString() + " ; Length: " + this.length + " ; Director: " + this.director;
	}

}
