<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Additional detail</title>
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
	height:400px;
	line-height:35px;
	margin-left:150px;
}

#head1{

	background-color:#6acaff;
	height:70px;
}

#rel{
height:30px;
width:100px;
font-size:15px;
margin-left:20px;
}
#category{
height:30px;
width:100px;
font-size:15px;
margin-left:20px;
}
#income{
height:30px;
width:150px;
font-size:15px;
margin-left:20px;
}
#education{
height:30px;
width:125px;
font-size:15px;
margin-left:20px;
}
#occupation{
height:30px;
width:125px;
font-size:15px;
margin-left:20px;
}
#pan{
height:30px;
width:150px;
font-size:15px;
margin-left:20px;
}
#adhar{
height:30px;
width:150px;
font-size:15px;
margin-left:20px;
}
#citizen{
font-size:15px;
margin-left:20px;
}
#account{
font-size:15px;
margin-left:20px;
}
#next{
font-size:15px;
height:30px;
width:90px;
float:right;
margin-right:64px;
}
a{
text-decoration:none;
color:black;
}
#h5{
font-size:14px;
font-family:verdana;
font-weight:normal;
margin-left:55px;
height:29px;
color:blue;
}
body{
	background-image:url("image/3.jpg");
	
}
</style>


<script> 
function GEEKFORGEEKS()                                    
{ 
    var panno = document.forms["RegForm"]["panno"];  
    var adhar = document.forms["RegForm"]["adhar"];
    
    
    if (panno.value == "")                                  
    { 
        window.alert("Please enter your pancard No."); 
        panno.focus();
        return false; 
    }
    if (adhar.value == "")                                  
    { 
        window.alert("Please enter your adhar No."); 
        adhar.focus();
        return false; 
    }
    
  
    return true;
}
</script>
</head>
<body>
<form name="RegForm" action="AdditionalDetailController" onsubmit="return GEEKFORGEEKS()" method="post">
	<table  width="350px">
			<tr>
				<td colspan="2" id="head1">
				<font face="calibri" size="5"><center>Page2: Additional Detail<center></font> 
				</td>
				
			</tr>
			<tr>
				<td>
				<h5 id="h5">Religion :</h5>
				</td>
				<td>
				<select name="religion" id="rel">
				<option value="Hindu" >Hindu</option>
				<option value="Muslim" >Muslim</option>
				<option value="Sikhs" >Sikhs</option>
				<option value="Jain" >Jain</option>
				<option value="christian" >Christian</option>
				<option value="Other" >Other</option>

				</select>
				</td>
			</tr>
			<tr>
				<td><h5 id="h5">Category :</h5></td>
				<td>
				<select name="category" id="category">
				<option value="Genral" >Genral</option>
				<option value="Obc" >Obc</option>
				<option value="Sc" >Sc</option>
				<option value="St">St</option>
				<option value="Other" >Other</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><h5 id="h5">Income :</h5>
				</td>
				<td>
				<select name="income" id="income">
				<option value="1,50,000">less than 1,50,000</option>
				<option value="2,50,000">less than 2,50,000</option>
				<option value="5,00,000">less than 5,00,000</option>
				<option value="5,00,000">less than 10,00,000</option>
				<option value="10,00,000">up to 10,00,000</option>
				</select>
				</td>
			</tr>
			<tr>
				<td> <h5 id="h5">Education  :</h5></td>
				<td>
				<select name="education" id="education">
				<option value="Non-Graduate">Non-Graduate</option>
				<option value="Graduate">Graduate</option>
				<option value="Post-Graduate">Post-Graduate</option>
				<option value="Doctor">Doctor</option>
				<option value="Other">Other</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><h5 id="h5">Occupation :</h5></td>
				<td>
				<select name="occupation" id="occupation">
				<option value="Salaried">Salaried</option>
				<option value="Self-Employed">Self-Employed</option>
				<option value="Business">Business</option>
				<option value="Retired">Retired</option>								
				<option value="Other">Other</option>
				</select>
				</td>
			</tr>
				<tr>
				<td><h5 id="h5">Pan Number :</h5></td>
				<td>
				<input type="text" name="panno" placeholder="  pan number" id="pan">
				</td>
			</tr>
				<tr>
				<td><h5 id="h5">Adhar Number :</h5></td>
				<td>
				<input type="text" name="adhar" placeholder="  adhar number" id="adhar">
				</td>
			</tr>
				<tr>
				<td><h5 id="h5">Senior Citizen :</h5></td>
				<td><input type="radio" name="senoircitizen" value="Yes" id="citizen">Yes
				<input type="radio" name="senoircitizen" value="No">No
				</td>
			</tr>
				<tr>
				<td><h5 id="h5">Existing Account:</h5></td>
				<td><input type="radio" name="ExistingAcc" value="Yes" id="account">Yes
				<input type="radio" name="ExistingAcc" value="No">No</td>
			</tr>
				<tr>
		
				<td colspan="2"><input type="submit" value="Next" id="next"></td>
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