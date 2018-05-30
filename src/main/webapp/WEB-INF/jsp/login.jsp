<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Atm's Locator</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">

  <div class="row">
    <div class="col-md-offset-3 col-md-3">
      <form class="form-signin" name='f' action="perform_login" method='POST'>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" id="inputEmail" class="form-control" name='username' placeholder="Username" required autofocus>
        <input type="password" id="inputPassword" class="form-control" name='password' placeholder="Password" required>
        <c:if test="${param.error != null}"><label class="label-danger">Wrong username/password.</label></c:if>
        <div class="space-md"></div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div>
  </div>

</div>

<script src="js/lib/angular.min.js"></script>
<script src="js/lib/ui-bootstrap-tpls-2.5.0.min.js"></script>
<link rel="stylesheet" href="css/lib/bootstrap.min.css"/>
<link rel="stylesheet" href="css/app/app.css"/>

</body>

</html>
