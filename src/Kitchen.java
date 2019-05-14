
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

	public EmployeeVO[] getEmployees() {
		return employees;
	}

	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}

}
