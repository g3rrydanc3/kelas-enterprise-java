

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>String Bean JSP</title>
</head>
<body>
    <jsp:useBean id="stringBean" class="edu.stts.StringBean"/>
    Initial value (from JSP expression) :
    <br>
    <jsp:getProperty name="stringBean" property="message"/>
    <br>
    <%= stringBean.getMessage() %>
    <br>
    <jsp:setProperty name="stringBean" property="message" value="Welcome to our page"/>
    <%= stringBean.getMessage() %>
</body>
</html>
