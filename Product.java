package coursework;

public class Product {
	private int barcode;
	private String brand;
	private String colour;
	private boolean wireless;
	private int stockNum;
	private float originalCost;
	private float retailPrice;
	
	public  Product(int barcode, String brand, String colour, boolean wireless, int stockNum, float originalCost, float retailPrice) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.wireless = wireless;
		this.stockNum = stockNum;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
	}
	
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
	public int getBarcode() {
		return this.barcode;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	public boolean getWireless() {
		return this.wireless;
	}
	
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	
	public int getStockNum() {
		return this.stockNum;
	}
	
	public void setOriginalCost(float originalCost) {
		this.originalCost = originalCost;
	}
	
	public float getOriginalCost() {
		return this.originalCost;
	}
	
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public float getRetailPrice() {
		return this.retailPrice;
	}
	
	public String getType() {
		return "";
	}
	
	public String getExtraDetail() {
		return "";
	}
	
	public String getProductType() {
		return "Product";
	}
	
	public String getConnectivity() {
		if (wireless) {
			return "Wireless";
		} else {
			return "Wired";
		}
	}
	
	// when the customer searches, this is run and returns a boolean for each product
	// it is true when it meets search terms, false otherwise
	public boolean getSearchResult(Product p, String brand, boolean uk) {
		if (p.getProductType().equals("Keyboard") && uk && ! brand.isEmpty()) {
			if (p.getBrand().equals(brand) && p.getExtraDetail().toLowerCase().equals("uk")) {
				return true;
			} else { 
				return false;
			}
		} else if (! brand.isEmpty() && ! uk) {
			if (p.getBrand().equals(brand)) {
				return true;
			} else {
				return false;
			}
		} else if (p.getProductType().equals("Keyboard") && uk && brand.isEmpty()) {
			if (p.getExtraDetail().toLowerCase().equals("uk")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// prints all stock for customer to see
	public String printAll(String textToPrint) {
		String type = this.getType();
		String prodType = this.getProductType();
		String connect = this.getConnectivity();
		textToPrint += "Barcode: " + this.getBarcode() + "          Product Type: " + prodType + "          Type: " + type + "\n";
		textToPrint += "Brand:     " + this.getBrand() + "          Colour: " + this.getColour() + "                       Connectivity: " + connect + "\n";
		if (prodType.equals("Keyboard")) { 
			textToPrint += "Number in stock: " + this.getStockNum() + "       Price £" + String.format("%.2f", this.getRetailPrice()) + "                            Details: " + this.getExtraDetail() + " Layout";
		} else {
			textToPrint += "Number in stock: " + this.getStockNum() + "       Price £" + String.format("%.2f", this.getRetailPrice()) + "                            Details: " + this.getExtraDetail() + " Buttons";
		}
		textToPrint += "\n \n";
		return textToPrint;
	}
	
	// prints all stock for admin to see
	public String printAllAdmin(String textToPrint) {
		String type = this.getType();
		String prodType = this.getProductType();
		String connect = this.getConnectivity();
		textToPrint += "Barcode: " + this.getBarcode() + "          Product Type: " + prodType + "          Type: " + type + "\n";
		textToPrint += "Brand:     " + this.getBrand() + "          Colour: " + this.getColour() + "                       Connectivity: " + connect + "\n";
		if (prodType.equals("Keyboard")) { 
			textToPrint += "Original Cost £" + String.format("%.2f", this.getOriginalCost()) + "       Price £" + String.format("%.2f", this.getRetailPrice()) + "                            Details: " + this.getExtraDetail() + " Layout \n";
		} else {
			textToPrint += "Original Cost: £" + String.format("%.2f", this.getOriginalCost()) + "       Price £" + String.format("%.2f", this.getRetailPrice()) + "                            Details: " + this.getExtraDetail() + " Buttons \n";
		}
		textToPrint += "Number In Stock: " + this.getStockNum();
		textToPrint += "\n \n";
		return textToPrint;
	}
}
