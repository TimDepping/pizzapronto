
public class EmployeeVO extends PersonVO {
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	public EmployeeVO(String lastName, String firstName, String street, int houseNumber, String personnelNo,
			float salary, int vacationDays) {
		super(lastName, firstName, street, houseNumber);
		setPersonnelNo(personnelNo);
		setSalary(salary);
		setVacationDays(vacationDays);
	}
	
	//Klassenmethoden
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((personnelNo == null) ? 0 : personnelNo.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + vacationDays;
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
		EmployeeVO other = (EmployeeVO) obj;
		if (personnelNo == null) {
			if (other.personnelNo != null)
				return false;
		}
		return true;
	}
	
	public String toString() {
		return String.format("Employee: %s %s\n personnelNo: %s\n salary: %s, vacationDays: %s", this.firstName, this.lastName, this.personnelNo, this.salary, this.vacationDays);
	}

	//Getter and setter

	public String getPersonnelNo() {
		return personnelNo;
	}

	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	
	
}
