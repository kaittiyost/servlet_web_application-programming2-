<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
  <div style="text-align: center ; margin-top: 20px">
    <h1>Login Page</h1>
    <form action="checklogin.do" method="POST" >
      username : <input type="text" name="username">
      <br>
      password : <input type="password" name="password">
      <br>
      <input class="btn btn-success" style="margin-top: 10px" type="submit" value="login" /> 
      | <a  class="btn btn-warning" style="margin-top: 10px"  href="register.jsp">register</a>
    </form>
  </div>
  <jsp:include page="footer.jsp" /> 
</body>
</html>