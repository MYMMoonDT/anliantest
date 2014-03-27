<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">

<!-- 
本表单对应文件：工作任务单
表码：                       无
 -->

<div class="panel panel-default">
	<div class="panel-heading">工作任务单</div>
	<div class="panel-body">
		<form>

			<div class="row">
				<div class="col-sm-6 form-group">
					<label>项目名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>质控编号</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-2 form-group">
					<label>状态</label> 
						<select class="form-control" >
					    		<option>预评</option>
					    		<option>控评</option>
					    	</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>任务下达者</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>任务下达日期</label> <input type="date" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
					
						<thead>
							<tr>
								<th>组别</th>
								<th>工作内容</th>
								<th>工作时限</th>
								
								
							</tr>
						</thead>
						<tbody>
							<tr >
								<th>评价部</th>
								<td></td>
								<td></td>
								
								
							</tr>
							<tr >
								<th>检测部</th>
								<td></td>
								<td></td>
								
								
							</tr>
							
							<tr >
								<th>质控部</th>
								<td></td>
								<td></td>
								
								
							</tr>
							<tr >
								<th>其他</th>
								<td></td>
								<td></td>
								
								
							</tr>
						</tbody>
					</table>
					
				</div>
			</div>
			
			
		</form>
	</div>
</div>