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
<title>Account Details
</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
body{
padding:0px;
margin:0px;
}

table{
	padding:0px;
	margin:0px;
	width:500px;
	height:650px;
	line-height:35px;
	margin-left:190px;
	color:blue;
}

#head{

	background-color:#6acaff;
	height:70px;
	font-size:22px;
}
#account{
	height:30px;
	font-size:20px;
}
h5{
	height:10px;
	font-size:20px;
}
#submit{
margin-left:100px;
height:25px;
width:80px;
}
#cancel{
margin:0px;
padding:0;
height:25px;
width:80px;
}
body{
background-image: url("image/3.jpg");
}
src{
color:black;
}
</style>
<head>
<% 
String cardNo=null;
cardNo=request.getParameter("cardno");
%>
<body>
<form action="AccountDetailController?cardno=<%=cardNo %>" method="post">
<table >
	<tr>
		<td colspan="2" id="head"><center><src>Page: 3 Account Details</src></center></td>
	</tr>
	<tr>
		<td colspan="2" id="account"><h5><src>Account Type :</src></h5></td>
	</tr>
	<tr>
		<td>
		<input type="radio" name="acc_type" value="Saving Account"><font face="calibri" size="4"> Saving Account</font></td>
		<td><input type="radio" name="acc_type" value="Fixed Deposite Account"><font face="calibri" size="4">Fixed Deposite Account</font></td>
	</tr>
	<tr>
		<td><input type="radio" name="acc_type" value="Current Account"><font face="calibri" size="4">Current Account</font></td>
		<td>
		<input type="radio" name="acc_type" value="Recurring Deposite Account"><font face="calibri" size="4">Recurring Deposite Account</font>
		</td>
	</tr>
	<tr>
		<td><font face="calibri" size="4">Card Number :</font></td>
	
		<td><font face="calibri" size="5"><src>xxxx-<%=cardNo %></src></font></td>
	</tr>
	<tr>
		<td><font face="calibri" size="4">PIN :</font></td>
		<td><font face="calibri" size="5"><src>xxxx</src></font></td>
	</tr>
	<tr>
		<td colspan="2"><h5><src>Services Required :</src></h5></td>
	</tr>
	<tr>
		<td><input type="checkbox" name="atm" value="YES"><font face="calibri" size="4">ATM CARD</font></td>
		<td><input type="checkbox" name="internet" value="YES"><font face="calibri" size="4">INTERNET BANKING</font></td>
	</tr>
	<tr>
		<td><input type="checkbox" name="mob" value="YES"><font face="calibri" size="4">MOBILE BANKING</font></td>
		<td><input type="checkbox" name="email" value="YES"><font face="calibri" size="4">EMAIL ALERTS</font></td>
		
	</tr>
	<tr>
		<td><input type="checkbox" name="cheque" value="YES">
		<font face="calibri" size="4">CHEQUE  BOOK</font></td>
		<td><input type="checkbox" name="estatement" value="YES"><font face="calibri" size="4">E-STATEMENT</font></td>
		
	</tr>
	<tr>
		<td colspan="2" ><input type="checkbox" name="confirm" value="yes"><font face="calibri" size="4">I hereby declare that the
		above entered <br />
		 &nbsp details are correct to the best of my knowledge.</font></td>
	</tr>
	<tr>
		<td><input type="submit" value="SUBMIT" id="submit"></td>
		<td><input type="reset" value="CANCEL" id="cancel"></td>
	</tr>
</table>
</form>
</body>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
</html>