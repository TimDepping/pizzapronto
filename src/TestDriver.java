import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestDriver {
	
	/**
	 * TestDriver contains the main method to test the functionality of the project 
	 * @author Tim Depping
	 * @param args
	 */

	public static void main(String[] args) {
		
		MenuVO menu = new MenuVO();
		
		System.out.print(menu.toString());
		
		ChefVO giovanni = new ChefVO("Morelli", "Giovanni", "Nicolaiplatz", 1, "1", 0, 0, Color.blue);
		System.out.println(giovanni.toString());
		
		PizzaVO hawaii = new PizzaVO(31, "Hawaii", new String[] { "Schinken","Ananas", "Curry" }, 8.90f, 2);
		PizzaVO popeye = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 7.40f, 2);
		PastaVO napoli = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4);
		PastaVO panna = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 4);
		DessertVO obstsalat = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
		  
		CustomerVO tim = new CustomerVO("Depping", "Tim", "Schützenweg", 9, "Male", LocalDate.of(1999, 8, 24)); 
		System.out.println(tim.toString());
		  
		OrderVO myFirstOrder = new OrderVO(LocalDateTime.of(2019, 4, 9, 11, 7), tim);
		myFirstOrder.setTimestampDeliveredOrder(LocalDateTime.of(2019, 4, 9, 12, 7));
		  
		myFirstOrder.addDish(hawaii); 
		myFirstOrder.addDish(popeye);
		myFirstOrder.addDish(napoli);
		myFirstOrder.addDish(panna);
		myFirstOrder.addDish(obstsalat);
		
		System.out.println(myFirstOrder.toString() + "\n");
		
	}
}
