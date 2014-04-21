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
		<form action="${context}/project/createContractReviewRecordTable"
			method="post">

			<div class="row">
				<div class="col-sm-10 form-group">
					<label>项目名称</label> <input type="text" class="form-control"
						name="projectName" value="${projectInfo.projectName}">
				</div>
				<div class="col-sm-2 form-group">
					<label>编号</label> <input type="text" class="form-control"
						name="tableNum" value="ALJC/JL07-03">
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
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
								class="form-inline" value="评价部">评价部</th>
								<td><textarea name="reviewContent"
								class="form-inline" >${PJB}</textarea></td>
								<td><textarea name="reviewComment"
								class="form-inline" ></textarea></td>
								<td><select name="itemStatus" class="form-inline">
										<option value="unsigned">不通过</option>
										<option value="signed">通过</option>
								</select></td>
								<td><input type="date" name="itemTime"
								class="form-inline" ></td>

							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
								class="form-inline" value="检测部">检测部</th>
								<td><textarea name="reviewContent"
								class="form-inline" >${JCB}</textarea></td>
								<td><textarea name="reviewComment"
								class="form-inline" ></textarea></td>
								<td><select name="itemStatus" class="form-inline">
										<option value="unsigned">不通过</option>
										<option value="signed">通过</option>
								</select></td>
								<td><input type="date" name="itemTime"
								class="form-inline"></td>

							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
								class="form-inline" value="行政部">行政部</th>
								<td><textarea name="reviewContent"
								class="form-inline" >${XZB}</textarea></td>
								<td><textarea name="reviewComment"
								class="form-inline" ></textarea></td>
								<td><select name="itemStatus" class="form-inline">
										<option value="unsigned">不通过</option>
										<option value="signed">通过</option>
								</select></td>
								<td><input type="date" name="itemTime"
								class="form-inline"></td>

							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
								class="form-inline" value="质控部">质控部</th>
								<td><textarea name="reviewContent"
								class="form-inline" >${ZKB}</textarea></td>
								<td><textarea name="reviewComment"
								class="form-inline" ></textarea></td>
								<td><select name="itemStatus" class="form-inline">
										<option value="unsigned">不通过</option>
										<option value="signed">通过</option>
								</select></td>
								<td><input type="date" name="itemTime"
								class="form-inline"></td>

							</tr>
							<tr contenteditable="false">
								<th><input type="hidden" name="departmentName"
								class="form-inline" value="总经理">总经理</th>
								<td><textarea name="reviewContent"
								class="form-inline" >${ZJL}</textarea></td>
								<td><textarea name="reviewComment"
								class="form-inline" ></textarea></td>
								<td><select name="itemStatus" class="form-inline">
										<option value="unsigned">不通过</option>
										<option value="signed">通过</option>
								</select></td>
								<td><input type="date" name="itemTime"
								class="form-inline"></td>

							</tr>
						</tbody>
					</table>
					<div class="row">
						<div class="col-sm-4 form-group">
							<label>技术负责人签字：</label> <select name="tableStatus"
								class="form-inline">
								<option value="unsigned">不通过</option>
								<option value="signed">通过</option>
							</select>
						</div>
						<div class="col-sm-4 form-group"></div>
						<div class="col-sm-4 form-group">
							<label>日期：</label> <input type="date" name="tableTime"
								class="form-inline">
						</div>
					</div>
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