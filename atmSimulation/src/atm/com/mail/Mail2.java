package atm.com.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail2 {

	public Mail2() {
		// TODO Auto-generated constructor stub
	}
	/*public boolean sendMail(String mail,String msg)throws Exception{
		System.out.println("____________________________");
		 System.out.println(mail);
		System.out.println(msg);
		 System.out.print("MAIL");
		
		 final String from="pk145119@gmail.com";
		final String password="rajaditya";
		//final String from="babluagrahari007@gmail.com";
		//final String password="9565072546";
		String to=mail;
		 System.out.println("Reading password..");
		 java.util.Properties prop=new java.util.Properties();
		 prop.put("mail.smtp.auth","true");
		 prop.put("mail.smtp.starttls.enable","true");
		 prop.put("mail.smtp.host","smtp.gmail.com");
		 prop.put("mail.smtp.port","587");
		 System.out.println("Message sending..");
		 
		 
		 
		 Session eSession=Session.getInstance(prop,  new javax.mail.Authenticator() 
		 {
				protected PasswordAuthentication
				getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			  });
 
		 

				Message message = new MimeMessage(eSession);
				message.setFrom(new InternetAddress(from));
				
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
				message.setSubject("Your OTP is:"+msg);
				message.setText("Welcome"+new Date());

				Transport.send(message);
                 
				System.out.println("message sent ");
				  return true;
			
	 
		public static boolean sendotp (String email,String otp) throws Exception{
					

	 }//method*/
public static boolean sendotp (String email,String MSG) throws Exception{
		
		System.out.println(email);
//		System.out.println(otp);
		final String from = "145119pk@gmail.com";
		final String password = "9572588124";
		final String to =email;
		System.out.println("Reading Password...");
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		System.out.println("Sending Message...");
		
		Session emailsession = Session.getInstance(props,new javax.mail.Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,password);
			}
				});
		Message msg = new MimeMessage(emailsession);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		msg.setSubject("WELCOME IN ONLINE ATM SERVICES");
//		msg.setText("YOUR ATM CARD NUMBER :"+cardNo+ " AND YOUR  OTP : "+otp+" Time: "+new Date());
		msg.setText(""+MSG);
		Transport.send(msg);
		return true;
	}					
}
 


