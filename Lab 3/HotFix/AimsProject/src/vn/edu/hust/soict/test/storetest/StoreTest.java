package vn.edu.hust.soict.test.storetest;

import vn.edu.hust.soict.model.digitalvideodisc.DigitalVideoDisc;
import vn.edu.hust.soict.model.store.Store;

public class StoreTest {
	public static void main(String[] args) {
        Store store = new Store();

        // Add DVDs to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King"
				,"Animation","Roger Allers",87,19.95f);
        
        store.addDVD(dvd1);
        store.addDVD(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addDVD(new DigitalVideoDisc("Star Wars"
				,"Science Fiction","George Lucas",87,24.95f));

        System.out.println("DVDs in store:");
        store.viewStore();

        // Remove DVDs from the store
        store.removeDVD(dvd1);

        System.out.println("DVDs in store after removal:");
        store.viewStore();
    }
}
