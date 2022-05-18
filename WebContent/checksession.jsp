<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
  <%
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) session.getAttribute("user");

   if(data != null) {
    
  }else{
  
  response.sendRedirect("login.jsp");

}

%>
</body>
</html>