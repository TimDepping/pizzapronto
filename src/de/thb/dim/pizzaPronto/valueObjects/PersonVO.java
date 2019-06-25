package de.thb.dim.pizzaPronto.valueObjects;

import java.io.Serializable;

public abstract class PersonVO implements Serializable {

	private static final long serialVersionUID = 4350523878107858152L;
	
	/**
	 * PersonVO represents a person
	 * 
	 * @author
	 */

	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;

	/**
	 * constructor with all params
	 * 
	 * @param lastName
	 * @param firstName
	 * @param street
	 * @param houseNumber
	 */

	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		setLastName(lastName);
		setFirstName(firstName);
		setStreet(street);
		setHouseNumber(houseNumber);
	}

	/**
	 * constructor with first and lastname
	 * 
	 * @param lastName
	 * @param firstName
	 */

	public PersonVO(String lastName, String firstName) {
		this(lastName, firstName, null, 0);
	}

	/**
	 * default constructor
	 */

	public PersonVO() {
		this(null, null, null, 0);
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + houseNumber;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		PersonVO other = (PersonVO) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (houseNumber != other.houseNumber)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Person: %s %s\n address: %s %s", this.firstName, this.lastName, this.street,
				this.houseNumber);
	}

	// getters and setters

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

	protected String getStreet() {
		return street;
	}

	protected void setStreet(String street) {
		this.street = street;
	}

	protected int getHouseNumber() {
		return houseNumber;
	}

	protected void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

}
