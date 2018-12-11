<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Good user</title>
</head>
<body>

<h3>If you can see that page, you input correct login and password.</h3>

<%
    String username = (String) request.getAttribute("useremail");
    String userpassword = (String) request.getAttribute("userpassword");
    Date currentData =  (Date)request.getAttribute("currentData");
    out.println("<p>" + username + "</p>");
    out.println("<p>" + userpassword + "</p>");
    out.println("<p>" + currentData + "</p>");

%>
</body>
</html>