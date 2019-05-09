
public class PastaVO extends DishVO {
	private int typeOfPasta;

	/**
	 * PastaVO represents a pasta
	 * 
	 * @author Tim Depping
	 */

	/**
	 * constructor with all params
	 * 
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 * @param pastaType
	 */

	PastaVO(int number, String name, String[] ingredients, float price, int pastaType) {
		this.number = number;
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
		this.typeOfPasta = pastaType;
	}

	/**
	 * Default constructor
	 */
	PastaVO() {
		this(0, null, null, 0.0f, 0);
	}

	// Verwaltungsmethoden

	@Override
	public Object clone() {
		PastaVO pasta = new PastaVO(this.number, this.name, this.ingredients, this.price, this.typeOfPasta);
		return pasta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + typeOfPasta;
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
		PastaVO other = (PastaVO) obj;
		if (typeOfPasta != other.typeOfPasta)
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
	String getNameOfDish() {
		StringBuffer sb = new StringBuffer(String.format("Pasta " + name + " - "));
		if (typeOfPasta == 4) {
			sb.append("Spaghetti  ");
		} else if (typeOfPasta == 5) {
			sb.append("Tortellini  ");
		} else if (typeOfPasta == 6) {
			sb.append("Gnocchi  ");
		} else {
			sb.append("Unknown");
		}
		return sb.toString();
	}

	@Override
	int getNumberOfDish() {
		return typeOfPasta * 100 + number;
	}

	// getters and setters

	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	public void setTypeOfPasta(int typeOfPasta) {
		this.typeOfPasta = typeOfPasta;
	}

}
