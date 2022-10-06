package coursework;

import java.util.HashMap;
import java.util.List;

public interface Payment {
	public boolean validatePayment();
	public void completeTransaction(HashMap<Integer, Integer> prodWithQuantity, List<Product> stockList);
}
