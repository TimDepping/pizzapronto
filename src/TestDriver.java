import java.awt.Color;
import java.time.LocalDate;
import java.util.Random;

public class TestDriver {

	/**
	 * TestDriver contains the main method to test the functionality of the project
	 * 
	 * @author Tim Depping
	 * @param args
	 */

	public static void main(String[] args) {

		EmployeeVO[] employees = new EmployeeVO[3];

		MenuVO menu = new MenuVO();

		CustomerVO customer1 = new CustomerVO("Mustermann", "Max", "Zuhause", 1, "Male", LocalDate.of(1999, 8, 24));
		CustomerVO customer2 = new CustomerVO("Mate", "Manni", "Bauwagen", 2, "Male", LocalDate.of(1950, 1, 1));

		employees[0] = new ChefVO("Mozarella", "Giovanni", "A la Playa", 50, "0", 1000.0f, 364, Color.blue);
		employees[1] = new DeliveryManVO("Man", "Pizza", "Pizzaweg", 42, "1", 1.0f, 0, "RalleyDriver1");
		employees[2] = new DeliveryManVO("Tias", "Ralley", "Waldweg", 2, "2", 10.0f, 30, "LitDriverThe1st");

		System.out.println(menu);

		Random random = new Random();

		Ordering order = new Ordering();
		order.startNewOrder(customer1);
		System.out.println(order.getCurrentOrder().getState());
		System.out.println(order.getCurrentOrder().toString());
		System.out.println(order.calculateTotalPrice());

		order.addDish(menu.getDish(random.nextInt(17)));
		order.addDish(menu.getDish(random.nextInt(17)));
		System.out.println(order.getCurrentOrder().toString());
		System.out.println(order.calculateTotalPrice());

		order.deleteDish();
		order.deleteDish();
		order.deleteDish();
		order.deleteDish();

		System.out.println(order.getCurrentOrder().toString());
		System.out.println(order.calculateTotalPrice());

		order.confirmOrder();
		System.out.println(order.getCurrentOrder().getState());
		order.startService();

		order.addDish(menu.getDish(random.nextInt(17)));
		order.confirmOrder();
		System.out.println(order.getCurrentOrder().getState());
		System.out.println(order.getCurrentOrder().toString());
		System.out.println(order.calculateTotalPrice());
		order.startService();
	}
}
