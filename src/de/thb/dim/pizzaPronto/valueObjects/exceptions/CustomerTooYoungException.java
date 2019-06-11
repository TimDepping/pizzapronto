package de.thb.dim.pizzaPronto.valueObjects.exceptions;

public class CustomerTooYoungException extends Exception {

	private static final long serialVersionUID = -5165067382209404005L;

	public CustomerTooYoungException() {
		super();
	}
	
	public CustomerTooYoungException(String message) {
		super(message);
	}
}
