<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login
</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
table{
	width:500px;
	height:350px;
	line-height:35px;
	margin-left:auto;
}
#head1{

	background-color:#6ad7ff;
	height:70px;
}
a{
text-deco ration:none;
color:black;
}
#card1{
font-size:20px;
font-family:verdana;
font-weight:normal;
margin-left:30px;
margin-top:20px;
}
#card{
margin-left:20px;
height:30px;
width:170px;
}
#pin{
margin-left:20px;
height:30px;
width:170px;
}
#submit{
margin-left:70px;
height:30px;
width:100px;
}
#clear{
margin-left:50px;
height:30px;
width:100px;
}
#sign{
margin-left:160px;
height:30px;
width:100px;
}
body{
background-image:url("image/d.jpg");
background-repeat:repet,no-repeat;
}
</style>
</head>
<body>
<%response.setHeader("Cache-control","no-cache,no-store,must-revalidate"); 
response.setHeader("Pragna","no-case");
response.setHeader("Expire","0");
%>
<form action="SignupController" method="post">
<table width="350">
	<tr>
	<td colspan="2"  id="head1"><center> <font face="calibri" size="5">WELCOME TO ATM</font></center></td>
	
	</tr>
	<tr>
	<td id="card1"><h5 id="card1">Card Number :</h5></td>
	<td><input type="text" name="CardNo" placeholder=" card  number"  id="card" maxlength="10"></td>
	</tr>
	<tr>
	<td><h5 id="card1">Pin Number:</h5></td>
	<td><input type="password" name="pin" id="pin" placeholder=" pin number" maxlength="4"></td>
	</tr>
	<tr>
	<td><input type="submit" value="Sign" id="submit"></td>
	<td><input type="reset" value="Clear" id="clear"></td>
	</tr>
	<tr>
	<td colspan="2"><a href="personaldetail.jsp"><input type="button" value="SIGN UP" id="sign" ></a>
	</td>
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