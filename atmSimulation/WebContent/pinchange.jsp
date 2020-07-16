<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PinChange</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
table{
	width:500px;
	hei
	ght:350px;
	line-height:35px;
	margin-right: auto;
}
#head1{

	background-color:#ff6aee;
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
margin-left:50px;
height:30px;
width:100px;
}
#clear{
margin-left:30px;
height:30px;
width:100px;
}
#sign{
margin-left:160px;
height:30px;
width:100px;
}
body{
background-image: url("image/f.jpg");
}
</style>
<script> 
function validation()                                    
{ 
    var currentPin = document.forms["RegForm"]["currentPin"];
    var NewPin1 = document.forms["RegForm"]["NewPin1"]; 
    var NewPin2 = document.forms["RegForm"]["NewPin2"]; 
   
    if (currentPin.value == "")                                  
    { 
        window.alert("Please enter current pin"); 
        currentPin.focus();
        return false; 
    }
    if (NewPin1.value == "")                                  
    { 
        window.alert("Please enter new pin"); 
        NewPin1.focus();
        return false; 
    }
    if (NewPin2.value == "")                                  
    { 
        window.alert("Please enter new pin"); 
        NewPin2.focus();
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

<form name="RegForm" action="PinChangeController?cardno=<%=cardNo%>" onsubmit="return validation()" method="post">
<table width="350">
	<tr>
	<td colspan="2"  id="head1"> <center><font face="calibri" size="5"> CHANGE YOUR PIN</font></center></td>
	
	</tr>
	<tr>
	<td id="card1"><h5 id="card1">CURRENT PIN :</h5></td>
	<td><input type="password" name="currentPin" placeholder=" enter current pin"  id="card"></td>
	</tr>
	<tr>
	<td><h5 id="card1">NEW PIN :</h5></td>
	<td><input type="password" name="NewPin1" id="pin" placeholder="enter new pin"></td>
	</tr>
	<tr>
	<td><h5 id="card1">RE-ENTER PIN :</h5></td>
	<td><input type="password" name="NewPin2" id="pin" placeholder=" re-enter pin"></td>
	</tr>

	<tr>
	<td><input type="submit" value="SAVE" id="submit"></td>
	<td><input type="reset" value="CANCEL" id="clear"></td>
	</tr>
	<tr>
		<td colspan="2"><a href="transaction.jsp?cardNo=<%=cardNo%>"><input type="button" value="BACK" id="sign" ></a>
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