import java.util.Arrays;

public class PizzaVO {
	
	/**
	 * PizzaVO represents a pizza
	 * @author Tim Depping
	 */

	private String name;
	private float price;
	private String[] ingredients;
	
	/**
	 * constructor with all params
	 * @param name
	 * @param ingredients
	 * @param price
	 */
	
	PizzaVO(String name, String[] ingredients, float price){
		setName(name);
		setIngredients(ingredients);
		setPrice(price);
	}
	
	PizzaVO() {
		this(null, null, 0.0f);
	}
	
	//Verwaltungsmethoden
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

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
		PizzaVO other = (PizzaVO) obj;
		if (!Arrays.equals(ingredients, other.ingredients)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) {
			return false;
		}
		return true;
	}

	public Object clone() {
		PizzaVO pizza = new PizzaVO(this.name, this.ingredients, this.price);
		return pizza;
	}
	
	public String toString() {
		StringBuilder text = new StringBuilder(String.format("Pizza: %s\n price: %s€\n ingredients: ", name, price));
		if(ingredients != null) {
			for(int i = 0; i < ingredients.length; i++) {
				text.append(ingredients[i]);
				if(i < ingredients.length - 1) {
					text.append(", ");
				}
			}
		}
		return text.toString();
	}
	
	//Getter and setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price > 0.0f) {
			this.price = price;
		}
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	
}
