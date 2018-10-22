

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>String Bean JSP</title>
</head>
<body>
    <jsp:useBean id="stringBean" class="edu.stts.StringBean" scope="application">
        <jsp:setProperty name="stringBean" property="message" value="Welcome to our page"/>
        <% stringBean.setMessage("Welcome to our pages.");%>
        <jsp:getProperty name="stringBean" property="message"/>
        <%= stringBean.getMessage()%>
    </jsp:useBean>

    Initial value (from JSP expression) :
    <br>
    <jsp:getProperty name="stringBean" property="message"/>
    <br>
    <%= stringBean.getMessage() %>
    <br>
    <%= stringBean.getMessage() %>
    <!--jsp:forward page="index.jsp"/-->
</body>
</html>
