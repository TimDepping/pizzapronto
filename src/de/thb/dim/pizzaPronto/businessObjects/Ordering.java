package de.thb.dim.pizzaPronto.businessObjects;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.controller.IOrdering;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

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
	public OrderVO startNewOrder(CustomerVO customer) throws NullPointerException {
		Objects.requireNonNull(customer, "Customer must not be null");
		if (menu != null) {
				setCurrentCustomer(customer);
				// Change OrderNo
				if (nextId == 0
						|| Integer.parseInt(Integer.toString(nextId).substring(0, 4)) < LocalDateTime.now().getYear()) {
					nextId = LocalDateTime.now().getYear() * 100000;
				}
				nextId++;
				setCurrentOrder(new OrderVO(nextId, StateOfOrderVO.STARTED, LocalDateTime.now(), currentCustomer));
				currentCustomer.setOrder(currentOrder);
				return currentOrder;
			
		}
		return null;

	}

	@Override
	public void addDish(DishVO dish) throws NoOrderException {
		if (currentOrder != null) {
			if (currentOrder.getState() == StateOfOrderVO.STARTED) {
				currentOrder.addDish(dish);
			} else {
				throw new IllegalStateException("Your order is complete, you can not add any dishes.");
			}
		} else {
			throw new NoOrderException("There is no order.");
		}
	}

	@Override
	public void deleteDish(DishVO dish) throws NoOrderException {
		if (currentOrder != null) {
			if (currentOrder.getState() == StateOfOrderVO.STARTED) {
				currentOrder.deleteDish(dish);
			} else {
				throw new IllegalStateException("Your order is complete, you can not delete any dishes.");
			}
		}  else {
			throw new NoOrderException("There is no order.");
		}
	}

	@Override
	public float calculateTotalPrice() throws NoOrderException {
		if (currentOrder != null) {
			return currentOrder.calculatePriceDishes();
		}
		throw new NoOrderException("There is no order.");
	}

	@Override
	public void confirmOrder() throws NoOrderException, NoCustomerException {
		if (currentOrder != null) {
			if (currentOrder.getState() == StateOfOrderVO.STARTED) {
				currentOrder.setState(StateOfOrderVO.CONFIRMED);
				try {
					startService();
				} catch(IllegalStateException | NoCustomerException | NoOrderException e) {
					System.err.println("Internal error by processing an order: " + e.getMessage());
				}
			} else {
				throw new IllegalStateException("Your order can not be confirmed.");
			}
		} else {
			throw new NoOrderException("There is no order.");
		}
	}

	public void startService() throws NoOrderException, NoCustomerException {
		if (currentOrder != null) {
			if (currentOrder.getState() == StateOfOrderVO.STARTED) {
				throw new IllegalStateException("The order can not be processed.");
			}
			if (currentOrder.getState() == StateOfOrderVO.CONFIRMED) {
				System.out.println(kitchen.startService(currentOrder));
			}
			if (currentOrder.getState() == StateOfOrderVO.READY) {
				System.out.println(delivery.startService(currentOrder));
			}
			if (currentOrder.getState() == StateOfOrderVO.DELIVERED) {
				currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
				currentOrder.setState(StateOfOrderVO.FINISHED);
				System.out.println("Order completed: " + currentOrder.toString());
			}
		} else {
			throw new NoOrderException("There is no order.");
		}
	}
	
	@Override
	public List<DishVO> sortShoppingBasket() throws NoOrderException {
		if (currentOrder != null) {
			Collections.sort(currentOrder.getShoppingBasket(), new Comparator<DishVO>() {

				@Override
				public int compare(DishVO o1, DishVO o2) {
					return o1.compareTo(o2);
				}
				
			});
		return currentOrder.getShoppingBasket();
		}
		throw new NoOrderException("There is no order.");
	}

	@Override
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException {
		if(currentOrder != null) {
			Collections.sort(currentOrder.getShoppingBasket(), new Comparator<DishVO>() {

				@Override
				public int compare(DishVO o1, DishVO o2) {
					return Integer.compare(o1.getNumberOfDish(), o2.getNumberOfDish());
				}
			
			});
		return currentOrder.getShoppingBasket();
		}
		throw new NoOrderException("There is no order.");
	}

	@Override
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException{
		if(currentOrder != null) {
			currentOrder.getShoppingBasket().sort((DishVO o1, DishVO o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
			return currentOrder.getShoppingBasket();
		}
		throw new NoOrderException("There is no order.");
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

	public static MenuVO getMenu() {
		return menu;
	}

	public static int getNextId() {
		return nextId;
	}

	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(OrderVO currentOrder) {
		if(currentOrder != null) {
			this.currentOrder = currentOrder;
		}
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
