<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ruay-TopUp</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
    <%
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) session.getAttribute("user");
%>
</head>
<body>

  <jsp:include page="profile.jsp" />
  <div class="col-8" style="text-align: center">
  <form action="topup.do" method="post">
  <h2>เติมเงินเข้าบัญชี</h2>
  <img src="img/promt-pay-logo.jpg" alt="Flowers in Chania" width="250" height="200">
  <h3>หมายเลขบัญชี <%= data.get(0).get("bank_acct") %></h3>
  <input type="number" name="balance"><br>
  <input style="margin-top: 10px" type="submit" class="btn btn-info" value="เติมเงิน">
  </form>
  </div>
    <jsp:include page="menu.jsp" /> 
    <jsp:include page="footer.jsp" /> 
</body>
</html>