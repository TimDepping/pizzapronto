import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class TestDriver {

	/**
	 * TestDriver contains the main method to test the functionality of the project
	 * 
	 * @author Tim Depping
	 * @param args
	 */

	public static void main(String[] args) {

		PizzaVO hawaii = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 8.90f, 2);
		PizzaVO popeye = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 7.40f, 2);
		PastaVO napoli = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4);
		PastaVO panna = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 4);
		DessertVO obstsalat = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);

		CustomerVO me = new CustomerVO("Meme", "Me", "Home", 1, "Male", LocalDate.of(1999, 8, 24));

		OrderVO myFirstOrder = new OrderVO(LocalDateTime.of(2019, 4, 9, 11, 7), me);
		myFirstOrder.setTimestampDeliveredOrder(LocalDateTime.of(2019, 4, 9, 12, 7));

		myFirstOrder.addDish(hawaii);
		myFirstOrder.addDish(popeye);
		myFirstOrder.addDish(napoli);
		myFirstOrder.addDish(panna);
		myFirstOrder.addDish(obstsalat);

		System.out.println(myFirstOrder.toString() + "\n");

		EmployeeVO[] employees = new EmployeeVO[3];

		MenuVO menu = new MenuVO();

		CustomerVO customer1 = new CustomerVO("Mustermann", "Max", "Zuhause", 1, "Male", LocalDate.of(1999, 8, 24));
		CustomerVO customer2 = new CustomerVO("Mate", "Manni", "Bauwagen", 2, "Male", LocalDate.of(1950, 1, 1));

		OrderVO order1 = new OrderVO(LocalDateTime.now(), customer1);
		OrderVO order2 = new OrderVO(LocalDateTime.now(), customer2);

		employees[0] = new ChefVO("Mozarella", "Giovanni", "A la Playa", 50, "0", 1000.0f, 364, Color.blue);
		employees[1] = new DeliveryManVO("Man", "Pizza", "Pizzaweg", 42, "1", 1.0f, 0, "RalleyDriver1");
		employees[2] = new DeliveryManVO("Tias", "Ralley", "Waldweg", 2, "2", 10.0f, 30, "LitDriverThe1st");

		System.out.println(menu);

		Random random = new Random();

		order1.addDish(menu.getDish(random.nextInt(17)));
		order1.addDish(menu.getDish(random.nextInt(17)));
		order1.addDish(menu.getDish(random.nextInt(17)));
		order1.addDish(menu.getDish(random.nextInt(17)));

		order2.addDish(menu.getDish(random.nextInt(17)));
		order2.addDish(menu.getDish(random.nextInt(17)));
		order2.addDish(menu.getDish(random.nextInt(17)));
		order2.addDish(menu.getDish(random.nextInt(17)));

		System.out.println(order1.toString());
		System.out.println(order2.toString());

		for (EmployeeVO employee : employees) {
			System.out.println(employee);
		}

	}
}
