package de.thb.dim.pizzaPronto.businessObjects;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DeliveryManVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.NoCustomerException;

public class Delivery implements IService {

	EmployeeVO[] employees;

	/**
	 * default constructor
	 */
	public Delivery() {
		setEmployees(new EmployeeVO[2]);
		employees[0] = new DeliveryManVO("Tias", "Ralley", "Waldweg", 2, "2", 10.0f, 30, "LitDriverThe1st");
		employees[1] = new DeliveryManVO("Tias", "Ralley", "Waldweg", 2, "2", 10.0f, 30, "LitDriverThe1st");
	}

	@Override
	public String startService(OrderVO order) throws NullPointerException, NoCustomerException, IllegalStateException {
		Objects.requireNonNull(order, "No order available.");
		EmployeeVO employee = selectEmployee();
			CustomerVO customer = order.getCustomer();
			if (customer != null) {
				if (order.getState() == StateOfOrderVO.READY) {
					order.setState(StateOfOrderVO.DELIVERED);
					return String.format(
							" Drive to customer %s, Service of DeliveryManVO %s: Order is delivered on //Implement Date ",
							customer.toString(), employee.toString());
				} else {
					throw new IllegalStateException("No order is ready for processing.");
				}
			} else {
				throw new NoCustomerException("No customer available.");
			}
		
	}

	private EmployeeVO selectEmployee() {
		Random random = new Random();
		return employees[random.nextInt(2)];
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(employees);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (!Arrays.equals(employees, other.employees))
			return false;
		return true;
	}

	// getters and setters

	public EmployeeVO[] getEmployees() {
		return employees;
	}

	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}

}
