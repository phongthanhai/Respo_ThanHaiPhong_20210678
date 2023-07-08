package vn.edu.hust.soict.model.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST 
	= new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE 
	= new MediaComparatorByCostTitle();

	public Media(int id, String title,String category,float cost) {
		this.id=id;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	
	public Media(String title) {
		this.title=title;
	}
	
	public Media(String title, String category, float cost) {
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	
	public Media(int id,String title,String category) {
		this.id=id;
		this.category=category;
		this.title=title;
	}
	
	@Override
	public boolean equals(Object e) {
		if(e == this) {
			return true;
		}
		
		if(!(e instanceof Media)) {
			return false;
		}
		
		Media med = (Media) e;
		return (this.title).contentEquals(med.title);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " ID: " + this.id + "; Title: " + this.title + "; Category: " 
				+ this.category + "; Cost: " + this.cost;
	}
	
	public boolean isMatch(String title) {
        if (this.title.contentEquals(title)) return true;
        return false;
        
    }

    public boolean isMatch(int id) {
        if (this.id == id) return true;
        return false;
    }
	

}
