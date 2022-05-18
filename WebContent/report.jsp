<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Report</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
  <jsp:include page="checksession.jsp" />  

  <jsp:include page="profile.jsp" /> 

  <div class="col-8">
    <h1>Report</h1>

    <form action="reportproduct.do" method="post" style="margin-top: 10px">
      <input class="btn btn-info" type="submit" value="ดูยอดขายเรียงลำาดับตามรายการสินค้า">
    </form>

    <form action="reportstock.do" method="post" style="margin-top: 10px">
      <input class="btn btn-info" type="submit" value="ดูยอดสินค้าคงเหลือเรียงลำาดับตามรายการสินค้า ณ ปัจจุบัน">
    </form>
    
    <form action="reportsupplier.do" method="post" style="margin-top: 10px">
      <input class="btn btn-info" type="submit" value="รายงานเพื่อดูยอดการสั่งซื้อสินค้าจากซัพพลายเออร์เรียงลำาดับตามซัพพลายเออร">
    </form>

    <form action="reportcustomer.do" method="post" style="margin-top: 10px">
      <input class="btn btn-info" type="submit" value="ดูยอดการขายสินค้าเรียงลำาดับตามสมาชิก">
    </form>
    <hr>
        <form action="reportgoodsettime.do" method="post" style="margin-top: 10px">
      <input class="btn btn-dark" type="submit" value="ดูยอดการขายสินค้าแบบเลือกตามวันที่">
    </form>
  </div>
   <jsp:include page="menu.jsp" />  
    <jsp:include page="footer.jsp" /> 
</body>
</html>