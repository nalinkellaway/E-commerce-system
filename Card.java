package coursework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Card implements Payment {
	private long cardNum;
	private int securityNum;
	
	public Card (long cardNum, int securityNum) {
		this.cardNum = cardNum;
		this.securityNum = securityNum;
	}
	
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	
	public long getCardNum() {
		return this.cardNum;
	}
	
	public void setSecurityNum(int securityNum) {
		this.securityNum = securityNum;
	}
	
	public int getSecurityNum() {
		return this.securityNum;
	}
	
	// validates card has correct format
	public boolean validatePayment() {		
		if (Long.toString(this.cardNum).length() == 16 && Integer.toString(this.securityNum).length() == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	//changes the products stock number when they are bought
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
