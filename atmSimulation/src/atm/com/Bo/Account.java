package atm.com.Bo;

public class Account {
	
	private double rupes;
	private String cardNo;
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getRupes() {
		return rupes;
	}

	public void setRupes(double rupes) {
		this.rupes = rupes;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(double rupes, String cardNo) {
		super();
		this.rupes = rupes;
		this.cardNo = cardNo;
	}

	

}
