<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>

  <body>

    <%!
      void DoSomething()
      {

      }
    %>

    <%
      List<String> fruits = new ArrayList<String>();
      fruits.add("apple");
      fruits.add("orange");
      fruits.add("banana");
    %>

    <ol>
      <%for(String fruit: fruits){ %>
      <li><%=fruit %></li>
      <%


        DoSomething(); %>
      <%}
      %>
    </ol>
  </body>
</html>
