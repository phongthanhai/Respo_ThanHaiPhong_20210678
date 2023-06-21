package vn.edu.hust.soict.test.passing;

import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.test.passing.*;
public class TestPassingParameter {
	
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD =  new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD =  new DigitalVideoDisc("Cinderella");
		
		
		
		//Test Object Swap Method
		swap(jungleDVD,cinderellaDVD);
		System.out.println("Attemp to swap objects");
		System.out.println("Jungle DVD title:"+ jungleDVD.getTitle());
		System.out.println("Cinderella DVD title:"+ cinderellaDVD.getTitle());
		System.out.println();
		
		//Wrapper
		Wrapper jungleDVDW = new Wrapper(jungleDVD);
		Wrapper cinderellaDVDW = new Wrapper(cinderellaDVD);
		//Test swap wrapper
		System.out.println("");
		System.out.println("Test Wrapper:");
		swap2(jungleDVDW,cinderellaDVDW);
				
		System.out.println("Jungle DVD title:"+ jungleDVDW.dvd.getTitle());
		System.out.println("Cinderella DVD title:"+ cinderellaDVDW.dvd.getTitle());
		System.out.println();
		
		//Revert Changes:
		swap2(jungleDVDW,cinderellaDVDW);
		
		//Test changeTitle method
		System.out.println("Test changeTitle");
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("Jungle DVD title:"+ jungleDVD.getTitle());
		
		
		
		
		
		
		
	}
	
	public static void swap2(Wrapper o1, Wrapper o2) {
		DigitalVideoDisc temp = o1.dvd;
		o1.dvd=o2.dvd;
		o2.dvd=temp;
	}
	
	public static void swap(Object o1,Object o2) {
		Object tmp= o1;
		o1 = o2;
		o2 = tmp;
	}
	
	
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldTitle =  dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
}
