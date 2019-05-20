import java.util.Arrays;

public class Kitchen implements IService {
	private EmployeeVO[] employees;

	public Kitchen() {
		setEmployees(new EmployeeVO[1]);
		employees[0] = new ChefVO();
	}

	@Override
	public String startService(OrderVO order) {
		if (order != null) {
			if (order.getState() == "confirmed") {
				order.setState("ready");
				return String.format(" Service of ChefVO %s: Order is ready. ", employees[0].toString());
			}
			return String.format(" Service of ChefVO %s: No order for precessing available. ", employees[0].toString());

		}
		return String.format(" Service of ChefVO %s: No order available. ", employees[0].toString());
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
