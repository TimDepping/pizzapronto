package de.thb.dim.pizzaPronto.controller;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.Ordering;
import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DeliveryManVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;

public class TestDriver {

	/**
	 * TestDriver contains the main method to test the functionality of the project
	 * 
	 * @author
	 * @param args
	 */

	public static void main(String[] args) {

		EmployeeVO[] employees = new EmployeeVO[3];

		MenuVO menu = new MenuVO();

		CustomerVO customer1 = new CustomerVO("Mustermann", "Max", "Zuhause", 1, Gender.M, LocalDate.of(1999, 8, 24));

		employees[0] = new ChefVO("Mozarella", "Giovanni", "A la Playa", 50, "0", 1000.0f, 364, Color.blue);
		employees[1] = new DeliveryManVO("Man", "Pizza", "Pizzaweg", 42, "1", 1.0f, 0, "RalleyDriver1");
		employees[2] = new DeliveryManVO("Tias", "Ralley", "Waldweg", 2, "2", 10.0f, 30, "LitDriverThe1st");

		System.out.println(menu);

		Random random = new Random();

		Ordering order = new Ordering();
		order.startNewOrder(customer1);
		for(int i = 0; i < 20; i++) {
			order.addDish(menu.getDish(random.nextInt(17)));
		}
		System.out.println(order.getCurrentOrder().toString());
		order.sortShoppingBasket();
		System.out.println(order.getCurrentOrder().toString());
		order.sortShoppingBasketByNumber();
		System.out.println(order.getCurrentOrder().toString());
		order.sortShoppingBasketByPrice();
		System.out.println(order.getCurrentOrder().toString());
		order.confirmOrder();
		order.startService();
	}
}
