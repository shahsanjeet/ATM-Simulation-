package atm.com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.Signup;
import atm.com.factory.DaoFactory;

/**
 * Servlet implementation class SignupController
 */
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hamm");
		String cardNo=request.getParameter("CardNo");
		String pin=request.getParameter("pin");
		System.out.println(pin);
		Signup sign=new Signup(cardNo,pin);
		boolean res=DaoFactory.getAtmDao().signup(sign);
		if(res){
			response.sendRedirect("transaction.jsp?cardNo="+cardNo+"");
			
		}
		else
			response.sendRedirect("forgetpassword.jsp");
	}

}
