<%@page import="atm.com.Bo.MiniStatement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MiniStatement</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
</script>
<style>
body{
	background-image: url("image/6.jpg");
}
#exit{
margin-left:160px;
height:30px;
width:100px;
}
</style>
</head>
<body>
<% 
String cardNo=null;
cardNo=request.getParameter("cardno");
%>
<%
Object obj= request.getAttribute("mini");
List<MiniStatement> list = (List<MiniStatement>)obj;
//List<Employee> list = (List<Employee>)obj;
%>
how many miniStatement= <%=list.size() %>
<br>
<%
int size=list.size();
%>
<center>
<table>
<tr>
<td>Amount</td>
<td>Transaction</td>
<td>Date and time</td>
</tr>

<%for(MiniStatement min:list){ %>
<tr>
<% if(size<=5){%>
<td>
<%=min.getDamount() %>
</td>
<td>
<%=min.getTransaction() %>
</td>
<td>
<%=min.getDtime() %>

</td>
</tr>

<%}else{
	size--;
	continue;
}
%>

<br>
<%} %>
</table>
</center>
<br>
</br>
	<center><a href="transaction.jsp?cardNo=<%=cardNo%>"><input type="button" value="EXIT" id="exit"></a></center>
</body>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
</html>