package de.thb.dim.pizzaPronto.businessObjects;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public interface IService {
	public String startService(OrderVO order) throws NoCustomerException, IllegalStateException, NullPointerException;
}
