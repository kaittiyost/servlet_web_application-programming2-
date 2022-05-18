<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report-OrderyGood</title>
   <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
<jsp:include page="checksession.jsp" />  
<jsp:include page="menu.jsp" />
<% 
@SuppressWarnings("unchecked")
ArrayList<HashMap<String , Object>> newData = (ArrayList< HashMap <String,Object>>) request.getAttribute("invoice_date_time");


System.out.println("++++++++++++++++++");
System.out.println(newData);
%>

<h2 style="text-align: center">ยอดขายเรียงตามลำดับสินค้า</h2>
<br>
<div style="text-align: center">
<form action="reportgoodsettime.do" method="post">
<p>วันที่ : <input type="date" name="date_start"> ถึงวันที่ : <input type="date" name="date_end"></p>
<input type="submit" value="serch">
</form>
</div>
<hr>
    <table class="table">
  		<thead class="thead-dark">
  <tr>
    <th>วันที่</th>
    <th>รหัสใบเสร็จ</th>
    <th>รหัสลูกค้า</th>
    <th>ชื่อลูกค้า</th>
    <th>รหัสสินค้า</th>
    <th>ชื่อสินค้า</th>
    <th>ราคา</th>
    <th>จำนวน</th>
    <th>ราคารวม</th>
  </tr>
</thead>
<tbody>
 <%for(int i = 0 ; i < newData.size() ; i++){ %>
  <tr>
    <td><%=newData.get(i).get("INVOICE_DATE")%></td>
    <td><%=newData.get(i).get("ID")%></td>
    <td><%=newData.get(i).get("CUSTOMER_ID")%></td>
    <td><%=newData.get(i).get("cus_name")%></td>
    <td><%=newData.get(i).get("GOOD_ID")%></td>
    <td><%=newData.get(i).get("good_name")%></td>
    <td><%=newData.get(i).get("UNITPRICE")%></td>
    <td><%=newData.get(i).get("QUANTITY")%></td>
    <td><%=newData.get(i).get("TOTAL_AMOUNT")%></td>
  </tr>
<%} %>
</tbody>
</table>
  <jsp:include page="footer.jsp" /> 

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