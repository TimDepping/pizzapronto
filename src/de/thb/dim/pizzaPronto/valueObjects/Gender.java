package de.thb.dim.pizzaPronto.valueObjects;

public enum Gender {
	
	M(1),
	F(2),
	I(3),
	U(4);
	
	private final int number;
	
	private Gender(int nr) {
		number = nr;
	}
	
	public int toNumber() {
		return number;
	}
	
	public String toString() {
		String gender = "";
		switch(number) {
		case 1:
			gender = "male";
		case 2:
			gender = "female";
		case 3:
			gender = "intersex";
		default:
			gender = "unknown";
		}
		
		return gender;
	}
}
