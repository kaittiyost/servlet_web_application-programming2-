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
ArrayList<HashMap<String , Object>> data = (ArrayList< HashMap <String,Object>>) request.getAttribute("reportgood");
%>

<h2 style="text-align: center">ยอดขายเรียงตามลำดับสินค้า</h2>
<br>
<div style="text-align: center">

</div>
<hr>
 <table id="myTable" class="stripe" >
 <thead>
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
 <%for(int i = 0 ; i < data.size() ; i++){ %>
  <tr>
    <td><%=data.get(i).get("INVOICE_DATE")%></td>
    <td><%=data.get(i).get("ID")%></td>
    <td><%=data.get(i).get("CUSTOMER_ID")%></td>
    <td><%=data.get(i).get("cus_name")%></td>
    <td><%=data.get(i).get("GOOD_ID")%></td>
    <td><%=data.get(i).get("good_name")%></td>
    <td><%=data.get(i).get("UNITPRICE")%></td>
    <td><%=data.get(i).get("QUANTITY")%></td>
    <td><%=data.get(i).get("TOTAL_AMOUNT")%></td>
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
    
    <script type="text/javascript">
    function serch(){
    	var date_start = document.getElementById("date_start").value;
    	var date_end = document.getElementById("date_end").value;
    	$.ajax({
			type: "POST",
			enctype: "multipart/form-data",
			url: "reportgoodsettime.do",
			data: "date_start="+date_start+"&date_end="+date_end,
			timeout: 600000,
	        success: function (rs) {
	        	console.log("eiei"+rs);
	        	window.location.href = "reportgooddatetime.jsp";
	        }
		});

    }
    </script>
  
</body>
</html>