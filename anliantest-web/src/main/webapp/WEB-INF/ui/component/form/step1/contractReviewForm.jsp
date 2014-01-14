<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：合同评审表
表码：                       ALJC/JL07-03
 -->

<div class="panel panel-default">
	<div class="panel-heading">合同评审表</div>
	<div class="panel-body">
		<form>

			<div class="row">
				<div class="col-sm-10 form-group">
					<label>项目名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-2 form-group">
					<label>编号</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
					
						<thead>
							<tr>
								<th>部门</th>
								<th>重点评审内容</th>
								<th>评审意见摘要</th>
								<th>签字</th>
								<th>时间</th>
								
							</tr>
						</thead>
						<tbody>
							<tr contenteditable="true">
								<td>评价部</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td>检测部</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td>行政部</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td>质控部</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
							<tr contenteditable="true">
								<td>总经理</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								
							</tr>
						</tbody>
					</table>
					<div class="row">
					<div class="col-sm-4 form-group">
						<label>技术负责人签字：</label> <input type="text" class="form-inline">
					</div>
					<div class="col-sm-4 form-group">
						
					</div>
					<div class="col-sm-4 form-group">
						<label>日期：</label> <input type="date" class="form-inline">
					</div>
					</div>
				</div>
			</div>
			
			
		</form>
	</div>
</div>