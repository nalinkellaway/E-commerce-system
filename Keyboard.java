package coursework;

public class Keyboard extends Product{
	
	private KeyboardType keyboardType;
	private KeyboardLayout keyboardLayout;
	
	public Keyboard (int barcode, String brand, String colour, boolean wireless, int stockNum, float originalCost, float retailPrice, KeyboardType keyboardType, KeyboardLayout keyboardLayout) {
		super(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice);
		this.keyboardType = keyboardType;
		this.keyboardLayout = keyboardLayout;
	}
	
	public KeyboardType getKeyboardType() {
		return this.keyboardType;
	}
	
	public KeyboardLayout getKeyboardLayout() {
		return this.keyboardLayout;
	}
	
	@Override
	public String getType() {
		return this.keyboardType.toString();
	}
	
	@Override
	public String getExtraDetail() {
		return this.getKeyboardLayout().toString();
	}
	
	@Override
	public String getProductType() {
		return "Keyboard";
	}
}
