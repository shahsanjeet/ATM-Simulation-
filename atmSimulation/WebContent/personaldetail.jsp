<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>personalDetail</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
table{
padding:0px;
margin:0px;
height:600px;
width:500px;
margin-left:150px;
}
#head1{
background-color:#6acaff;
}
h5{
padding:0;
font-size:20px;
font-family:verdana;
font-weight:normal;
margin-left:55px;
margin-top:10px;
height:0px;
}
#h5{
padding:0;
font-size:16px;
font-family:verdana;
font-weight:normal;
margin-left:40px;
height:0px;
color: blue;
}
#input1{
margin-left:20px;
height:30px;
width:200px;
}
#radio1{
	margin-left:30px;
}
#next{
width:80px;
height:30px;
margin-left:355px;
}
body{
	background-image:url("image/3.jpg");
	
}
</style>

<script> 
function GEEKFORGEEKS()                                    
{ 
    var name = document.forms["RegForm"]["name"]; 
    var fname = document.forms["RegForm"]["fname"];
    var dob = document.forms["RegForm"]["dob"];
    var email = document.forms["RegForm"]["email"];
    var address = document.forms["RegForm"]["address"];   
    var city = document.forms["RegForm"]["city"];  
    var pincode =  document.forms["RegForm"]["pincode"];  
    var state = document.forms["RegForm"]["state"];  
   
    if (name.value == "")                                  
    { 
        window.alert("Please enter your name."); 
        name.focus(); 
        return false; 
    } 

    if (fname.value == "")                                  
    { 
        window.alert("Please enter your father name."); 
        fname.focus();
        return false; 
    } 
    
    if (dob.value.indexOf("/", 0) < 0)                                  
    { 
        window.alert("Please enter dd/mm/yyyy format DOB."); 
        dob.focus();
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
    if (address.value == "")                                  
    { 
        window.alert("Please enter your Address."); 
        address.focus();
        return false; 
    }
    if (city.value == "")                                  
    { 
        window.alert("Please enter your city."); 
        city.focus();
        return false; 
    }
    if (pincode.value == "")                           
    { 
        window.alert("Please enter your pincode."); 
        pincode.focus(); 
        return false; 
    }
    if (state.value == "")                                  
    { 
        window.alert("Please enter your State."); 
        state.focus();
        return false; 
    }
    return true;
}
</script>
</head>
<body>
<form name="RegForm" action="PersonalDetailController" onsubmit="return GEEKFORGEEKS()" method="post">
	<table>
		<tr>
			<td colspan="2" id="head1">
				<h5><center>Application Form</center></h5>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="head1">
				<h5><center>Page1: Personal Details</center></h5>
			</td>
		</tr>
		<tr>
			<td>
			<h5 id="h5">Name :</h5>
				</td>
			<td>
				<input type="text" name="name" placeholder="Enter your name" id="input1">
			</td>
		</tr>
		<tr>
			<td>
			<h5 id="h5">Father's Name :</h5>
			</td>
			<td>
				<input type="text" name="fname" placeholder="Enter fater's name" id="input1">
			</td>
		</tr>
		<tr>
			<td><h5 id="h5">Date of Birth :</h5></td>
			<td>
			<input type="text" name="dob" id="input1" placeholder="dd/mm/yyy">
			</td>
		</tr>
		<tr>
			<td><h5 id="h5">Gender :</h5></td>
			<td>
			<input type="radio" name="gender" value="male" id="radio1">Male
			<input type="radio" name="gender" value="female" id="radio1">Female
			</td>
		</tr><tr>
			<td><h5 id="h5">Email :</h5></td>
			<td>
			<input type="email" name="email" placeholder="email@gmail.com" id="input1">
			</td>
		</tr>
		<tr>
			<td><h5 id="h5">Marital status :</h5></td>
			<td>
			<input type="radio" name="marital" value="married" id="radio1">Married
			<input type="radio" name="marital" value="unmarried" id="radio1">Unmarried
			</td>
		</tr>
		<tr>
			<td>
					<h5 id="h5">Address :</h5>
			</td>
			<td>
			<input type="text" name="address" placeholder="Enter address" id="input1">
			</td>
		</tr>
		<tr>
			<td><h5 id="h5">City :</h5></td>
			<td><input type="text" name="city" placeholder="enter city" id="input1"></td>
		</tr>
		<tr>
			<td><h5 id="h5">Pincode :</h5></td>
			<td><input type="text" name="pincode" placeholder="pincode" id="input1"></td>
		</tr>
		<tr>
			<td><h5 id="h5">State :</h5></td>
			<td><input type="text" name="state" placeholder="state" id="input1"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" name="next" value="Next" id="next" id="input1">
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