package atm.com.Bo;

public class Signup {

	public Signup() {
		// TODO Auto-generated constructor stub
	}
	public Signup(String carNo, String pinNo) {
		super();
		this.cardNo = carNo;
		this.pinNo = pinNo;
	}
	private String cardNo;
	private String pinNo;
	public String getCarNo() {
		return cardNo;
	}
	public void setCardNo(String carNo) {
		this.cardNo = carNo;
	}
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	
	
}
