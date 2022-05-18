<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report-stock</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>  
  <script src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script> 
  <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>  
  <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>  
  <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>   
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />


</head>
<body>
	<jsp:include page="checksession.jsp" />
	<jsp:include page="menu.jsp" />
	<h2 style="text-align: center">ยอดสินค้าคงเหลือเรียงตามลำดับรายการสินค้า</h2>
	<%
		@SuppressWarnings("unchecked")
	ArrayList<HashMap<String, Object>> data = (ArrayList<HashMap<String, Object>>) request.getAttribute("reportstock");
	%>
	    <table class="table">
  		<thead class="thead-dark">
			<tr>
				<th>รหัสสินค้า</th>
				<th>ชื่อสินค้า</th>
				<th>ราคาขาย</th>
				<th>คงเหลือ</th>

			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < data.size(); i++) {
			%>
			<tr>
				<td><%=data.get(i).get("id")%></td>
				<td><%=data.get(i).get("name")%></td>
				<td><%=data.get(i).get("unitprice")%></td>
				<td><%=data.get(i).get("replenish")%></td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$("#myTable").DataTable({
				 dom: 'Bfrtip',
	             buttons: [
	                 'copy', 'csv', 'excel', 'pdf', 'print'
	             ]
			});
		});
	</script>
</body>
</html>