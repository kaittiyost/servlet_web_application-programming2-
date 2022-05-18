<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Profile</title>
  <jsp:include page="bootstrap/bootstrap.jsp" />  
    <%
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) session.getAttribute("user");
%>
</head>
<body>
  <jsp:include page="checksession.jsp" />  
    <br>
  	<h1 style="text-align: center">Ruay Marketplace</h1>
	<br>
	<br>
     <div class="container">
  <div class="row" style="margin-left: 20px ;">


    <div class="col-2" style="background-color: #E8E8E8 ; margin-bottom: 10px">
      <h4 style=" margin-top: 10px">Hello : <%=data.get(0).get("name") %></h4>
      <h4><%=data.get(0).get("surname") %></h4>
      <h4><%=data.get(0).get("username") %></h4>
      <h4><%=data.get(0).get("address") %></h4>
      <h4>ยอดเงิน :<%=session.getAttribute("customer_balance")%> บาท</h4>
      <hr>
  
      <form action="updatebalance.jsp" method="post">
        <input type="submit" class="btn btn-success" value="เติมเงิน" style="width: 100% ; ">
      </form>
      <form action="showgood.do" method="post">
        <input type="submit" class="btn btn-warning" value="online shop" style="width: 100% ; margin-top: 10px ;">
      </form>
      <hr>

	    <form action="logout.do"  method="post">
        <input type="submit" class="btn btn-danger" value="ออกจากระบบ" style="width: 100%">
      </form>
    </div>

  </body>
  </html>