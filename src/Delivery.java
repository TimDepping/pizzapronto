import java.util.Random;

public class Delivery implements IService {

	EmployeeVO[] employees;

	/**
	 * default constructor
	 */
	public Delivery() {
		setEmployees(new EmployeeVO[2]);
		employees[0] = new DeliveryManVO();
		employees[1] = new DeliveryManVO();
	}

	@Override
	public String startService(OrderVO order) {
		EmployeeVO employee = selectEmployee();

		if (order != null) {
			CustomerVO customer = order.getCustomer();
			if (customer != null) {
				if (order.getState() == "ready") {
					order.setState("delivered");
					return String.format(
							" Drive to customer %s, Service of DeliveryManVO %s: Order is delivered on //Implement Date ",
							customer.toString(), employee.toString());
				} else {
					return String.format(" Service of DeliveryManVO %s: No order for processing available. ",
							employee.toString());
				}
			} else {
				return String.format(" Service of DeliveryManVO %s: No customer available. ", employee.toString());
			}
		}
		return String.format(" Service of DeliveryManVO %s: No order available. ", employee.toString());
	}

	private EmployeeVO selectEmployee() {
		Random random = new Random();
		return employees[random.nextInt(2)];
	}

	// getters and setters

	public EmployeeVO[] getEmployees() {
		return employees;
	}

	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}

}
