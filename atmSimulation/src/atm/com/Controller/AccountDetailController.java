package atm.com.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.AccountDetail;
import atm.com.factory.DaoFactory;

/**
 * Servlet implementation class AccountDetailController
 */
public class AccountDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("account detail");
		String cardNo=request.getParameter("cardno");
		String accountType = request.getParameter("acc_type");
		String serviceRequired1=request.getParameter("atm");
		String serviceRequired2= request.getParameter("internet");
		String serviceRequired3= request.getParameter("mob");
		String serviceRequired4= request.getParameter("email");
		String serviceRequired5= request.getParameter("cheque");
		String serviceRequired6= request.getParameter("estatement");
		String confirm =request.getParameter("confirm");
		
		AccountDetail ad=new AccountDetail(accountType,serviceRequired1,serviceRequired2,serviceRequired3,serviceRequired4,serviceRequired5,serviceRequired6,confirm,cardNo);
		boolean detail= DaoFactory.getAtmDao().acountDetail(ad);
		System.out.println(detail);
	
		response.sendRedirect("home.jsp");
	}

}
