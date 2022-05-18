<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.cartModel"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>cart</title>
</head>
<body>
  <jsp:include page="checksession.jsp" />  
 
  <jsp:include page="profile.jsp" /> 

  <%

  @SuppressWarnings("unchecked")
  ArrayList<cartModel> cartList = (ArrayList<cartModel>) session.getAttribute("cartList");
    if(cartList.equals(null)){
    out.println("cart empty");
  }else{
  %>
  <div class="col-8">
    <form action="cartok.do" style="align-items: center" method="post">
      <table class="table">
  		<thead class="thead-dark">
        <tr>
          <th>GoodId</th>
          <th>GoodName</th>
          <th>Unitprice</th>
          <th>จำนวน</th>
          <th>ราคารวม</th>
        </tr>
        </thead>
        <%
        double sumAll=0 ;
        for(int i = 0 ; i < cartList.size() ; i++){
        cartModel cart = cartList.get(i);
        double total = Double.parseDouble(cart.getTotal().toString());
        double unitprice = Double.parseDouble(cart.getGood_unitprice().toString());
        double sum = total* unitprice;
        sumAll = sumAll+sum;
        %>
        <tr>
          <td><%out.print(cart.getGood_id()); %></td>
          <td><%out.print(cart.getGood_name()); %></td>
          <td><%out.print(cart.getGood_unitprice()); %></td>
          <td><%out.print(cart.getTotal()); %></td>
          <td><%= sum %> บาท</td>
        </tr>
        <input type="hidden" name="good_id" value="<%=cart.getGood_id()%>">
        <input type="hidden" name="total" value="<%=cart.getTotal()%>">
        <input type="hidden" name="good_name" value="<%=cart.getGood_name()%>">
        <input type="hidden" name="unitprice" value="<%=cart.getGood_unitprice()%>">
        <%} %>

      </table>
      <br>
      <hr>
      <input type="hidden" name="balance" value="<%=sumAll%>">
      <h2>รวมทั้งสิ้น <%=sumAll %> บาท</h2>

      <input type="submit" class="btn btn-success" value="BUY NOW">
    </form>
    <%} %>
  </div>
   <jsp:include page="menu.jsp" /> 
  <jsp:include page="footer.jsp" /> 
</body>
</html>