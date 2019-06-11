package de.thb.dim.pizzaPronto.businessObjects;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

public class Kitchen implements IService {
	private EmployeeVO[] employees;

	public Kitchen() {
		setEmployees(new EmployeeVO[1]);
		employees[0] = new ChefVO("Mozarella", "Giovanni", "A la Playa", 50, "personnelNumber", 1000.0f, 364,
				Color.blue);
	}

	@Override
	public String startService(OrderVO order) throws NullPointerException, IllegalStateException {
		Objects.requireNonNull(order, "No order available.");
		if (order.getState() == StateOfOrderVO.CONFIRMED) {
			order.setState(StateOfOrderVO.READY);
			return String.format(" Service of ChefVO %s: Order is ready. ", employees[0].toString());
		}
		throw new IllegalStateException("No order for processing available.");
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
		Kitchen other = (Kitchen) obj;
		if (!Arrays.equals(employees, other.employees))
			return false;
		return true;
	}

	// Getter and setters

	public EmployeeVO[] getEmployees() {
		return employees;
	}

	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}

}
