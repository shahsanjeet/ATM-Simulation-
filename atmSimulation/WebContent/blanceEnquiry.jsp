<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="atm.com.util.SisDbUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>balance</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
body{
background-image: url("image/1.jpg");
}
#exit{
height:30px;
width:100px;
}
h1{
color:#f44336;
}
</style>
</head>
<body>
<%
String cardNo=null;
cardNo=request.getParameter("cardno");
Connection con=null;
PreparedStatement pstmt;
con=SisDbUtil.getConnection();
double amount=0;
int logNo=0;
ResultSet res=null,res1=null,res2=null;
try{	
	con=SisDbUtil.getConnection();
			String sql2="select sum(amount) from deposit where cardNo=?";
			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1,cardNo);
			res2=pstmt.executeQuery();
			res2.next();
			amount=res2.getLong(1);
			System.out.println(amount);
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//catch
}//finaly
%>

<center><h1>Currently Balance =<%=amount %></h1>
<a href="transaction.jsp?cardNo=<%=cardNo%>"><input type="button" value="EXIT" id="exit"></a></center>
</body>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
</html>