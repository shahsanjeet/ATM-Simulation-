<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pinchange</title>
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

	background-color:#f37fe0;
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
	background-image: url("image/f.jpg");
	

}
</style>
<script> 
function validation()                                    
{ 
    var cardNo = document.forms["RegForm"]["cardNo"];  
    var email = document.forms["RegForm"]["email"];
    
    if (cardNo.value == "")                                  
    { 
        window.alert("Please enter your cardNo."); 
        cardNo.focus();
        return false; 
    }
    if (email.value == "")                                   
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf("@", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf(".", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    }  
    
    return true;
}
</script>
</head>
<body>
<form name="RegForm" action="ForgetPasswordController" onsubmit="return validation()" method="post">
<table width="350">
	<tr>
	<td colspan="2"  id="head1"> <center> <font face="calibri" size="5">FORGET YOUR PASSWORD</font></center></td>
	
	</tr>
	<tr>
	<td id="card1"><h5 id="card1">ENTER CARD NO :</h5></td>
		<td><input type="text" name="cardNo" placeholder="enter your cardNo"  id="card"></td>
	</tr>
	<tr>
	<td id="card1"><h5 id="card1">ENTER YOUR EMAIL :</h5></td>
		<td><input type="email" name="email" placeholder="enter email address"  id="card"></td>
	</tr>
	<tr>
		<td><input type="submit" value="SUBMIT" id="submit"></td>
		<td><input type="reset" value="CANCEL" id="clear"></td>
	</tr>
	<tr>
		<td colspan="2"><a href="home.jsp"><input type="button" value="BACK" id="sign"></a></button>
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