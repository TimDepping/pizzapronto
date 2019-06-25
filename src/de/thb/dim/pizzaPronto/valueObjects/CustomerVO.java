package de.thb.dim.pizzaPronto.valueObjects;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class CustomerVO extends PersonVO implements Serializable {
	
	private static final long serialVersionUID = 8193973421686897311L;
	
	/**
	 * CustomerVO represents a customer
	 * 
	 * @author
	 */
	private static int nextId = 0;
	private int id;
	private Gender gender;
	private LocalDate dateOfBirth;
	private OrderVO order;

	public CustomerVO(String lastName, String firstName, String street, int houseNumber, Gender gender, LocalDate dob) throws CustomerTooYoungException {
		super(lastName, firstName, street, houseNumber);
		id = nextId;
		nextId++;
		setGender(gender);
		try {
			setDateOfBirth(dob);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CustomerVO(String lastName, String firstName, LocalDate dob) throws CustomerTooYoungException  {
		this(lastName, firstName, null, 0, null, dob);
	}

	public short calculateAge() throws CustomerNoDateOfBirthException {
		short calculatedAge = -1;
		Period age;
		LocalDate today = LocalDate.now();
		
		if (dateOfBirth != null) {
			age = Period.between(dateOfBirth, today);
			calculatedAge = (short) age.getYears();
			return calculatedAge;
		}
		throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
	}

	String dobToString() throws CustomerNoDateOfBirthException{
		if(dateOfBirth ==  null) {
			throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
		}
		return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
	}

	public Boolean hasOrder() {
		return order != null;
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (getClass() != obj.getClass()) {
			return false;
		}

		CustomerVO other = (CustomerVO) obj;
		if (id != other.getId()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String string = "";
		try {
			string = String.format("Customer: %s %s\n gender: %s\n date of birth: %s, age: %s\n\n", this.firstName,
					this.lastName, this.gender, dobToString(), calculateAge());
		} catch (CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
		}
		return string;
	}

	// getters and setters

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) throws NullPointerException, CustomerTooYoungException {
		Objects.requireNonNull(dateOfBirth, "dob must not be null");
		
		this.dateOfBirth = dateOfBirth;
		
		try {
			if(this.calculateAge() < 18) {
				throw new CustomerTooYoungException("Customer is not an adult.");
			} 
		} catch(CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
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
