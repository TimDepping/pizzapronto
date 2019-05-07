
public class PastaVO extends DishVO {
	private int typeOfPasta;
	
	/**
	 * constructor with all params
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
	
	//Verwaltungsmethoden 
	
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
	String getNameOfDish() {
		 return String.format("Pasta %s - %s", this.name, this.typeOfPasta);
	}

	@Override
	int getNumberOfDish() {
		return typeOfPasta * 100 + number;
	}
	
	//Getter and setter
	
	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	public void setTypeOfPasta(int typeOfPasta) {
		this.typeOfPasta = typeOfPasta;
	}
	
}
