package atm.com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.Account;
import atm.com.factory.DaoFactory;
import atm.com.mail.Mail2;

/**
 * Servlet implementation class DepositController
 */
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardNo=null;
		cardNo=request.getParameter("cardno");
		//System.out.println(cardNo);
		
		String amountstr=request.getParameter("amount");
		Double amount=Double.parseDouble(amountstr);
		Account amount1 =new Account(amount,cardNo);
		boolean amt=DaoFactory.getAtmDao().deposit(amount1);
		if(amt){
		String gmail=DaoFactory.getAtmDao().getGmail(cardNo);
		
		String msg="Money Deposit Successfully : Rs"+amount;
		System.out.println(msg);
		
		//Mail2 mail=new Mail2();
		try {
			 boolean res=Mail2.sendotp(gmail,msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(amt){
			response.sendRedirect("sucessfully.jsp?cardno="+cardNo+"");
		}else{
			response.sendRedirect("error.jsp?cardno="+cardNo+"");
		}
	}
}
