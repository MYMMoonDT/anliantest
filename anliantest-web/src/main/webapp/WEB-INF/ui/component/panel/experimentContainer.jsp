<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div class="col-md-12">
				<ul class="nav nav-tabs">
				  	<li class="active"><a href="#dataProcess" data-toggle="tab">数据处理</a></li>
				  	<li><a href="#deviceManage" data-toggle="tab">设备管理</a></li>
				</ul>
				
				<div class="tab-content">
				  	<div class="tab-pane active" id="dataProcess">
				  		<div class="row">
				  			<div class="col-sm-12">
				  				<a href="${context}/experimentCalculation" class="btn btn-primary btn-create-testreport" role="button">创建检测报告</a>
				  			</div>
				  		</div>
				  		<div class="row">
				  			<div class="col-sm-12">
				  				
				  			</div>
				  		</div>
				  	</div>
				  	<div class="tab-pane" id="deviceManage">
				  	</div>
				</div>
			</div>
		</div>
	</div>
</div>