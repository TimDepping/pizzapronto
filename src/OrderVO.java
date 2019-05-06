import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderVO {
	
	/**
	 * OrderVO represents an order
	 * @author Tim Depping
	 */
	
	private static int nextOrderNo = 0;
	private int orderNo;
	private java.time.LocalDateTime timestampStartedOrder;
	private java.time.LocalDateTime timestampDeliveredOrder;
	private static final int MAX_DISHES = 10;
	private PizzaVO[] shoppingBasket;
	private CustomerVO customer;
	private int index;
	
	/**
	 * constructor
	 * @param timestampStartedOrder
	 * @param customer
	 */
	
	OrderVO(java.time.LocalDateTime timestampStartedOrder, CustomerVO customer) {
		if (nextOrderNo == 0 || LocalDateTime.now().getDayOfMonth() == 1 && timestampStartedOrder.getMonthValue() == 1) {
			nextOrderNo = LocalDateTime.now().getYear() * 100000;
		}
		orderNo = ++nextOrderNo;
		setTimestampStartedOrder(timestampStartedOrder);
		setTimestampDeliveredOrder(null);
		setCustomer(customer);
		this.shoppingBasket = new PizzaVO[MAX_DISHES];
		index = 0;
		
	}
	
	//methods to convert timestamps to strings
	
	String startedDateToString() {
		if(timestampStartedOrder != null) {
			return timestampStartedOrder.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh mm"));
		}
		return "Not available.";
	}
	
	String deliveredDateToString() {
		if(timestampDeliveredOrder != null) {
			return timestampDeliveredOrder.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh mm"));
		}
		return "Not available.";
	}
	
	//Verwaltungsmethoden
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNo;
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
		if (orderNo != other.orderNo)
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder text = new StringBuilder(String.format("Order: %s \n Started: %s\n Delivered: %s\n Customer: %s", this.orderNo, startedDateToString(), deliveredDateToString(), this.customer.toString()));  
		if(shoppingBasket != null) {
			for(var i = 0; i < shoppingBasket.length; i++) {
				if(shoppingBasket[i] != null) {
					text.append("\n" + shoppingBasket[i].toString());
				}
			}
		}

		return text.toString();
	}
	
	//Getter and setter

	public int getOrderNo() {
		return orderNo;
	}
	
	public static int getNextOrderNo() {
		return nextOrderNo;
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
	
	public PizzaVO[] getShoppingBasket() {
		return shoppingBasket;
	}
	
	public int getNumberOfDishes() {
		return index;
	}
	
	public void setShoppingBasket(PizzaVO[] shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}
	
	public int getIndex() {
		return index;
	}
	
	//add dish to shopping basket
	
	public void addDish(PizzaVO dish) {
		if (index < MAX_DISHES) {
			shoppingBasket[index] = dish;
			index++;
		}
	}
	
	//deletes last dish from shopping basket
	
	public void deleteDish() {
		if (index > 0) {
			shoppingBasket[index - 1] = null;
			this.index--;
		} else if (index == 0) {
			shoppingBasket[0] = null;
		}
	}
	
	//get dish at index from shopping basket
	
	public PizzaVO getDish(int index) {
		if (shoppingBasket[index] != null) {
			return shoppingBasket[index];
		} else {
			return null;
		}
	}
	
}
