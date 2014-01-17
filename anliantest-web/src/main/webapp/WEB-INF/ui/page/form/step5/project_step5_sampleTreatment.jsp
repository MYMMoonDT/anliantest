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
<title>项目流程-5.实验环节</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${context}/ui/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${context}/ui/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${context}/ui/css/home.css">

<script src="${context}/ui/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${context}/ui/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<c:import url="../../../component/header.jsp"></c:import>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<c:import url="../../../component/navTree.jsp">
					<c:param name="nav" value="project"></c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<c:import url="../../../component/form/step5/SampleTreatment.jsp"></c:import>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<c:import url="../../../component/footer.jsp"></c:import>
			</div>
		</div>
	</div>
</body>
</html>