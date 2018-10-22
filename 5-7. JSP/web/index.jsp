<%--
  Created by IntelliJ IDEA.
  User: ger_2
  Date: 24-Sep-18
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.Date" %>
<%@ page errorPage="error.jsp" %>
<%//@ page session="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <%
    String bgColor = request.getParameter("bgColor");
    if (bgColor == null || bgColor.trim().equals("")){
        bgColor="WHITE";
    }

  %>

  <body bgcolor="<%= bgColor%>">
    <%!
      private int accessCount = 0;
      private String randomHeading(){
        return ("<h2>" + Math.random() + "</h2>");
      }
    %>
    <%
      double speed = Double.parseDouble(request.getParameter("distance"))/Double.parseDouble(request.getParameter("time"));
      response.getWriter().println(speed);
      int localCount;
      synchronized (this){
        accessCount++;
        localCount = accessCount;
      }
    %>
    <h2>Page has been accessed <%= localCount%> times</h2>
    <%= randomHeading()%>
    <ul>
      <li><%= new java.util.Date() %></li>
      <li><%= application.getServerInfo() %></li>
      <li><%= session.getId() %></li>
      <li><%= request.getParameter("input") %></li>
    </ul>

    <% if (Math.random() < 0.5){%>
      <h1>Have a nice day!</h1>
    <% } else { %>
      <h1>Mugo-mugo dinomu apik!</h1>
    <% }%>
  </body>
</html>
