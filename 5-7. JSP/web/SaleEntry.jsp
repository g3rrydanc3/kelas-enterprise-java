<%--
  Created by IntelliJ IDEA.
  User: ger_2
  Date: 01-Oct-18
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sale Entry</title>
</head>
<body>
    <jsp:useBean id="entry" class="edu.stts.SaleEntry"/>
    <jsp:setProperty name="entry" property="*"/>
    <ol>
        <li><jsp:getProperty name="entry" property="itemId"/></li>
        <li><jsp:getProperty name="entry" property="itemCost"/></li>
        <li><jsp:getProperty name="entry" property="numItems"/></li>
        <li><jsp:getProperty name="entry" property="totalCost"/></li>s
    </ol>
</body>
</html>
