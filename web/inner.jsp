<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Good user</title>
</head>
<body>

<%
    String username = (String) request.getAttribute("useremail");
    String userpassword = (String) request.getAttribute("userpassword");
    // String currentDate = (String)request.getAttribute("data");

    out.println("<p>" + username + "</p>");
    out.println("<p>" + userpassword + "</p>");
    // out.println("<p>" + currentDate + "</p>");

%>

</body>
</html>