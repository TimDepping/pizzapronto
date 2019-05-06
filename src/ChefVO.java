import java.awt.Color;

public class ChefVO extends EmployeeVO {
	/**
	 * ChefVO represents a chef
	 * @author Tim Depping
	 */
	private Color colorApron;
	
	
	/**
	 * constructor with all params
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


	/**
	 * default constructor
	 */
	ChefVO(){
		this(null, null, null, 0, null, 0.0f, 0, null);
	}
	

	public String toString() {
		return String.format("Chef: %s %s", this.firstName, this.lastName);
	}
	
	//Getter and setter

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Color getColorApron() {
		return colorApron;
	}

	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}
	
}