package coursework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer extends User{
	
	private List<Product> basket;
	
	public Customer(int userID, String username, String surname, Address address) {
		super(userID, username, surname, address);
		this.basket = new ArrayList<Product>();
	}
	
	public void addToBasket(Product p) {
		this.basket.add(p);
	}
	
	public void clearBasket() {
		this.basket.clear();
	}
	
	public void saveBasket() {
		this.basket.clear();
	}
	
	public void checkoutBasket() {
		System.out.println(this.basket);
	}
	
	public List<Product> getBasket() {
		return this.basket;
	}
	
	// returns a hashmap with the item barcode linked the the number of those items in the basket	
	public HashMap<Integer, Integer> getBasketWithQuantity() {
		List<Product> tempList = new ArrayList<Product>();
		HashMap<Integer, Integer> prodWithQuantity = new HashMap<Integer, Integer>();
		// iterates through basket, if item is in the tempList it is duplicate and the value is added to the hashmap
		for (int i=0;i<this.basket.size();i++) {
			int barcode = this.basket.get(i).getBarcode();
			if (tempList.contains(this.basket.get(i))) {
				prodWithQuantity.put(barcode, prodWithQuantity.get(barcode) + 1);
			} else {
				tempList.add(this.basket.get(i));
				prodWithQuantity.put(barcode, 1);
			}
		}
		return prodWithQuantity;
	}
	
	// returns the items in the current basket as a string, so it can be shown on the user page
	public String stringBasket(HashMap<Integer, Integer> prodWithQuantity, List<Product> stockList) {
		String basketString = "";
		float total = 0;
		for (Integer i : prodWithQuantity.keySet()) {
			for (int j=0;j<stockList.size();j++) {
				Product p = stockList.get(j);
				if (p.getBarcode() == i) {
					basketString += "Barcode: " + i + " Brand : " + p.getBrand() + "\n";
					basketString += "Quantity: " + prodWithQuantity.get(i) + " Price: £" + String.format("%.2f", (p.getRetailPrice() * prodWithQuantity.get(i)));
					basketString += "\n \n";
					total += p.getRetailPrice() * prodWithQuantity.get(i);
				}
			}
		}
		basketString += "Total: £" + String.format("%.2f", total);
		return basketString;
	}
}
