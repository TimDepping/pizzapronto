package de.thb.dim.pizzaPronto.controller;
import java.util.List;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public interface IOrdering {

	public OrderVO startNewOrder(CustomerVO customer);

	public void addDish(DishVO dish) throws NoOrderException;

	public void deleteDish(DishVO dish) throws NoOrderException;

	public float calculateTotalPrice() throws NoOrderException;

	public void confirmOrder() throws NoOrderException, NoCustomerException;
	
	public List<DishVO> sortShoppingBasket() throws NoOrderException;
	
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException;
	
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException;

}
