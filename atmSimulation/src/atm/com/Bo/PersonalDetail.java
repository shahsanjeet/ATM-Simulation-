/**
 * 
 */
package atm.com.Bo;

import java.util.Date;

/**
 * @author PRAVEEN RAJ
 *
 */
public class PersonalDetail {

	/**
	 * 
	 */
	private String name;
	private String fname;
	private Date dob;
	private String gender;
	private String email;
	private String maritalStatus;
	private String address;
	private String city;
	private String pincode;
	private String state;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public PersonalDetail() {
		// TODO Auto-generated constructor stub
	}
	public PersonalDetail(String name, String fname, Date dob, String gender,
			String email, String maritalStatus, String address, String city,
			String pincode, String state) {
		super();
		this.name = name;
		this.fname = fname;
		this.setDob(dob);
		this.gender = gender;
		this.email = email;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
