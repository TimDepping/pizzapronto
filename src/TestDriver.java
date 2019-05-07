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
		
		/*
		 * ChefVO giovanni = new ChefVO("Morelli", "Giovanni", "Nicolaiplatz", 1, "1",
		 * 0, 0, Color.blue); System.out.println(giovanni.toString());
		 * System.out.println();
		 * 
		 * PizzaVO baconPizza = new PizzaVO("Bacon", new String[] {"bacon", "cheese"},
		 * 8.0f); System.out.println(baconPizza.toString()); System.out.println();
		 * 
		 * CustomerVO tim = new CustomerVO("Depping", "Tim", "Schützenweg", 9, "Male",
		 * LocalDate.of(1999, 8, 24)); System.out.println(tim.toString());
		 * System.out.println();
		 * 
		 * OrderVO myFirstOrder = new OrderVO(LocalDateTime.of(2019, 4, 9, 11, 7), tim);
		 * myFirstOrder.setTimestampDeliveredOrder(LocalDateTime.of(2019, 4, 9, 12, 7));
		 * 
		 * for(var i=0; i < 10; i++) { myFirstOrder.addDish(baconPizza); }
		 * System.out.println(myFirstOrder.toString()); System.out.println();
		 * 
		 * System.out.println(tim.hasOrder());
		 * 
		 * OrderVO mySecondOrder = new OrderVO(LocalDateTime.of(2019, 4, 9, 11, 7),
		 * tim); mySecondOrder.setTimestampDeliveredOrder(LocalDateTime.of(2019, 4, 9,
		 * 12, 7));
		 * 
		 * for(var i=0; i < 10; i++) { mySecondOrder.addDish(baconPizza); }
		 * 
		 * System.out.println(mySecondOrder.toString()); System.out.println();
		 */
	}
}
