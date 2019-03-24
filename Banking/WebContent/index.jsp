<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
Enter the Login Details
<form  action="/Banking/Home">
<br/>
<br/>

<table>
<tbody>
<tr><td>Customer id:</td><td> <input type="text" name="cid"> </td></tr>
<tr><td>Password:</td><td> <input type="password" name="pwd"> </td></tr>

</tbody>
 </table><br>

<input type=Submit value="Login"> <a href="/Banking/forgotpassword.jsp">Forgot Password ?</a>

	</form>
</body>
</html>