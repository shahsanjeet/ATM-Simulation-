package atm.com.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.sun.mail.iap.Response;

import atm.com.Bo.Account;
import atm.com.Bo.AccountDetail;
import atm.com.Bo.AdditionalDetail;
import atm.com.Bo.ForgetPassword;
import atm.com.Bo.MiniStatement;
import atm.com.Bo.PersonalDetail;
import atm.com.Bo.PinChange;
import atm.com.Bo.Signup;
import atm.com.Dao.AtmDao;
import atm.com.mail.Mail;
import atm.com.util.SisDbUtil;

public  class atmDaoOracleImpl implements AtmDao {
	@Override
	public boolean addRecord(PersonalDetail p) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet  rs=null;
		int rs1=0,rs2=0;
		int sno=0;
		Date dob1=null;
		try{
		long time2=p.getDob().getTime();
		 dob1=new java.sql.Date(time2); 
		System.out.println(p.getMaritalStatus());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			
			con= SisDbUtil.getConnection();
			
			String sql="insert into person_req (sno,req_time) values ((select nvl(max(sno),0)+1 from person_req),sysdate)";
			pstmt=con.prepareStatement(sql);						
			rs1=pstmt.executeUpdate();
			if(rs1!=0){
				String sql1="select max(sno) from person_req";
				pstmt=con.prepareStatement(sql1);
				rs=pstmt.executeQuery();
				while(rs.next()){
					sno=rs.getInt(1);
				}
				System.out.println(sno);
				if(rs!=null){
					String sql2="insert into person (sno,name,fname,dob,gender,email,maritalstatus,address,city,pincode,state) values(?,?,?,?,?,?,?,?,?,?,?)";
					pstmt=con.prepareStatement(sql2);
					
					System.out.println(dob1);
					pstmt.setInt(1,sno);
					pstmt.setString(2,p.getName());
					pstmt.setString(3,p.getFname());
					pstmt.setDate(4,dob1);
					pstmt.setString(5,p.getGender());
					pstmt.setString(6,p.getEmail());
					pstmt.setString(7,p.getMaritalStatus());
					pstmt.setString(8,p.getAddress());
					pstmt.setString(9,p.getCity());
					pstmt.setString(10,p.getPincode());
					pstmt.setString(11,p.getState());
					rs2=pstmt.executeUpdate();
					System.out.println("inserted");
				}
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs1!=0 && rs2!=0){
		return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean pinChange(PinChange pin) {
		// TODO Auto-generated method stub
		int rs1=0;
		ResultSet res1=null;
		Connection con=null;
		String cardNo=null;
		String pinNo=null;
		PreparedStatement pstmt;
		cardNo=pin.getCardno();
		try{	
			con=SisDbUtil.getConnection();
			
				String sql3="select pinNo from accountHolder where cardNo=?";
					pstmt=con.prepareStatement(sql3);
					pstmt.setString(1,cardNo);
					res1=pstmt.executeQuery();
					while(res1.next()){
						pinNo=res1.getString(1);
					}
				if(pinNo.equals(pin.getCurrentPin())&&(pin.getNewPin().equals(pin.getConformPin()))){
					String sql2="update accountholder set pinNo=? where cardNo=?";
					pstmt=con.prepareStatement(sql2);
					pstmt.setString(1,pin.getNewPin());
					pstmt.setString(2,cardNo);
					rs1=pstmt.executeUpdate();
					
				}//if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		if(rs1!=0){
		return true;
		}else{
			return false;
		}//else

	}

	@Override
	public boolean deposit(Account acc) {
		// TODO Auto-generated method stub
		int rs1=0;
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet res2=null;
		String cardNo=null;
		double amount=0;
		double amt=acc.getRupes();
		cardNo=acc.getCardNo();
		
		try{	
			con=SisDbUtil.getConnection();
	
					con.setAutoCommit(false);
					String sql1="select sum(amount) from deposit where cardNo=?";
					pstmt=con.prepareStatement(sql1);
					
					pstmt.setString(1,cardNo);
					res2=pstmt.executeQuery();
					res2.next();
					amount=res2.getLong(1);
					if(amount>0){
						amount=amount+acc.getRupes();
						String sql3="update deposit set AMOUNT=? where CARDNO=?";
						pstmt=con.prepareStatement(sql3);
						pstmt.setDouble(1,amount);
						pstmt.setString(2,cardNo);
						rs1=pstmt.executeUpdate();
						String sql6="insert into deposit_log(DNO,CARDNO,AMOUNT,transaction,DEPOSIT_TIME) values((select nvl(max(DNO),0)+1 from deposit_log ),?,?,?,sysdate)";
						pstmt=con.prepareStatement(sql6);
						pstmt.setString(1,cardNo);
						pstmt.setDouble(2,amt);
						pstmt.setString(3,"deposit");
						rs1=pstmt.executeUpdate();
					}else{
						amount=acc.getRupes();
						String sql4="insert into deposit(DNO,CARDNO,AMOUNT,DEPOSIT_TIME) values((select nvl(max(DNO),0)+1 from deposit ),?,?,sysdate)";
						pstmt=con.prepareStatement(sql4);
						pstmt.setString(1,cardNo);
						pstmt.setDouble(2,amount);
						rs1=pstmt.executeUpdate();
						
						String sql5="insert into deposit_log(DNO,CARDNO,AMOUNT,transaction,DEPOSIT_TIME) values((select nvl(max(DNO),0)+1 from deposit_log ),?,?,?,sysdate)";
						pstmt=con.prepareStatement(sql5);
						pstmt.setString(1,cardNo);
						pstmt.setDouble(2,amount);
						pstmt.setString(3,"deposit");
						rs1=pstmt.executeUpdate();
						con.commit();
					}
					//System.out.println(amount);
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("transaction fail");
			}
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		if(rs1!=0){
			return true;
		}else{
			return false;
		}//else

	}//method

	@Override
	public boolean withdrol(Account acc) {
		// TODO Auto-generated method stub
		int rs1=0;
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet res2=null;
		
		String cardNo=null;
		double amount=0;
		double amt=acc.getRupes();
		cardNo=acc.getCardNo();
		try{	
			con=SisDbUtil.getConnection();
			con.setAutoCommit(false);
					String sql2="select sum(amount) from deposit where cardNo=?";
					pstmt=con.prepareStatement(sql2);
					pstmt.setString(1,cardNo);
					res2=pstmt.executeQuery();
					res2.next();
					amount=res2.getLong(1);
					if(amount>0){
						amount=amount-acc.getRupes();
						if(amount>=0){
							String sql3="update deposit set AMOUNT=? where CARDNO=?";
							pstmt=con.prepareStatement(sql3);
							pstmt.setDouble(1,amount);
							pstmt.setString(2,cardNo);
							rs1=pstmt.executeUpdate();
							
							String sql5="insert into deposit_log(DNO,CARDNO,AMOUNT,transaction,DEPOSIT_TIME) values((select nvl(max(DNO),0)+1 from deposit_log ),?,?,?,sysdate)";
							pstmt=con.prepareStatement(sql5);
							pstmt.setString(1,cardNo);
							pstmt.setDouble(2,amt);
							pstmt.setString(3,"withdrol");
							rs1=pstmt.executeUpdate();
							
						}else{
							rs1=0;
						}
					}else{
						rs1=0;
					}
					//System.out.println(amount);
					con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("transaction failed");
			}
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		if(rs1!=0){
			return true;
		}else{
			return false;
		}//else

	}//method

	@Override
	public ArrayList<MiniStatement> ministatement(String cardNo) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet res2=null;
		double amount=0;
		ArrayList<MiniStatement> list=new ArrayList<MiniStatement>();
		try{	
				con=SisDbUtil.getConnection();
		
				String sql2="select amount,transaction,deposit_time from deposit_log where cardNo=?";
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1,cardNo);
				res2=pstmt.executeQuery();
				while(res2.next()){
					
					amount=res2.getLong(1);
					String transaction=res2.getString(2);
					String depodit_time=res2.getTimestamp(3)+"";
					MiniStatement min=new MiniStatement();
					min.setDamount(amount);
					min.setDtime(depodit_time);
					min.setTransaction(transaction);
					list.add(min);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//finaly	
		return list;
	}

	@Override
	public double blanceEnquary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addRecord1(AdditionalDetail A) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet  rs=null;
		ResultSet  rs_1=null;
		int rs1=0,rs2=0,rs3=0;
		int userid=0;
		int sno=0;
		System.out.println("account controller");
		try{	
			con= SisDbUtil.getConnection();
			
			String sql="insert into AccountHolder (userid,cardNo,pinNo) values ((select nvl(max(userid),0)+1 from AccountHolder),?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,A.getCardno());
			pstmt.setString(2,A.getPin());
			rs1=pstmt.executeUpdate();
			if(rs1!=0){
				String sql1="select max(userId) from AccountHolder";
				pstmt=con.prepareStatement(sql1);
				rs=pstmt.executeQuery();
				while(rs.next()){
					 userid=rs.getInt(1);
				}
				String sql2="select max(sno) from person";
				pstmt=con.prepareStatement(sql2);
				rs_1=pstmt.executeQuery();
				while(rs_1.next()){
					sno=rs_1.getInt(1);
				}
				if(rs!=null && rs_1!=null){
					String sql3="insert into additional_req (sno,userid,req_time) values(?,?,SYSDATE)";
					pstmt=con.prepareStatement(sql3);
					
					pstmt.setInt(1,sno);
					pstmt.setInt(2,userid);
					rs2=pstmt.executeUpdate();
			
					System.out.println("inserted1-------");
			
					
					String sql4="insert into additionDetail (userid,sno,religion,category,income,education,occupation,panno,adarno,seniorCitizen,existingAc) values(?,?,?,?,?,?,?,?,?,?,?)";
					pstmt=con.prepareStatement(sql4);
					pstmt.setInt(1,userid);
					pstmt.setInt(2,sno);
					pstmt.setString(3,A.getReligion());
					pstmt.setString(4,A.getCategory());
					pstmt.setString(5,A.getIncome() );
					pstmt.setString(6,A.getEducation() );
					pstmt.setString(7,A.getOccupation());
					pstmt.setString(8,A.getPanNo());
					pstmt.setString(9,A.getAdarNo());
					pstmt.setString(10,A.getSeniorCitizen());
					pstmt.setString(11,A.getExistingAc());
						
					rs3=pstmt.executeUpdate();
					
					System.out.println("inserted2********");
				}//if result set
				
			}//rs
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs1!=0 && rs2!=0 && rs3!=0){
			//String cardPin=cardNo+"#"+pinNo;
		return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean acountDetail(AccountDetail ad) {
		// TODO Auto-generated method stub
		int rs1=0;
		int userid=0;
		Connection con=null;
		PreparedStatement pstmt;
		try{	
			con=SisDbUtil.getConnection();
			
			
			String sql1="select userid from AccountHolder where cardno=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,ad.getCardNo());
			ResultSet rs_1 = pstmt.executeQuery();
			while(rs_1.next()){
				userid=rs_1.getInt(1);
			}
			
				String sql2="insert into accountDetail (userid,accountType,ATM_CARD,INTERNET_BANKING,MOBILE_BANKING,EMAIL_ALERTS,E_STATEMENT,CHEQUE_BOOK,cardNo,confirm) values (?,?,?,?,?,?,?,?,?,?)";
					pstmt=con.prepareStatement(sql2);
					pstmt.setInt(1,userid);
					pstmt.setString(2,ad.getAccountType());
					pstmt.setString(3,ad.getServiceRequired1());
					pstmt.setString(4,ad.getServiceRequired2());
					pstmt.setString(5,ad.getServiceRequired3());
					pstmt.setString(6,ad.getServiceRequired4());
					pstmt.setString(7,ad.getServiceRequired5());
					pstmt.setString(8,ad.getServiceRequired6());
					pstmt.setString(9,ad.getCardNo());
					pstmt.setString(10,ad.getConfirm());
				
					rs1=pstmt.executeUpdate();
					System.out.println(rs1);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		if(rs1!=0){
			return true;
		}else{
			return false;
		}//else
	}//end  method

	@Override
	public boolean signup(Signup s) {
		// TODO Auto-generated method stub
		int rs1=0,rs2=0;
		Connection con=null;
		PreparedStatement pstmt;
		String cardno=s.getCarNo();
		String pin=s.getPinNo();
		try{	
			con=SisDbUtil.getConnection();
			String sql="select * from AccountHolder where cardno='"+cardno+"' and pinno='"+pin+"'";
			pstmt=con.prepareStatement(sql);
			rs1=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		if(rs1!=0){
		return true;
		}else{
			return false;
		}//else
	}

	@Override
	public boolean forgetPassword(ForgetPassword pass) {
		// TODO Auto-generated method stub
		
		String cardNo=pass.getCardno();
		String email=pass.getEmail();
		String email2=null;
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet res=null,res1=null,res3=null;
		int rs1=0,rs2=0;
		int userid=0;
		int sno=0;
		/*Random rand= new Random();
		char []pin =new char[4];
		pin[0]=(char) (rand.nextInt(9)+'1');
		for(int i=1;i<pin.length;i++){
			pin[i]=(char)(rand.nextInt(9)+'0');
		}
		String pinNo=new String(pin);*/
		//System.out.println("hello");
		try {			
			con=SisDbUtil.getConnection();
			String sql="select userid from AccountHolder where cardNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,cardNo);
			res=pstmt.executeQuery();
			while(res.next()){
				userid=res.getInt(1);
			}
			if(res!=null){
				String sql5="select sno from additional_req where userId=?";
				pstmt=con.prepareStatement(sql5);
				pstmt.setInt(1,userid);
				res3=pstmt.executeQuery();
				while(res3.next()){
					sno=res3.getInt(1);
				}
				if(res3!=null){
				String sql2="select email from person where sno=?";
				pstmt=con.prepareStatement(sql2);
				pstmt.setInt(1,sno);
				res1=pstmt.executeQuery();
				while(res1.next()){
					email2=res1.getString(1);
				}
				System.out.println(email2+"   "+email);
				if(res1!=null){
					if(email.equals(email2)){
						System.out.println("email same");
						String sql3="update accountholder set pinNo=? where cardNo=?";
						pstmt=con.prepareStatement(sql3);
						pstmt.setString(1,pass.getPinNo());
						pstmt.setString(2,cardNo);
						rs1=pstmt.executeUpdate();
						String sql4="update accountDetail set pin=? where cardNo=?";
						pstmt=con.prepareStatement(sql4);
						pstmt.setString(1,pass.getPinNo());
						pstmt.setString(2,cardNo);
						rs2=pstmt.executeUpdate();
						System.out.println("last update");
					}
				}//res1
				}//res3 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				SisDbUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finally
		if(rs1!=0&& rs2!=0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String getGmail(String cardno) {
		// TODO Auto-generated method stub
		String email=null;
		String cardNo=null;
		cardNo=cardno;
		ResultSet rs1=null,rs2=null,rs3=null;
		Connection con=null;
		PreparedStatement pstmt;
		long userid=0;
		int sno=0;
		try{	
			con=SisDbUtil.getConnection();
		
			String sql="select userid from AccountHolder where cardNo='"+cardNo+"'";
			pstmt=con.prepareStatement(sql);
			rs1=pstmt.executeQuery();
			if(rs1.next()){
				userid=rs1.getLong(1);
			}
			String sql1="select sno from additional_req where userid="+userid+"";
			pstmt=con.prepareStatement(sql1);
			rs2=pstmt.executeQuery();
			if(rs2.next()){
				sno=rs2.getInt(1);
			}
			String sql2="select email from person where sno="+sno+"";
			pstmt=con.prepareStatement(sql2);
			rs3=pstmt.executeQuery();
			if(rs3.next()){
				email=rs3.getString(1);
			}
			
			
			//System.out.println(rs1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finaly
		//if(rs1!=null && rs2!=null && rs2!=null)
		return email;
	}

}//class
