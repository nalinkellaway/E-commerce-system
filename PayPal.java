package coursework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PayPal implements Payment {
	private String email;
	
	public PayPal (String email) {
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	// checks if email has an @ in it
	public boolean validatePayment() {
		if (this.email.contains("@")) {
			return true;
		} else {
			return false;
		}
	}
	
	// removes the quantity purchased from the number in stock
	public void completeTransaction(HashMap<Integer, Integer> prodWithQuantity, List<Product> stockList) {
		for (Integer i : prodWithQuantity.keySet()) {
			for (int j=0;j<stockList.size();j++) {
				if (stockList.get(j).getBarcode() == i) {
					stockList.get(j).setStockNum(stockList.get(j).getStockNum()-prodWithQuantity.get(i));
				}
			}
		}
		try {
			FileManager.newStocks(stockList);
		} catch (IOException e) {
		}
	}
}
