import java.time.LocalDateTime;

public class Ordering implements IOrdering {
	private static MenuVO menu;
	private static int nextId = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;

	public Ordering() {
		menu = new MenuVO();
		setCurrentOrder(null);
		setCurrentCustomer(null);
		setKitchen(new Kitchen());
		setDelivery(new Delivery());

	}

	@Override
	public OrderVO startNewOrder(CustomerVO customer) {
		if (menu != null) {
			if (customer != null) {
				setCurrentCustomer(customer);
				// Change OrderNo
				if (nextId == 0
						|| Integer.parseInt(Integer.toString(nextId).substring(0, 4)) < LocalDateTime.now().getYear()) {
					nextId = LocalDateTime.now().getYear() * 100000;
				}
				nextId++;
				setCurrentOrder(new OrderVO(nextId, "started", LocalDateTime.now(), currentCustomer));
				currentCustomer.setOrder(currentOrder);
				return currentOrder;
			}
			return null;
		}
		return null;

	}

	@Override
	public void addDish(DishVO dish) {
		if (currentOrder != null) {
			if (currentOrder.getState() == "started") {
				currentOrder.addDish(dish);
			} else {
				System.out.println(" Your order is complete, you can not add any dishes. ");
			}
		} else {
			System.out.println(" Error: There is no order. ");

		}
	}

	@Override
	public void deleteDish() {
		if (currentOrder != null) {
			if (currentOrder.getState() == "started") {
				currentOrder.deleteDish();
			} else {
				System.out.println(" Your order is complete, you can not delete any dishes. ");
			}
		} else {
			System.out.println(" Error: There is no order. ");
		}
	}

	@Override
	public float calculateTotalPrice() {
		if (currentOrder != null) {
			return currentOrder.calculatePriceDishes();
		}
		System.out.println(" Error: There is no order. ");
		return 0.0f;
	}

	@Override
	public void confirmOrder() {
		if (currentOrder != null) {
			if (currentOrder.getState() == "started" && currentOrder.getNumberOfDishes() > 0) {
				currentOrder.setState("confirmed");
				startService();
			} else {
				System.out.println(" Your order can not be confirmed ");
			}
		} else {
			System.out.println(" Error: There is no order.");
		}
	}

	public void startService() {
		if (currentOrder != null) {
			if (currentOrder.getState() == "started") {
				System.out.print(" Your order can not be processed. ");
			}
			if (currentOrder.getState() == "confirmed") {
				System.out.println(kitchen.startService(currentOrder));
			}
			if (currentOrder.getState() == "ready") {
				System.out.println(delivery.startService(currentOrder));
			}
			if (currentOrder.getState() == "delivered") {
				currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
				currentOrder.setState("finished");
				System.out.println("Order completed: " + currentOrder.toString());
				currentCustomer.setOrder(null);
			}
		} else {
			System.out.println(" Error: There is no order. ");
		}
	}

	// Verwaltungsmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentCustomer == null) ? 0 : currentCustomer.hashCode());
		result = prime * result + ((currentOrder == null) ? 0 : currentOrder.hashCode());
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
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
		Ordering other = (Ordering) obj;
		if (currentCustomer == null) {
			if (other.currentCustomer != null)
				return false;
		} else if (!currentCustomer.equals(other.currentCustomer))
			return false;
		if (currentOrder == null) {
			if (other.currentOrder != null)
				return false;
		} else if (!currentOrder.equals(other.currentOrder))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (kitchen == null) {
			if (other.kitchen != null)
				return false;
		} else if (!kitchen.equals(other.kitchen))
			return false;
		return true;
	}

	// setters and getters

	public MenuVO getMenu() {
		return menu;
	}

	public int getNextId() {
		return nextId;
	}

	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(OrderVO currentOrder) {
		this.currentOrder = currentOrder;
	}

	public CustomerVO getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CustomerVO currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public IService getKitchen() {
		return kitchen;
	}

	public void setKitchen(IService kitchen) {
		this.kitchen = kitchen;
	}

	public IService getDelivery() {
		return delivery;
	}

	public void setDelivery(IService delivery) {
		this.delivery = delivery;
	}

}
