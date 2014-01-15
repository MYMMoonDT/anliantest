<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：公共场所卫生检测通知单
表码：                       ALJC/JL26-04
 -->
<div class="panel panel-default">
	<div class="panel-heading">公共场所卫生检测通知单</div>
	<div class="panel-body">
		<form>
			<div class="row">
				<div class="col-sm-8 form-group">
					<label>项目名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>项目编号</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>单位名称</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>单位地址</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>联系人</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-8 form-group">
					<label>联系电话</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>检测时间</label> <input type="date" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>报告提交时间</label> <input type="date" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
						<thead>
							<tr>
								<th>检测地点</th>
								<th>检测指标</th>
								<th>检测点数</th>
								<th>样品数</th>
							</tr>
						</thead>
						<tbody>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>通知人</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>审核人</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>接收人</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>提交日期</label> <input type="date" class="form-control">
				</div>
				<div class="col-sm-4 col-sm-offset-4 form-group">
					<label>接收时间</label> <input type="date" class="form-control">
				</div>
			</div>
		</form>
	</div>
</div>