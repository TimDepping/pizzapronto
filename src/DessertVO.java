
public class DessertVO extends DishVO {

	/**
	 * constructor
	 * @param number
	 * @param name
	 * @param price
	 */
	
	DessertVO(int number, String name, float price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}
	
	DessertVO() {
		this(0, null, 0.0f);
	}
	
	public Object clone() {
		DessertVO dessert = new DessertVO(this.number, this.name, this.price);
		return dessert;
	}
	
	@Override
	String getNameOfDish() {
		return String.format("%s", this.name);
	}

	@Override
	int getNumberOfDish() {
		return number;
	}

}
