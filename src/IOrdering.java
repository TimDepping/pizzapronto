
public interface IOrdering {

	public OrderVO startNewOrder(CustomerVO customer);

	public void addDish(DishVO dish);

	public void deleteDish();

	public float calculateTotalPrice();

	public void confirmOrder();

}
