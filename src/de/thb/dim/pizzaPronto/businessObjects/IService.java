package de.thb.dim.pizzaPronto.businessObjects;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.NoCustomerException;

public interface IService {
	public String startService(OrderVO order) throws NoCustomerException, IllegalStateException, NullPointerException;
}
