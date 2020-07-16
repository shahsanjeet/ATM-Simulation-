/**
 * 
 */
package atm.com.Bo;

/**
 * @author PRAVEEN RAJ
 *
 */
public class AdditionalDetail {

	/**
	 * 
	 */
	private String religion;
	private String category;
	private String income;
	private String education;
	private String occupation;
	private String panNo;
	private String adarNo;
	private String seniorCitizen;
	private String existingAc;
	private String cardno;
	private String pin;
	
	public String getCardno() {
		return cardno;
	}

	public String getPin() {
		return pin;
	}

	public AdditionalDetail() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AdditionalDetail(String religion, String category, String income,
			String education, String occupation, String panNo, String adarNo,
			String seniorCitizen, String existingAc, String cardno, String pin) {
		super();
		this.religion = religion;
		this.category = category;
		this.income = income;
		this.education = education;
		this.occupation = occupation;
		this.panNo = panNo;
		this.adarNo = adarNo;
		this.seniorCitizen = seniorCitizen;
		this.existingAc = existingAc;
		this.cardno = cardno;
		this.pin = pin;
	}

	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAdarNo() {
		return adarNo;
	}
	public void setAdarNo(String adarNo) {
		this.adarNo = adarNo;
	}
	public String getSeniorCitizen() {
		return seniorCitizen;
	}
	public void setSeniorCitizen(String seniorCitizen) {
		this.seniorCitizen = seniorCitizen;
	}
	public String getExistingAc() {
		return existingAc;
	}
	public void setExistingAc(String existingAc) {
		this.existingAc = existingAc;
	}
	

}
