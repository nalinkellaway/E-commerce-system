public class CreditCard implements PaymentMethod {

	private long cardNum;
	private int securityCode;

	public long getCardNum() {
		return this.cardNum;
	}

	/**
	 * 
	 * @param cardNum
	 */
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public int getSecurityCode() {
		return this.securityCode;
	}

	/**
	 * 
	 * @param securityCode
	 */
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

}