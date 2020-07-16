package atm.com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.com.Bo.MiniStatement;
import atm.com.factory.DaoFactory;

/**
 * Servlet implementation class MinistatementController
 */
public class MinistatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinistatementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String cardNo=request.getParameter("cardno");
		//System.out.println("mini...........");
		//System.out.println(cardNo);
		
		ArrayList<MiniStatement> list=DaoFactory.getAtmDao().ministatement(cardNo);
		
		request.setAttribute("mini", list);


		RequestDispatcher rd = request.getRequestDispatcher("mini_view.jsp");
		rd.forward(request, response);
	
	
	}

}
