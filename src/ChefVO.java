import java.awt.Color;

public class ChefVO extends EmployeeVO {
	/**
	 * ChefVO represents a chef
	 * 
	 * @author Tim Depping
	 */
	private Color colorApron;

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
	 * @param colorApron
	 */
	public ChefVO(String lastName, String firstName, String street, int houseNumber, String personnelNo, float salary,
			int vacationDays, Color colorApron) {
		super(lastName, firstName, street, houseNumber, personnelNo, salary, vacationDays);
		setColorApron(colorApron);
	}

	public ChefVO(String personnelNo, String lastName, String firstName) {
		this(lastName, firstName, null, 0, personnelNo, 0.0f, 0, null);
	}

	/**
	 * default constructor
	 */

	ChefVO() {
		this(null, null, null, 0, null, 0.0f, 0, null);
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((colorApron == null) ? 0 : colorApron.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ChefVO other = (ChefVO) obj;
		if (personnelNo != other.getPersonnelNo())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Chef: %s %s, personnelNo: %s", this.firstName, this.lastName, this.personnelNo);
	}

	// getters and setters

	public Color getColorApron() {
		return colorApron;
	}

	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}

}
