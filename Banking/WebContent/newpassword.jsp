<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="ForgotPassword">


<table>
<tbody>
<tr><td>New Password :</td><td> <input type="text" name="npwd"> </td></tr>

</tbody>
 </table>
<input type=Submit value="Submit"> 
<%

session = request.getSession();
session.getAttribute("email");

%>

</form>

</body>
</html>