
public interface IService {
	public default String startService(OrderVO order) {
		return "start service";
	}
}
