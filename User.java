package coursework;

public class User {
	private int userID;
	private String username;
	private String surname;
	private Address address;
	
	public User(int userID, String username, String surname, Address address) {
		this.userID = userID;
		this.username = username;
		this.surname = surname;
		this.address = address;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
}
