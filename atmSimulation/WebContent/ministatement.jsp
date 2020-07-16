<%@page import="atm.com.Bo.MiniStatement"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="atm.com.util.SisDbUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MiniStatement</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
</style>
</head>
<% 
String cardNo=null;
cardNo=request.getParameter("cardno");
%>
<body>
<%

int rs1=0;
Connection con=null;
PreparedStatement pstmt;
ResultSet res=null,res1=null,res2=null,res3=null;
int logNo=0;
double amount=0;
ArrayList<MiniStatement> list=new ArrayList<MiniStatement>();
try{	
	con=SisDbUtil.getConnection();
			String sql2="select amount,transaction,deposit_time from deposit_log where cardNo=?";
			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1,cardNo);
			res2=pstmt.executeQuery();
			while(res2.next()){
				amount=res2.getLong(1);
				String transaction=res2.getString(2);
				String depodit_time=res2.getTimestamp(3)+"";
				MiniStatement min=new MiniStatement();
				min.setDamount(amount);
				min.setDtime(depodit_time);
				min.setTransaction(transaction);
				list.add(min);
			}
}catch(SQLException e){
	e.printStackTrace();
}finally{
	try {
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//catch
}//finaly
request.setAttribute("mini", list);


RequestDispatcher rd = request.getRequestDispatcher("mini_view.jsp");
rd.forward(request, response);

%>
</body>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
</html>