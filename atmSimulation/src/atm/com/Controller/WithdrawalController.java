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
 * Servlet implementation class WithdrawalController
 */
public class WithdrawalController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawalController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardNo=null;
		cardNo=request.getParameter("cardno");
		
		boolean amt=false;
		String amountstr=request.getParameter("amount");
		System.out.println(amountstr);
		System.out.println("sdf");
		if(amountstr!=null){
			Double amount=Double.parseDouble(amountstr);
			Account amount1 =new Account(amount,cardNo);
			amt=DaoFactory.getAtmDao().withdrol(amount1);
			if(amt){
			String gmail=DaoFactory.getAtmDao().getGmail(cardNo);
			
			String msg="Money Credit Successfully : Rs"+amount;
			System.out.println(msg);
			//Mail2 mail=new Mail2();
			try {
				 boolean res=Mail2.sendotp(gmail,msg);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}else{
			response.sendRedirect("errorWithdrol.jsp?cardno="+cardNo+"");
		}
		if(amt){
			response.sendRedirect("sucessfully.jsp?cardno="+cardNo+"");
		}else{
			response.sendRedirect("errorWithdrol.jsp?cardno="+cardNo+"");
		}
	}

}