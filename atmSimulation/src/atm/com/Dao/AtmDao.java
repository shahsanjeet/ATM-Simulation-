package atm.com.Dao;

import java.util.ArrayList;
import atm.com.Bo.Account;
import atm.com.Bo.AccountDetail;
import atm.com.Bo.AdditionalDetail;
import atm.com.Bo.ForgetPassword;
import atm.com.Bo.MiniStatement;
import atm.com.Bo.PersonalDetail;
import atm.com.Bo.PinChange;
import atm.com.Bo.Signup;

public interface  AtmDao {

	boolean addRecord(PersonalDetail p);
	boolean addRecord1(AdditionalDetail a);
	boolean acountDetail(AccountDetail ad);
	boolean pinChange(PinChange pin);
	boolean forgetPassword(ForgetPassword pass);
	boolean deposit(Account acc);
	boolean signup(Signup s);
	boolean withdrol(Account acc);
	ArrayList<MiniStatement> ministatement(String cardNo);
	double  blanceEnquary();
	String getGmail(String cardNo);
	
}
