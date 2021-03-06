package de.thb.dim.pizzaPronto.valueObjects;
import java.io.Serializable;
import java.util.Arrays;

public abstract class DishVO implements Comparable<DishVO>, Cloneable, Serializable {

	private static final long serialVersionUID = 4190100940469548542L;
	
	/**
	 * DishVO represents a dish
	 * 
	 * @author
	 */

	protected int number;
	protected String name;
	protected String[] ingredients;
	protected float price;

	/**
	 * constructor with all params
	 * 
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 */

	DishVO(int number, String name, String[] ingredients, float price) {
		setNumber(number);
		setName(name);
		setIngredients(ingredients);
		setPrice(price);
	}

	/**
	 * constructor without ingredients
	 * 
	 * @param number
	 * @param name
	 * @param price
	 */

	DishVO(int number, String name, float price) {
		this(number, name, null, price);
	}

	/**
	 * default constructor
	 */

	DishVO() {
		this(0, null, null, 0.0f);
	}
	
	@Override
	public int compareTo(DishVO other) {
	    return this.getNameOfDish().toLowerCase().compareTo(other.getNameOfDish().toLowerCase());
	}

	// Verwaltungsmethoden
	
	@Override
	public Object clone() {
		Object other = null;
		try {
			other = super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		return other;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + Float.floatToIntBits(price);
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
		DishVO other = (DishVO) obj;
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Dish: %s %s, Price: %s Euro", getNumberOfDish(), getNameOfDish(), this.price);
	}
	
	public String ingredientsToString() {
		StringBuilder text = new StringBuilder("");
		if (ingredients != null) {
			for (int i = 0; i < ingredients.length; i++) {
				text.append(ingredients[i]);
				if (i < ingredients.length - 1) {
					text.append(", ");
				}
			}
		}
		return text.toString();
	}

	public abstract String getNameOfDish();

	public abstract int getNumberOfDish();

	// getters and setters

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price >= 0) {
			this.price = price;
		}
	}

}
