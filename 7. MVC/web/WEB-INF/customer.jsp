<%--
  Created by IntelliJ IDEA.
  User: ger_2
  Date: 22-Oct-18
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
    <jsp:useBean id="bankCustomer" type="edu.stts.mvc7.BankCustomer" scope="request"/>
    <jsp:getProperty name="bankCustomer" property="firstName"/>
    <jsp:getProperty name="bankCustomer" property="lastName"/>
    <jsp:getProperty name="bankCustomer" property="id"/>
    <jsp:getProperty name="bankCustomer" property="balance"/>
</body>
</html>
