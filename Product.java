public class Product {

	private int barcode;
	private string brand;
	private string colour;
	private boolean wireless;
	private int stockNum;
	private float originalCost;
	private float retailPrice;

	public int getBarcode() {
		return this.barcode;
	}

	/**
	 * 
	 * @param barcode
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public string getBrand() {
		return this.brand;
	}

	/**
	 * 
	 * @param brand
	 */
	public void setBrand(string brand) {
		this.brand = brand;
	}

	public string getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(string colour) {
		this.colour = colour;
	}

	public boolean getWireless() {
		return this.wireless;
	}

	/**
	 * 
	 * @param wireless
	 */
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}

	public int getStockNum() {
		return this.stockNum;
	}

	/**
	 * 
	 * @param stockNum
	 */
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public float getOriginalCost() {
		return this.originalCost;
	}

	/**
	 * 
	 * @param originalCost
	 */
	public void setOriginalCost(float originalCost) {
		this.originalCost = originalCost;
	}

	public float getRetailPrice() {
		return this.retailPrice;
	}

	/**
	 * 
	 * @param retailPrice
	 */
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

}