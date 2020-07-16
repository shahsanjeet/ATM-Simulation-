package atm.com.Controller;

import java.io.IOException;




import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;



import atm.com.Bo.ForgetPassword;
import atm.com.factory.DaoFactory;
import atm.com.mail.Mail2;

/**
 * Servlet implementation class ForgetPasswordController
 */
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardNo=request.getParameter("cardNo");
		String email=request.getParameter("email");
		
		Random rand= new Random();
		char []pin =new char[4];
		pin[0]=(char) (rand.nextInt(9)+'1');
		for(int i=1;i<pin.length;i++){
			pin[i]=(char)(rand.nextInt(9)+'0');
		}
		String pinNo=new String(pin);
		
		ForgetPassword pass=new ForgetPassword(cardNo,email,pinNo);
		boolean result=DaoFactory.getAtmDao().forgetPassword(pass);
		
		//String gmail=DaoFactory.getAtmDao().getGmail(cardNo);
		
		String msg="YOUR NEW PIN NO. IS ="+pinNo;
		System.out.println(msg);
		//Mail2 mail=new Mail2();
		try {
			 boolean res=Mail2.sendotp(email,msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result){
			response.sendRedirect("home.jsp");
		}else{
		//	JOptionPane.showMessageDialog(null,"hello raj");
		//	response.setHeader("refresh", "5 url=errorForgetPassword.jsp");
			response.sendRedirect("errorForgetPassword.jsp");
		}
	}

}
