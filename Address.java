package coursework;

public class Address {
	private int houseNo;
	private String postcode;
	private String city;
	
	public Address (int houseNo, String postcode, String city) {
		this.houseNo = houseNo;
		this.postcode = postcode;
		this.city = city;
	}
	
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	public int getHouseNo() {
		return this.houseNo;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPostcode() {
		return this.postcode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
}
