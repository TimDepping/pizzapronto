
public class DeliveryManVO extends EmployeeVO {
	
	
	
	public DeliveryManVO(String lastName, String firstName, String street, int houseNumber, String personnelNo,
			float salary, int vacationDays, String driverLicence) {
		super(lastName, firstName, street, houseNumber, personnelNo, salary, vacationDays);
		setDriverLicence(driverLicence);
	}

	public DeliveryManVO() {
		super(null, null, null, 0, null, 0.0f, 0);
	}

	private String driverLicence;

	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
	
	public String toString() {
		return String.format("DeliveryMan: %s %s\n driver licence: %s", this.firstName, this.lastName, this.driverLicence);
	}
	
}
