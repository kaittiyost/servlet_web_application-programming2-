<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>report-Customer</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
  <jsp:include page="checksession.jsp" />  
  <jsp:include page="menu.jsp" />


  <% 
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) request.getAttribute("reportCustomer");
    %>
    <h2 style="text-align: center">ยอดการสั่งซื้อสินค้าเรียงลำดับตามสมาชิก</h2>

     <table class="table">
  		<thead class="thead-dark">
      <tr>
        <th>ชื่อลูกค้า</th>
        <th>วันที่</th>
        <th>รหัสใบเสร็จ</th>
        <th>รหัสลูกค้า</th>
        <th>รหัสสินค้า</th>
        <th>ชื่อสินค้า</th>
        <th>ราคา</th>
        <th>จำนวน</th>
        <th>ราคารวม</th>
      </tr>
    </thead>
    <tbody>
      <%for(int i = 0 ; i < data.size() ; i++){ %>
      <tr>
        <td><%=data.get(i).get("cus_name") %></td>
        <td><%=data.get(i).get("INVOICE_DATE") %></td>
        <td><%=data.get(i).get("ID") %></td>
        <td><%=data.get(i).get("CUSTOMER_ID") %></td>
        <td><%=data.get(i).get("GOOD_ID") %> </td>
        <td><%=data.get(i).get("good_name") %></td>
        <td><%=data.get(i).get("UNITPRICE") %></td>
        <td><%=data.get(i).get("QUANTITY") %></td>
        <td><%=data.get(i).get("TOTAL_AMOUNT") %></td>
      </tr>
     
      <%} %>
    </tbody>
  </table>

  <script>
    $(document).ready(function () {
      $("#myTable").DataTable();
    });
  </script>
  <jsp:include page="footer.jsp" /> 
</body>
</html>