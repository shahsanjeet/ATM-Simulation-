<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>deposit
</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
table{
	width:500px;
	height:350px;
	line-height:35px;
}
#head1{

	background-color:#ff6aee;
	height:70px;
}
a{
text-decoration:none;
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
#exit{
margin-left:160px;
height:30px;
width:100px;
}
body{
background-image: url("image/6.jpg");
}
</style>
<script> 
function validation()                                    
{ 
    var amount = document.forms["RegForm"]["amount"];  
   
    if (amount.value == "")                                  
    { 
        window.alert("Please enter amount"); 
        amount.focus();
        return false; 
    }
    return true;
}
</script>
</head>
<% 
String cardNo=null;
cardNo=request.getParameter("cardno");
%>
<body>
<center>
<form name="RegForm" action="DepositController?cardno=<%=cardNo%>" onsubmit="return validation()" method="post">
<table width="350">
	<tr>
	<td colspan="2"  id="head1"><center> <font face="calibri" size="5">ENTER AMOUNT YOU WANT</font></center></td>
	
	</tr>
	<tr>
	<td id="card1"><h5 id="card1">TO DEPOSIT :</h5></td>
	<td><input type="text" name="amount" placeholder=" enter amount"  id="card"></td>
	</tr>
	
	<tr>
	<td><input type="submit" value="DEPOSIT" id="submit"></td>
	<td><input type="reset" value="CANCEL" id="clear"></td>
	</tr>
	<tr>
	<td colspan="2">
		<a href="transaction.jsp?cardNo=<%=cardNo%>"><input type="button" value="EXIT" id="exit"></a>
	</td>
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