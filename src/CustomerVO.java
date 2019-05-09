import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CustomerVO extends PersonVO {
	/**
	 * CustomerVO represents a customer
	 * 
	 * @author Tim Depping
	 */
	private static int nextId = 0;
	private int id;
	private String gender;
	private LocalDate dateOfBirth;
	private OrderVO order;

	public CustomerVO(String lastName, String firstName, String street, int houseNumber, String gender, LocalDate dob) {
		super(lastName, firstName, street, houseNumber);
		id = nextId;
		nextId++;
		setGender(gender);
		setDateOfBirth(dob);
	}

	public CustomerVO(String lastName, String firstName, LocalDate dob) {
		this(lastName, firstName, null, 0, null, dob);
	}

	public CustomerVO() {
		this(null, null, null, 0, null, null);
	}

	public short calculateAge() {
		short calculatedAge = -1;
		Period age;
		LocalDate today = LocalDate.now();

		if (dateOfBirth != null) {
			age = Period.between(dateOfBirth, today);
			calculatedAge = (short) age.getYears();
		}
		return calculatedAge;
	}

	String dobToString() {
		if (dateOfBirth != null) {
			return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		}
		return "Not available.";
	}

	Boolean hasOrder() {
		return order != null;
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomerVO other = (CustomerVO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) {
				return false;
			}
		} else if (!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Customer: %s %s\n gender: %s\n date of birth: %s, age: %s\n\n", this.firstName,
				this.lastName, this.gender, dobToString(), this.calculateAge());
	}

	// getters and setters

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		if (this.calculateAge() < 18) {
			this.dateOfBirth = null;
		}
	}

	public int getId() {
		return id;
	}

	public static int getNextId() {
		return nextId;
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}
}
