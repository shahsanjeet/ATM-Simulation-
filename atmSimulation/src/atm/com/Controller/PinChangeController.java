package atm.com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.PinChange;
import atm.com.factory.DaoFactory;
import atm.com.mail.Mail2;

/**
 * Servlet implementation class PinChangeController
 */
public class PinChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PinChangeController() {
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
		System.out.println(cardNo);
		
		String currentPin=request.getParameter("currentPin");
		String newPin1=request.getParameter("NewPin1");
		String conformPin=request.getParameter("NewPin2");
		PinChange pin=new PinChange(currentPin, newPin1, conformPin,cardNo);
		boolean result=DaoFactory.getAtmDao().pinChange(pin);
		if(result){
			String gmail=DaoFactory.getAtmDao().getGmail(cardNo);
			
			String msg="YOUR NEW PIN NO. IS : "+newPin1;
			System.out.println(msg);
			//Mail2 mail=new Mail2();
			try {
				 boolean res=Mail2.sendotp(gmail,msg);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result){
			response.sendRedirect("home.jsp");
		}else{
			response.sendRedirect("pinchange.jsp?cardno="+cardNo+"");
		}
	}

}
