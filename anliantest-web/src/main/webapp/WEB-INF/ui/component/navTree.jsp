<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="ui/css/navTree.css">
<div class="panel panel-default">
  	<div class="panel-body">
		<ul class="nav nav-pills nav-stacked nav-tree">
		  	<c:choose>
			  	<c:when test="${param.nav == 'home'}">
			  		<li class="active"><a href="${context}/home">待办事宜</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="${context}/home">待办事宜</a></li>
			  	</c:otherwise>
		  	</c:choose>

		  	<c:choose>
			  	<c:when test="${param.nav == 'project'}">
			  		<li class="active"><a href="${context}/project">项目管理</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="${context}/project">项目管理</a></li>
			  	</c:otherwise>
		  	</c:choose>
		  	
		  	<c:choose>
			  	<c:when test="${param.nav == 'experiment'}">
			  		<li class="active"><a href="${context}/experiment">实验管理</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="${context}/experiment">实验管理</a></li>
			  	</c:otherwise>
		  	</c:choose>
		  	
		  	<c:choose>
			  	<c:when test="${param.nav == 'document'}">
			  		<li class="active"><a href="${context}/document">档案管理</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="${context}/document">档案管理</a></li>
			  	</c:otherwise>
		  	</c:choose>
		  	
		  	<c:choose>
			  	<c:when test="${param.nav == 'message'}">
			  		<li class="active"><a href="${context}/message">消息中心</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="${context}/message">消息中心</a></li>
			  	</c:otherwise>
		  	</c:choose>
		</ul>
	</div>
</div>