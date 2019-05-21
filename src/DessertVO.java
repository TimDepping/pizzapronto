
public class DessertVO extends DishVO {

	/**
	 * DessertVO represents a dessert
	 * 
	 * @author
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

	// Verwaltungsmethoden

	@Override
	public Object clone() {
		DessertVO dessert = new DessertVO(this.number, this.name, this.price);
		return dessert;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(" " + getNumberOfDish() + " " + getNameOfDish());
		sb.append("\n\t\t\tPrice: " + price + " Euro");
		return sb.toString();
	}

	@Override
	public String getNameOfDish() {
		return String.format("Dessert %s", this.name);
	}

	@Override
	public int getNumberOfDish() {
		return number;
	}
}
