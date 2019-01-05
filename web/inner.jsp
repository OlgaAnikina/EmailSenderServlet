<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="login.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Good user</title>
</head>
<body>
<form action="regist" method="POST">
<h3>If you can see that page, you input correct login and password.</h3>


<%
    String login = (String) request.getAttribute("login");
    String password = (String) request.getAttribute("password");
    Date currentData =  (Date)request.getAttribute("currentData");
    out.println("<p> Your login " + login + "</p>");
    out.println("<p> Your password " + password + "</p>");
    out.println("<p>" + currentData + "</p>");

%>

<input type="submit" value="Log out" />
</form>
</body>
</html>