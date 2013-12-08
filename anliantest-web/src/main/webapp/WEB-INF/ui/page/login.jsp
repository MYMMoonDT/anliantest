<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="ui/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="ui/css/login.css">

<script src="ui/js/jquery/jquery-1.10.2.min.js"></script>
<script src="ui/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
      <form action="${context}/checkLogin" class="form-signin" role="form" method="POST">
        <h2 class="form-signin-heading">登录系统</h2>
        <input name="employeeNumber" type="text" class="form-control" placeholder="员工工号" required="" autofocus="">
        <input name="employeePassword" type="password" class="form-control" placeholder="密码" required="">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div>
</body>
</html>