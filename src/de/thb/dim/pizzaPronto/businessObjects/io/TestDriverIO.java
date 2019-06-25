package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class TestDriverIO {

	private static OrderVO[] orders = new OrderVO[3];
	private static CustomerVO customer;
	private static ArrayList<OrderVO>  oldOrders = new ArrayList<OrderVO>();
	
	public static void main(String[] args) {
		
		try {
			customer = new CustomerVO("Mampf", "Manfred", "Essensstra�e", 42, Gender.M, LocalDate.of(1990, 6, 28));
		} catch (CustomerTooYoungException e) {
			e.printStackTrace();
		}
		
		
		orders[0] = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
		orders[1] = new OrderVO(1, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
		orders[2] = new OrderVO(2, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
		
		Serializer se;
		try {
			se = new Serializer("Order.ser");
			se.serializeOrder(orders[0]);
			se.serializeOrder(orders[1]);
			se.serializeOrder(orders[2]);
			se.closeOutput();
			
			for (int i = 0; i < orders.length; i++) {
				oldOrders.add(se.deserializeOrder());
				System.out.println(oldOrders.get(i));
				System.out.println("Equal to original?: "+oldOrders.get(i).equals(orders[i])+"\n");
			}
			se.closeInput();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
		MenuImporter mp = new MenuImporter();
		MenuVO menu = null;
		try {
			menu = mp.readMenu("myLittleMenu.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(menu);
		
	}
}
