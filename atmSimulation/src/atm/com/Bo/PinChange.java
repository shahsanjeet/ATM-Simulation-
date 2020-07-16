package atm.com.Bo;

public class PinChange{

	private String currentPin;
	private String newPin;
	private String conformPin;
	private String cardno;
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public PinChange() {
		// TODO Auto-generated constructor stub
	}
	public String getCurrentPin() {
		return currentPin;
	}
	public void setCurrentPin(String currentPin) {
		this.currentPin = currentPin;
	}
	public String getNewPin() {
		return newPin;
	}
	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}
	public String getConformPin() {
		return conformPin;
	}
	public void setConformPin(String conformPin) {
		this.conformPin = conformPin;
	}
	public PinChange(String currentPin, String newPin, String conformPin,
			String cardno) {
		super();
		this.currentPin = currentPin;
		this.newPin = newPin;
		this.conformPin = conformPin;
		this.cardno = cardno;
	}
	

}
