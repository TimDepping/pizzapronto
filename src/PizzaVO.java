public class PizzaVO extends DishVO {

	/**
	 * PizzaVO represents a pizza
	 * 
	 * @author Tim Depping
	 */

	private int size;

	/**
	 * constructor with all params
	 * 
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 * @param size
	 */

	PizzaVO(int number, String name, String[] ingredients, float price, int size) {
		this.number = number;
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
		setSize(size);
	}

	/**
	 * constructor without size
	 * 
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 */

	PizzaVO(int number, String name, String[] ingredients, float price) {
		this(number, name, ingredients, price, 0);
	}

	/**
	 * Default constructor
	 */

	PizzaVO() {
		this(0, null, null, 0.0f, 0);
	}

	// Verwaltungsmethoden

	@Override
	public Object clone() {
		PizzaVO pizza = new PizzaVO(this.number, this.name, this.ingredients, this.price, this.size);
		return pizza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
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
		PizzaVO other = (PizzaVO) obj;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(getNumberOfDish() + " " + getNameOfDish());
		for (var i = 0; i < ingredients.length; i++) {
			if (ingredients[i] != null) {
				sb.append(ingredients[i]);
			}
			if (i < ingredients.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("\n\t\t\tPrice: " + price + " Euro");
		return sb.toString();
	}

	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer(String.format("Pizza " + name + " - "));
		if (size == 1) {
			sb.append("Normal  ");
		} else {
			sb.append("Grande  ");
		}
		return sb.toString();
	}

	@Override
	public int getNumberOfDish() {
		return number * 10 + size;
	}

	// getters and setters

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
