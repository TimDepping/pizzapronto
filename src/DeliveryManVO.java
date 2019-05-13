
public class DeliveryManVO extends EmployeeVO {

	/**
	 * DeliveryManVO represents a delivery man
	 * 
	 * @author Tim Depping
	 */

	private String driverLicence;

	/**
	 * constructor with all params
	 * 
	 * @param lastName
	 * @param firstName
	 * @param street
	 * @param houseNumber
	 * @param personnelNo
	 * @param salary
	 * @param vacationDays
	 * @param driverLicence
	 */

	public DeliveryManVO(String lastName, String firstName, String street, int houseNumber, String personnelNo,
			float salary, int vacationDays, String driverLicence) {
		super(lastName, firstName, street, houseNumber, personnelNo, salary, vacationDays);
		setDriverLicence(driverLicence);
	}

	/**
	 * default constructor
	 */

	public DeliveryManVO() {
		super(null, null, null, 0, null, 0.0f, 0);
	}

	@Override
	public String toString() {
		return String.format("DeliveryMan: %s %s\n driver licence: %s\n", this.firstName, this.lastName,
				this.driverLicence);
	}

	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
}
