<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>

  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <jsp:include page="checksession.jsp" />  
</head>

<body>

  <%
  @SuppressWarnings("unchecked")
  ArrayList<Object> cart = (ArrayList<Object>) session.getAttribute("cartList");

    @SuppressWarnings("unchecked")
    ArrayList<Object> user_login = (ArrayList<Object>) session.getAttribute("user");

     %>
      <div class="col-2" style="background-color: #EEEEEE">
      <span>
        <a class="btn btn-secondary" style="width: 150px ; margin-top: 10px" href="report.jsp">report</a>
        <%if(cart != null){ %>
        <a  class="btn btn-secondary" style="width: 150px ; margin-top: 10px" href="cart.jsp">cart [<%=cart.size() %>]</a>
        <%}else{ %>
        <a  class="btn btn-secondary" style="width: 150px ; margin-top: 10px" href="online_shop.jsp" onclick="noGoodInCart()">cart [0]</a>
      </span>
      <%} %>

    </div>

    <hr>
    <script type="text/javascript">
    function noGoodInCart() {
		alert('ไม่มีสินค้าในตระกร้า');
	}
    </script>
  </body>
  </html>