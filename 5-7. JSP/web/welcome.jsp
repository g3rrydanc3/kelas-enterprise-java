<%--
  Created by IntelliJ IDEA.
  User: ger_2
  Date: 01-Oct-18
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    String bgColor = request.getParameter("bgColor");
    if (bgColor == null || bgColor.trim().equals("")){
        bgColor="WHITE";
    }

%>
<body bgcolor="<%= bgColor%>">
<h1>Have a nice day!</h1>
</body>
</html>
