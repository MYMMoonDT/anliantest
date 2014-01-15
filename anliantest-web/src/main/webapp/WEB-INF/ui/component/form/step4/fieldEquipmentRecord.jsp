<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：现场仪器设备使用记录表
表码：                    ALJC/JL23-08-01
 -->
<div class="panel panel-default">
	<div class="panel-heading">现场仪器设备使用记录表</div>
	<div class="panel-body">
		<form>			
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
						<thead>
							<tr>
								<th>日期/时间</th>
								<th>使用地点</th>
								<th>使用前状态</th>
								<th>使用后状态</th>
								<th>使用者</th>
							</tr>
						</thead>
						<tbody>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
								<td></td>
								<td></td>
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