<%@page import="atm.com.Bo.Signup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>transaction</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
table{
	width:550px;
	height:450px;
	line-height:35px;
}
#head1{

	background-color:#ff6aee;
	height:70px;
}
#deposit{
margin-left:60px;
height:30px;
width:100px;
}
#cash{
margin-left:70px;
height:30px;
width:150px;
}
#fast{
margin-left:60px;
height:30px;
width:100px;
}
#mini{
margin-left:70px;
height:30px;
width:150px;
}
#pin{
margin-left:60px;
height:30px;
width:100px;
}
#blance{
margin-left:70px;
height:30px;
width:150px;
}
#exit{
margin-left:170px;
height:30px;
width:120px;
}
a{
text-decoration: none;
}
body{
background-image: url("image/x.jpg");
}
</style>
</head>
<% 
String cardNo=null;
cardNo=request.getParameter("cardNo");
%>
<body>
<center>
<form>
<table width="350">
	<tr>
		<td colspan="2" id="head1"><font face="calibri" size="5"> <center> Please Select Your Transaction</center></font></td>
	</tr>
	<tr></tr>
	<tr>
		<td id="b1">
			<a href="deposit.jsp?cardno=<%=cardNo%>"><input type="button" value="DEPOSIT" id="deposit"></a>
		</td>
		<td>
			<a href="withdrol.jsp?cardno=<%=cardNo%>"><input type="button" value="CASH WIDRAWAL" id="cash"></a>
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td>
			<a href="#"><input type="button" value="FAST CASH" id="fast"></a>
		</td>
		<td>
			<a href="MinistatementController?cardno=<%=cardNo%>"><input type="button" value="MINI STATEMENT" id="mini"></a>
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td>
			<a href="pinchange.jsp?cardno=<%=cardNo%>"><input type="button" value="PIN CHANGE" id="pin"></a>
		</td>
		<td>
			<a href="blanceEnquiry.jsp?cardno=<%=cardNo%>"><input type="button" id="blance" value="BLANCE ENQUIRY" ></a>
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td colspan="2"><a href="home.jsp"><input type="button" value="EXIT" id="exit"></a></td>
	</tr>
</table>
</form>
</center>

</body>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
</html>