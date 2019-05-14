
public interface IOrdering {

	public default OrderVO startNewOrder(CustomerVO customer) {
		return null;
	}

	public default void addDish(DishVO dish) {
	}

	public default void deleteDish() {
	}

	public default float calculateTotalPrice() {
		return 0.0f;
	}

	public default void confirmOrder() {
	}

}
