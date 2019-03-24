<%@page import="model.Model"%>
<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>balance page</title>
</head>
<body>
<%

session = request.getSession();

out.println("the balance is "+session.getAttribute("balance"));
%>

</body>
</html>