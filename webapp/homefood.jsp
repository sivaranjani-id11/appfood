<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello <%out.println(request.getAttribute("name")); %></h1>

<table border="1px solid black">

<tr><td>Email </td><td><%out.println(request.getAttribute("email")); %></td></tr>
<tr><td>Mobile </td><td><%out.println(request.getAttribute("mobile")); %></td></tr>
<tr><td>Address </td><td><%out.println(request.getAttribute("address")); %></td></tr>
<tr><td>city </td><td><%out.println(request.getAttribute("city")); %></td></tr>


</table>
</body>
</html>