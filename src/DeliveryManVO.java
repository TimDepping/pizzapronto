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

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((driverLicence == null) ? 0 : driverLicence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryManVO other = (DeliveryManVO) obj;
		if (driverLicence == null) {
			if (other.driverLicence != null)
				return false;
		} else if (!driverLicence.equals(other.driverLicence))
			return false;
		return true;
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
