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
					<label>项目名称</label> <input type="text" class="form-control"
						name="projectName" value="${projectName}">
				</div>
				<div class="col-sm-4 form-group">
					<label>质控编号</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-2 form-group">
					<label>状态</label> <select class="form-control" name="tableType">
						<option value="预评">预评</option>
						<option value="控评">控评</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6 form-group">
					<label>任务下达者</label> <input type="text" class="form-control"
						name="taskEmployee" value="">
				</div>
				<div class="col-sm-6 form-group">
					<label>任务下达日期</label> <input type="date" class="form-control"
						name="taskTime">
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
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
									class="form-inline" value="评价部">评价部</th>
								<td><textarea name="workContent" class="form-inline"></textarea></td>
								<td><textarea name="workTimeLimit" class="form-inline"></textarea></td>


							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
									class="form-inline" value="检测部">检测部</th>
								<td><textarea name="workContent" class="form-inline"></textarea></td>
								<td><textarea name="workTimeLimit" class="form-inline"></textarea></td>


							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
									class="form-inline" value="质控部">质控部</th>
								<td><textarea name="workContent" class="form-inline"></textarea></td>
								<td><textarea name="workTimeLimit" class="form-inline"></textarea></td>


							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
									class="form-inline" value="其他">其他</th>
								<td><textarea name="workContent" class="form-inline"></textarea></td>
								<td><textarea name="workTimeLimit" class="form-inline"></textarea></td>


							</tr>
						</tbody>
					</table>

				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="pull-right">
						<button type="submit" class="btn btn-primary">创建</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
				</div>
			</div>

		</form>
	</div>
</div>