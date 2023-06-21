package vn.edu.hust.soict.run;

import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.digitalvideodisc.DigitalVideoDisc;

public class Aims {
	
	public static void main(String[] args) {
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King"
				,"Animation","Roger Allers",87,19.95f);
		
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars"
				,"Science Fiction","George Lucas",87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvd19 = new DigitalVideoDisc("Aladin"
				,"Animation","George Lucas",18.99f);
		DigitalVideoDisc dvdList[] = {new DigitalVideoDisc("Insidious"),new DigitalVideoDisc("IT")};
		
	
		
		System.out.println("Total cost is:");
		System.out.println(anOrder.totalCost());
		
		
		
		
		anOrder.ListOfDVDs();
	}

}
