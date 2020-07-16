package atm.com.Bo;

public class User {

	/*
	 *uid number(10) primary key,
	cardNo varchar2(20),
	pinNo varchar2(20),
	amount number(10,5),
	foreign key (uid) refe
	 */
	private String carNo;
	private String pinNo;
	double amount;
	int uid;
	
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
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
	User(){
		
	}
	
}
