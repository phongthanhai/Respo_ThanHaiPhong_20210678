package vn.edu.hust.soict.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import vn.edu.hust.soict.model.cart.Cart;
import vn.edu.hust.soict.model.media.Book;
import vn.edu.hust.soict.model.media.CompactDisc;
import vn.edu.hust.soict.model.media.DigitalVideoDisc;
import vn.edu.hust.soict.model.media.Media;
import vn.edu.hust.soict.model.media.Playable;
import vn.edu.hust.soict.model.store.Store;



public class Aims {
	public static Cart cart;
	public static Store store;
	
	
	public static void showMenu() { 
		
		boolean isRunning = false;
		isRunning =true;
		
		while(isRunning) {
			System.out.println("AIMS: "); 

			System.out.println("--------------------------------"); 

			System.out.println("1. View store"); 

			System.out.println("2. Update store"); 

			System.out.println("3. See current cart"); 

			System.out.println("0. Exit"); 

			System.out.println("--------------------------------"); 

			System.out.println("Please choose a number: 0-1-2-3"); 
			
			Scanner sc = new Scanner(System.in);

			int option = 0;
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
			}
			
			option =  sc.nextInt();
			
			switch(option) {
				case 1:
					Aims.storeMenu();
					break;
					
				case 2:
					Aims.updateMenu();
					break;
					
				case 3:
					cart.viewCart();
					Aims.cartMenu();
					break;
					
				case 0:
					isRunning = false;
					break;
				
				default:
					System.out.println("Invalid choice! Try again");
			}
			
		}

		
		
		
	}
	
	public static void storeMenu() {
		boolean isRunning = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		isRunning =true;
		
			while(isRunning) {
				store.viewStore();
				
				System.out.println("Options: "); 
	
				System.out.println("--------------------------------"); 
	
				System.out.println("1. See a media’s details"); 
	
				System.out.println("2. Add a media to cart"); 
	
				System.out.println("3. Play a media"); 
	
				System.out.println("4. See current cart"); 
	
				System.out.println("0. Back"); 
	
				System.out.println("--------------------------------"); 
	
				System.out.println("Please choose a number: 0-1-2-3-4"); 
				
				Scanner sc = new Scanner(System.in);
				int option = 0;
				
				while (!sc.hasNextInt()) {
					sc.nextLine();
				}
				
				option =  sc.nextInt();
				
				switch(option) {
				
					case 1:
						System.out.println("Enter media title:");
						
						try {
							String title = reader.readLine();
							Media med = store.searchByTitle(title);
							
							if(med == null) {
								System.out.println("No media with title : "+title+" found!");
							}else {
								System.out.println(med);
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Aims.mediaDetailsMenu();
						
						
						break;
						
					case 2:
						mediaDetailsMenu();
						break;
						
					case 3:
						playMedia();
						break;
						
					case 4:
						cart.viewCart();
						
					case 0:
						isRunning = false;
						break;
					
					default:
						System.out.println("Invalid choice! Try again");
				}
			}
		
		}
	
	public static void cartMenu() {
		
		boolean isRunning = true;
		
		while(isRunning) {
			System.out.println("Options: "); 

			System.out.println("--------------------------------"); 

			System.out.println("1. Filter medias in  cart"); 

			System.out.println("2. Sort medias in cart"); 

			System.out.println("3. Remove media from cart"); 

			System.out.println("4. Play a media"); 

			System.out.println("5. Place order"); 

			System.out.println("0. Back"); 

			System.out.println("--------------------------------"); 

			System.out.println("Please choose a number: 0-1-2-3-4-5");
			
			Scanner sc = new Scanner(System.in);
			int option = 0;
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
			}
			
			option =  sc.nextInt();
			
			switch(option) {
				case 1:
					Aims.filterInCart();
					break;
					
				case 2:
					Aims.sortInCart();
					break;
					
				case 3:
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						String title = reader.readLine();
						Media med = cart.searchByTitle(title);
						
						if(med == null) {
							System.out.println("No media with title : "+title+" found!");
						}else {
							cart.removeMedia(med);
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case 4:
					Aims.playMedia();
					break;
				
				case 5:
					Aims.placeOrder();
					break;
					
				case 0:
					isRunning = false;
					break;
				
				default:
					System.out.println("Invalid choice! Try again");
			}
		}
	} 
	
	public static void playMedia() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the title of the media: ");
        String title;
		try {
			title = reader.readLine();
			Media media = store.searchByTitle(title);
	        
	        if (media != null) {
	            if (media instanceof Playable) {
	                ((Playable) media).play();
	            } else {
	                System.out.println("This media cannot be played.");
	            }
	        } else {
	            System.out.println("No such media.");
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void addMediaStore() {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		
		while(isRunning) {
			System.out.println("Choose type:");
			System.out.println("1. Books");
			System.out.println("2. CD");
			System.out.println("3. DVD");
			System.out.println("4. Go back");
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Invalid choice");
			}
			
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					Book book = Book.createBook();
					store.addMedia(book);
					break;
				case 2:
					CompactDisc cd = CompactDisc.createCD();
					store.addMedia(cd);
					break;
				case 3:
					DigitalVideoDisc dvd = DigitalVideoDisc.createDVD();
					store.addMedia(dvd);
					break;
				case 4:
					isRunning = false;
					break;
					
				default:
					System.out.println("Invalid choice!");
			}
		}
		
	}
	
	public static void deleteMediaStore() {
		System.out.println("Enter the title of the media to be deleted:");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String title;
		
		try {
			
			title= reader.readLine();
			boolean result = store.removeMedia(title);
			
			if(result) {
				System.out.println("Items: "+ title + " has been removed!");
			}else {
				System.out.println("This media item does not exist.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void placeOrder() {
        System.out.println("Order is received!");
        Aims.cart=null;
        Aims.cart=new Cart();
    }
	
	
	public static void main(String[] args) {
		
		store = new Store();
		cart = new Cart();
		Aims.showMenu();
	}
	
	public static void updateMenu() {
		Scanner sc = new Scanner(System.in);
		boolean isChoosing = true;
		
		while(isChoosing) {
			System.out.println("-----------------------------");
			System.out.println("Choose an option:");
			System.out.println("1. Add a media to the store");
			System.out.println("2. Remove a media from the store");
			System.out.println("3. Go back");
			System.out.println("-----------------------------");
			
			int option = 0;
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Invalid choice");
			}
			
			option =  sc.nextInt();
			
			switch(option) {
				case 1:
					Aims.addMediaStore();;
					break;
				case 2:
					Aims.deleteMediaStore();
					break;
					
				case 3:
					isChoosing = false;
					break;
				default:
					System.out.println("Invalid choice");	
					
			}
		}
	}
	
	public static void mediaDetailsMenu() { 
		
		Scanner sc = new Scanner(System.in);
		boolean isChoosing = true;
		
		while(isChoosing) {
			
			
			System.out.println("");
			store.viewStore();
			System.out.println("Options: "); 

			System.out.println("--------------------------------"); 

			System.out.println("1. Add to cart"); 

			System.out.println("2. Play"); 

			System.out.println("0. Back"); 

			System.out.println("--------------------------------"); 

			System.out.println("Please choose a number: 0-1-2");
			
			int option = 0;
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Invalid choice");
			}
			
			option =  sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Enter media title:");
					
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						String title = reader.readLine();
						Media med = store.searchByTitle(title);
						
						if(med == null) {
							System.out.println("No media with title : "+title+" found!");
						}else {
							cart.addMedia(med);
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
					
				case 2:
					Aims.playMedia();
					break;
					
				case 0:
					
					isChoosing = false;
					break;
					
				default:
					System.out.println("Invalid choice");
				
				}
			}
		
		

		}
	
	public static void sortInCart() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose sorting option:");
		System.out.println("1.Title");
		System.out.println("2.Cost");
		
		int option = 0;
		
		while (!sc.hasNextInt()) {
			sc.nextLine();
		}
		
		option =  sc.nextInt();

		switch(option) {
			case 1:
				cart.sortByTitle();
				cart.viewCart();
				break;
			case 2:
				cart.sortByCost();
				cart.viewCart();
				break;
			default:
				System.out.println("Operation Failed!");
		}
		
	}
	
	public static void filterInCart() {
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Choose filtering option:");
		System.out.println("1.Title");
		System.out.println("2.ID");
		
		int option = 0;
		
		while (!sc.hasNextInt()) {
			sc.nextLine();
		}
		
		option =  sc.nextInt();

		switch(option) {
			case 1:
				System.out.println("Enter title");
			
			try {
				String title;
				title = reader.readLine();
				cart.filterByTitle(title);
				cart.viewCart();
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
			case 2:
				System.out.println("Enter ID");
				
				int id=0;
				id = sc.nextInt();
				cart.filterByID(id);
				cart.viewCart();
				break;
			default:
				System.out.println("Operation Failed!");
		}
	}

}
