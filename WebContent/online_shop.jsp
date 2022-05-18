<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>RuayShop</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
  
  <jsp:include page="profile.jsp" /> 
  <%
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) session.getAttribute("datagood");
    %>
    <div class="col-8">
      <form action="addcart.do" method="post" style="text-align: center">
        <% for(int i=0 ; i < data.size() ; i++ ){ %>
        <span><h3><%= data.get(i).get("name") %>
         ราคา :<%= data.get(i).get("unitprice") %> บาท</h3></span>
         <%if(data.get(i).get("replenish").equals("สินค้าหมด")){ %>
         <h5 style="color: red">out of stock</h5>
         <hr>
         <%}else{ %>
         <h5 style="color: green">Stock : <%= data.get(i).get("replenish") %></h5>
         <input type="hidden" value="<%= data.get(i).get("id") %>" name ="good_id">
         <input type="hidden" value="<%= data.get(i).get("name") %>" name ="good_name">
         <input type="hidden" value="<%= data.get(i).get("unitprice") %>" name ="good_unitprice">
         <select name="select" >
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
        <hr>  
        <%}
      } %>

      <input type="submit" class="btn btn-primary" value="add Cart">
    </form>

  </div>
  <jsp:include page="menu.jsp" /> 
</div>

  <jsp:include page="footer.jsp" /> 
</body>
</html>