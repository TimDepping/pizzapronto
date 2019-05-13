
public class DessertVO extends DishVO {

	/**
	 * DessertVO represents a dessert
	 * 
	 * @author Tim Depping
	 */

	/**
	 * constructor with all params
	 * 
	 * @param number
	 * @param name
	 * @param price
	 */

	DessertVO(int number, String name, float price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	/**
	 * default constructor
	 */

	DessertVO() {
		this(0, null, 0.0f);
	}

	@Override
	public Object clone() {
		DessertVO dessert = new DessertVO(this.number, this.name, this.price);
		return dessert;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(" " + getNumberOfDish() + " " + getNameOfDish());
		sb.append("\n\t\t\tPrice: " + price + " Euro");
		return sb.toString();
	}

	@Override
	String getNameOfDish() {
		return String.format("Dessert %s", this.name);
	}

	@Override
	int getNumberOfDish() {
		return number;
	}
}
