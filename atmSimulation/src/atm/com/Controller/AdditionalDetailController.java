package atm.com.Controller;


import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import atm.com.Bo.AdditionalDetail;
import atm.com.factory.DaoFactory;
import atm.com.mail.Mail2;

/**
 * Servlet implementation class AdditionalDetailController
 */
public class AdditionalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionalDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String	religion =request.getParameter("religion");
		String category=request.getParameter("category");
		String income=request.getParameter("income");
		String education=request.getParameter("education");
		String occupation=request.getParameter("occupation");
		String panno=request.getParameter("panno");
		String adhar=request.getParameter("adhar");
		String citizen=request.getParameter("senoircitizen");
		String acc=request.getParameter("ExistingAcc");
	
		Random rand =new Random();
		char []card= new char[10];
		card[0]=(char) (rand.nextInt(9)+'1');
		for(int i=1;i<card.length;i++){
			card[i]=(char)(rand.nextInt(10)+'0');
		}
		String cardNo=new String(card);
		char []pin =new char[4];
		pin[0]=(char) (rand.nextInt(9)+'1');
		for(int i=1;i<pin.length;i++){
			pin[i]=(char)(rand.nextInt(9)+'0');
		}
		String pinNo=new String(pin);
		boolean res=false;
		AdditionalDetail ad=new AdditionalDetail(religion,category,income,education,occupation,panno,adhar,citizen,acc,cardNo,pinNo);
		
		boolean con=DaoFactory.getAtmDao().addRecord1(ad);
		
		String gmail =DaoFactory.getAtmDao().getGmail(cardNo);
		System.out.println(gmail);
		System.out.println(con);
		if(con){
			String msg="YOUR CARD NO.= "+cardNo+" AND PIN NO. ="+pinNo;
			System.out.println(msg);
			
			//Mail2 mail=new Mail2();
			try {
				 res=Mail2.sendotp(gmail,msg);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.setHeader("refresh","5 url=accountDetail.jsp?cardno="+cardNo+"");
			response.sendRedirect("accountDetail.jsp?cardno="+cardNo+"");
		}
	}

}
