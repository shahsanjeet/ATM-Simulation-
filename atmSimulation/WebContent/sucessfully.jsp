<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully</title>
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
<% 
String cardNo=null;
cardNo=request.getParameter("cardno");
%>
<body>
<center><h1><b>transaction completed Successfully </b></h1>
<br>
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