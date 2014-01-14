<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：合同更改申请单
表码：                       ALJC/JL07-04
 -->

<div class="panel panel-default">
	<div class="panel-heading">合同更改申请单</div>
	<div class="panel-body">
		<form>

			<div class="row">
				<div class="col-sm-8 form-group">
					<label>合同名称/编号</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>签订日期</label> <input type="date" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>修订原因</label><br/>
					<textarea rows="6" cols="140"></textarea>
				</div>
			</div>
			
			<div class="row ">
				
					<div class="col-sm-12 form-group">
						<label>修订内容</label><br/>
						<textarea rows="6" cols="140"></textarea>
					</div>
				
				
					<div class="col-sm-12 form-group">
			
						<div class="col-sm-4 form-group">
							<label>申请部门：</label> <input type="text" class="form-inline">
						</div>
						<div class="col-sm-4 form-group">
							<label>申请人：</label> <input type="text" class="form-inline">
						</div>
						
						<div class="col-sm-4 form-group">
							<label>日期：</label> <input type="date" class="form-inline">
						</div>
						
					</div>
				
			</div>
			
			<div class="row ">
				
					<div class="col-sm-12 form-group">
						<label>评审结果</label><br/>
						<textarea rows="6" cols="140"></textarea>
					</div>
				
				
					<div class="col-sm-12 form-group">
			
						<div class="col-sm-4 form-group">
							
						</div>
						<div class="col-sm-4 form-group">
							<label>签名：</label> <input type="text" class="form-inline">
						</div>
						
						<div class="col-sm-4 form-group">
							<label>日期：</label> <input type="date" class="form-inline">
						</div>
						
					</div>
				
			</div>
			
			<div class="row ">
				
					<div class="col-sm-12 form-group">
						<label>批准</label><br/>
						<textarea rows="6" cols="140"></textarea>
					</div>
				
				
					<div class="col-sm-12 form-group">
			
						<div class="col-sm-4 form-group">
							
						</div>
						<div class="col-sm-4 form-group">
							<label>签名：</label> <input type="text" class="form-inline">
						</div>
						
						<div class="col-sm-4 form-group">
							<label>日期：</label> <input type="date" class="form-inline">
						</div>
						
					</div>
				
			</div>
		</form>
	</div>
</div>