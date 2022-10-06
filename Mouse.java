package coursework;

public class Mouse extends Product{
	
	private MouseType mouseType;
	private int numOfButtons;
	
	public Mouse (int barcode, String brand, String colour, boolean wireless, int stockNum, float originalCost, float retailPrice, MouseType mouseType, int numOfButtons) {
		super(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice);
		this.mouseType = mouseType;
		this.numOfButtons = numOfButtons;
	}
	
	public MouseType getMouseType() {
		return this.mouseType;
	}
	
	public void setNumOfButtons(int numOfButtons) {
		this.numOfButtons = numOfButtons;
	}
	
	public int getNumOfButtons() {
		return this.numOfButtons;
	}
	
	@Override
	public String getType() {
		return this.mouseType.toString();
	}
	
	@Override
	public String getExtraDetail() {
		return Integer.toString(this.getNumOfButtons());
	}
	
	@Override
	public String getProductType() {
		return "Mouse";
	}
}
