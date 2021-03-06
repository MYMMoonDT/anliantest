<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/plugin/DataTables/media/css/jquery.dataTables_themeroller.css">
<link rel="stylesheet" href="${context}/ui/css/dataTable.css">
<script src="${context}/ui/plugin/DataTables/media/js/jquery.dataTables.js"></script>
<script src="${context}/ui/js/panel/projectList.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">项目管理</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<button id="creat_project_btn" type="button" class="btn btn-primary">创建</button>
				<button id="view_edit_project_btn" type="button" class="btn btn-primary">查看/编辑</button>
				<button id="delete_project_btn" type="button" class="btn btn-primary">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table id="project_list">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>项目类型</th>
							<th>业务负责人</th>
							<th>项目负责人</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${projects}" var="project">
						<tr>
						<td>${project.projectName}</td>
						<td>${project.projectType}</td>
						<td>${project.employeeInfoByBusinessEmployeeId.employeeName}</td>
						<td>${project.employeeInfoByProjectEmployeeId.employeeName}</td>
						<td>${project.projectCreateTime}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>