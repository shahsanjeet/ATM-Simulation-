package atm.com.Bo;

public class ForgetPassword {

	private String cardno;
	private String email;
	private String pinNo;
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	public ForgetPassword() {
		// TODO Auto-generated constructor stub
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ForgetPassword(String cardno, String email, String pinNo) {
		super();
		this.cardno = cardno;
		this.email = email;
		this.pinNo = pinNo;
	}
	

}
