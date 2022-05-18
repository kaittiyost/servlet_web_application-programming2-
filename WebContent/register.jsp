<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Ruay-register</title>
  <jsp:include page="bootstrap/bootstrap.jsp" /> 
</head>
<body>
  <div style="text-align: center">
    <h1>Register</h1><br>
    <a href="login.jsp" class="btn btn-dark" style="margin-bottom: 20px">Back</a>
    <form action="register.do" method="post">
     <div class="form-group">
      <label>name:</label>
      <input type="text" name="name"> <br>
    </div>
    <div class="form-group">
      surname :
      <input type="text" name="surname"> <br>
    </div>
    <div class="form-group">
      username :
      <input type="text" name="username"> <br>
    </div>
    <div class="form-group">
      password:
      <input type="text" name="password"> <br>
    </div>
    <div class="form-group">
      address :
      <input type="number" name="address"> <br>
    </div>
    <div class="form-group">
      postcode :
      <input type="number" name="postcode"> <br>
    </div>
    <div class="form-group">
      bank_acct :
      <input type="number" name="bank_acct"> <br>
    </div>
    <div class="form-group">
      balance :
      <input type="number" name="balance"> <br>
    </div>
    <br>
    <input  class="btn btn-primary" type="submit" value="RegisterNow">

  </form>
</div>
  <jsp:include page="footer.jsp" /> 
</body>
</html>