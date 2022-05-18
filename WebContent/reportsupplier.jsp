<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Report_supplier</title>
   <jsp:include page="bootstrap/bootstrap.jsp" /> 
  <% 
  @SuppressWarnings("unchecked")
  ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) request.getAttribute("reportsupplier");
    %>
  </head>
  <body>
    <jsp:include page="checksession.jsp" />  
    <jsp:include page="menu.jsp" />
    <jsp:include page="profile.jsp" /> 
    <div class="col-10">
    <h2 style="text-align: center">ยอดการสั่งซื้อสินค้าจากซัพพลายเออร์เรียงลำดับตามซัพพลายเออร์</h2>

       <table class="table">
  		<thead class="thead-dark">
        <tr>
          <th>รหัสใบสั่งซื้อ</th>
          <th>รหัสซัพพลายเออร์</th>
          <th>ชื่อซัพพลายเออร์</th>
          <th>วันที่สั่งซื้อ</th>
          <th>รหัสสินค้า</th>
          <th>ราคารวม</th>
          <th>สถานะ</th>
        </tr>
      </thead> 
      <tbody>
      <%for(int i = 0 ; i < data.size() ; i ++){ %>
        <tr>
         
          <td><%= data.get(i).get("ID") %>${rowSupplier.id}</td>
          <td><%= data.get(i).get("SUPPLIER_ID") %></td>
          <td><%= data.get(i).get("name") %></td>
          <td><%= data.get(i).get("PURCHASE_DATE") %></td>
          <td><%= data.get(i).get("GOOD_ID") %></td>
          <td><%= data.get(i).get("TOTAL_AMOUNT") %></td>
          <%if(data.get(i).get("STATUS").equals("1")){ %>
          <td style="color:green">รับสินค้าแล้ว</td>
          <%}else{ %>
          <td>ยังไม่รับสินค้า</td>
          <%} %>
        </tr>
        <%} %>
      </tbody>
    </table>
      <jsp:include page="footer.jsp" /> 
    </div>
    <script>
      $(document).ready(function () {
        $("#myTable").DataTable({
        	 dom: 'Bfrtip',
             buttons: [
                 'excel', 'pdf', 'print'
             ]
        });
      });
    </script>
  </body>
  </html>