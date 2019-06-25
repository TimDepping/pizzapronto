package de.thb.dim.pizzaPronto.valueObjects;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuVO {

	/**
	 * MenuVO represents a menu
	 * 
	 * @author
	 */

	private List<DishVO> dishes;

	public MenuVO() {
		initMenu();
	}
	
	public MenuVO(ArrayList<DishVO> dishes) {
		this.dishes = dishes;
	}

	private void initMenu() {
		this.dishes = new ArrayList<DishVO>();
		dishes.add(new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 7.00f, 1));
		dishes.add(new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 8.90f, 2));
		dishes.add(new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 5.80f, 1));
		dishes.add(new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 7.40f, 2));
		dishes.add(new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 7.00f, 1));
		dishes.add(new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 8.90f, 2));

		dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4));
		dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 5));
		dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 6));
		dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 4));
		dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 5));
		dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 6));
		dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 4));
		dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 5));
		dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 6));

		dishes.add(new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
		dishes.add(new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
		dishes.add(new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));
	}

	public DishVO getDish(int index) {
		return dishes.get(index);
	}

	public int getNumberOfDishes() {
		return dishes.size();
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishes == null) ? 0 : dishes.hashCode());
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
		MenuVO other = (MenuVO) obj;
		if (dishes == null) {
			if (other.dishes != null)
				return false;
		} else if (!dishes.equals(other.dishes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		DecimalFormat dFormat = new DecimalFormat(".00"); // Format the price
		sb.append("MENU PIZZA PRONTO\n\n");

		// pizzas
		sb.append(
				"Prima special pizzas: \n\t1 normal (Diameter approx. 26 cm) and \n\t2 grande (Diameter approx. 32 cm)\n");
		do {
			sb.append(dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");
			sb.append(dishes.get(i).ingredientsToString());
			sb.append("\n\tPrice: " + dFormat.format(dishes.get(i).getPrice()) + " Euro");

			if (dishes.get(i).getNumber() == dishes.get(i + 1).getNumber()) {
				sb.append("\n\tPrice: " + dFormat.format(dishes.get(i + 1).getPrice()) + " Euro");
				sb.append("\n");
				i += 2;
			} else {
				i += 1;
			}

		} while (i < dishes.size() && dishes.get(i) instanceof PizzaVO);

		// pastas
		sb.append("\nPrima special pastas: \n\t4 Spaghetti\n\t5 Tortellini\n\t6 Gnocchi\n");
		do {
			sb.append(dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");
			sb.append(dishes.get(i).ingredientsToString());
			sb.append("\n\tPrice: " + dFormat.format(dishes.get(i).getPrice()) + " Euro");

			if (dishes.get(i).getNumber() == dishes.get(i +1).getNumber()
					&& dishes.get(i).getNumber() == dishes.get(i +2).getNumber()) {
				i += 3;
				sb.append("\n");
			}

		} while (i < dishes.size() && dishes.get(i)instanceof PastaVO);

		// desserts
		sb.append("\nPrima desserts:\n");
		do {
			sb.append(dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");
			sb.append("\n\tPrice: " + dFormat.format(dishes.get(i).getPrice()) + " Euro");

			i += 1;
			sb.append("\n");

		} while (i < dishes.size() && dishes.get(i) instanceof DessertVO);
		sb.append("\nBon appetit!\n\n");
		return sb.toString();
		
	}
}
