import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class OrderVO {

	/**
	 * OrderVO represents an order
	 * 
	 * @author Tim Depping
	 */

	private int orderNo;
	private String state;
	private java.time.LocalDateTime timestampStartedOrder;
	private java.time.LocalDateTime timestampDeliveredOrder;
	private static final int MAX_DISHES = 10;
	private DishVO[] shoppingBasket;
	private CustomerVO customer;
	private int index;

	/**
	 * constructor
	 * 
	 * @param timestampStartedOrder
	 * @param customer
	 */

	OrderVO(int orderNo, String state, java.time.LocalDateTime timestampStartedOrder, CustomerVO customer) {
		setOrderNo(orderNo);
		setState(state);
		setTimestampStartedOrder(timestampStartedOrder);
		setTimestampDeliveredOrder(null);
		setCustomer(customer);
		this.shoppingBasket = new DishVO[MAX_DISHES];
		index = 0;
		setState("started");

	}

	public float calculatePriceDishes() {
		float sum = 0.0f;
		for (int i = 0; i < shoppingBasket.length; i++) {
			if (shoppingBasket[i] != null) {
				sum += shoppingBasket[i].getPrice();
			}
		}
		return sum;
	}

	// methods to convert timestamps to strings

	String startedDateToString() {
		if (timestampStartedOrder != null) {
			return timestampStartedOrder.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh mm"));
		}
		return "Not available.";
	}

	String deliveredDateToString() {
		if (timestampDeliveredOrder != null) {
			return timestampDeliveredOrder.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh mm"));
		}
		return "Not available.";
		// return String.format("From %1$tm/%1$td/%1$tY %$tH:%1$tM to" +
		// "%2tm/%2$td/%2$tY %2$tH:%2$tM\n", timestampDeliveredOrder, null);
	}

	// add dish to shopping basket

	public void addDish(DishVO dish) {
		if (index < MAX_DISHES) {
			shoppingBasket[index] = dish;
			index++;
		}
	}

	// deletes last dish from shopping basket

	public void deleteDish() {
		if (index > 0) {
			shoppingBasket[index - 1] = null;
			this.index--;
		} else if (index == 0) {
			shoppingBasket[0] = null;
		}
	}

	// get dish at index from shopping basket

	public DishVO getDish(int index) {
		if (shoppingBasket[index] != null) {
			return shoppingBasket[index];
		} else {
			return null;
		}
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + index;
		result = prime * result + orderNo;
		result = prime * result + Arrays.hashCode(shoppingBasket);
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((timestampDeliveredOrder == null) ? 0 : timestampDeliveredOrder.hashCode());
		result = prime * result + ((timestampStartedOrder == null) ? 0 : timestampStartedOrder.hashCode());
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
		OrderVO other = (OrderVO) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (index != other.index)
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (!Arrays.equals(shoppingBasket, other.shoppingBasket))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (timestampDeliveredOrder == null) {
			if (other.timestampDeliveredOrder != null)
				return false;
		} else if (!timestampDeliveredOrder.equals(other.timestampDeliveredOrder))
			return false;
		if (timestampStartedOrder == null) {
			if (other.timestampStartedOrder != null)
				return false;
		} else if (!timestampStartedOrder.equals(other.timestampStartedOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(
				String.format("OrderVO %s from %s with delivery at %s\n of customer: %s %s, ID of customer: %s",
						this.orderNo, startedDateToString(), deliveredDateToString(), this.customer.firstName,
						this.customer.lastName, this.customer.getId()));
		if (shoppingBasket != null) {
			for (var i = 0; i < shoppingBasket.length; i++) {
				DishVO item = shoppingBasket[i];
				if (item != null) {
					sb.append("\n" + item.toString());
				}
			}
		}
		sb.append("\n\n");
		return sb.toString();
	}

	// getters and setters

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public java.time.LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(java.time.LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}

	public java.time.LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	public void setTimestampDeliveredOrder(java.time.LocalDateTime timestampDeliveredOrder) {
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public int getMAX_DISHES() {
		return MAX_DISHES;
	}

	public int getNumberOfDishes() {
		return index;
	}

	public void setShoppingBasket(DishVO[] shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public DishVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	public int getIndex() {
		return index;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
