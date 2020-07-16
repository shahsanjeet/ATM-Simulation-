package atm.com.Bo;

public class Deposit {

	public Deposit() {
		// TODO Auto-generated constructor stub
	}

	
	private String cardNo;
	private double amount;
	
	private int uid;
	
	public Deposit(String cardNo, double amount, int uid) {
		super();
		this.cardNo = cardNo;
		this.amount = amount;
		this.uid = uid;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
