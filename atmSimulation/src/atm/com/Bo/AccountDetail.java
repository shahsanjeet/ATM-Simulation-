/**
 * 
 */
package atm.com.Bo;

/**
 * @author PRAVEEN RAJ
 *
 */
public class AccountDetail {

	/**
	 *
	 */
	private String accountType;
	private String serviceRequired1=null;
	private String serviceRequired2=null;
	private String serviceRequired3=null;
	private String serviceRequired4=null;
	private String serviceRequired5=null;
	private String serviceRequired6=null;
	private String confirm;
	private String cardNo=null;
	
	

	public String getServiceRequired1() {
		return serviceRequired1;
	}

	public void setServiceRequired1(String serviceRequired1) {
		this.serviceRequired1 = serviceRequired1;
	}

	public String getServiceRequired2() {
		return serviceRequired2;
	}

	public void setServiceRequired2(String serviceRequired2) {
		this.serviceRequired2 = serviceRequired2;
	}

	public String getServiceRequired3() {
		return serviceRequired3;
	}

	public void setServiceRequired3(String serviceRequired3) {
		this.serviceRequired3 = serviceRequired3;
	}

	public String getServiceRequired4() {
		return serviceRequired4;
	}

	public void setServiceRequired4(String serviceRequired4) {
		this.serviceRequired4 = serviceRequired4;
	}

	public String getServiceRequired5() {
		return serviceRequired5;
	}

	public void setServiceRequired5(String serviceRequired5) {
		this.serviceRequired5 = serviceRequired5;
	}

	public String getServiceRequired6() {
		return serviceRequired6;
	}

	public void setServiceRequired6(String serviceRequired6) {
		this.serviceRequired6 = serviceRequired6;
	}



	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public AccountDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public AccountDetail(String accountType, String serviceRequired1,
			String serviceRequired2, String serviceRequired3,
			String serviceRequired4, String serviceRequired5,
			String serviceRequired6, String confirm, String cardNo) {
		super();
		this.accountType = accountType;
		this.serviceRequired1 = serviceRequired1;
		this.serviceRequired2 = serviceRequired2;
		this.serviceRequired3 = serviceRequired3;
		this.serviceRequired4 = serviceRequired4;
		this.serviceRequired5 = serviceRequired5;
		this.serviceRequired6 = serviceRequired6;
		this.confirm = confirm;
		this.cardNo = cardNo;
	}

}
