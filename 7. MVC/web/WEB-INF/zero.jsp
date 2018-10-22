<%--
  Created by IntelliJ IDEA.
  User: ger_2
  Date: 22-Oct-18
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zero Customer</title>
</head>
<body>
    <jsp:useBean id="zeroCustomer" type="edu.stts.mvc7.BankCustomer" scope="request"/>
    <jsp:getProperty name="zeroCustomer" property="firstName"/>
    <jsp:getProperty name="zeroCustomer" property="lastName"/>
    <jsp:getProperty name="zeroCustomer" property="id"/>
    <jsp:getProperty name="zeroCustomer" property="balance"/>
</body>
</html>
