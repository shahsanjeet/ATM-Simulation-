package atm.com.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.PersonalDetail;
import atm.com.factory.DaoFactory;

/**
 * Servlet implementation class PersonalDetailController
 */
public class PersonalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		 String name=request.getParameter("name");
		 String fname=request.getParameter("fname");
		 String dobstr=request.getParameter("dob");
		 System.out.println(dobstr);
		 Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(dob);
		 String gender=request.getParameter("gender");
		 String email=request.getParameter("email");
		 String maritalStatus=request.getParameter("marital");
		 String address=request.getParameter("address");
		 String city=request.getParameter("city");
		 String pincode=request.getParameter("pincode");
		 String state=request.getParameter("state");
			System.out.println(dob); 
		 PersonalDetail pd=new PersonalDetail(name,fname,dob,gender,email,maritalStatus,address,city,pincode,state);
		 boolean add=DaoFactory.getAtmDao().addRecord(pd);
		 System.out.println(add);
		 if(add){
			 response.sendRedirect("additionalDetail.jsp"); 
		 }
		 else{
			 response.sendRedirect("forgetpassword.jsp");
		 }
	}

}
