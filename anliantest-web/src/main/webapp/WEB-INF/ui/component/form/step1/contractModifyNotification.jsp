<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="ui/css/form.css">
<!-- 
本表单对应文件：合同更改通知单
表码：                      ALJC/JL07-05
 -->

<div class="panel panel-default">
	<div class="panel-heading">合同更改通知单</div>
	<div class="panel-body">
		<form>

			<div class="row col-sm-12 ">
				<label>通知发往部门</label> <input type="text" class="form-control">
			</div>
			
			<div class="row col-sm-12">
				<label>客户名称</label> <input type="text" class="form-control">
			</div>
			
			<div class="row col-sm-12">
				<label>合同编号</label> <input type="text" class="form-control">
			</div>
			
			
			<div class="row ">
				
					<div class="col-sm-12 form-group">
						<label>更改前条款</label><br/>
						<textarea rows="6" cols="140"></textarea>
					</div>
					
					<div class="col-sm-12 form-group">
						<label>更改后条款</label><br/>
						<textarea rows="6" cols="140"></textarea>
					</div>
				
				
					
				
			</div>
			
			<div  class="row" >
			
				<div class="col-sm-12">
				<div class="col-sm-6 form-group">
					<label>通知人签字：</label> <input type="text" class="form-inline">
				</div>
						
				<div class="col-sm-4 form-group">
					<label>日期：</label> <input type="date" class="form-inline">
				</div>
				</div>
						
			</div>
			
			<div class="row" >
			
				<div  class="col-sm-12" >
				<div class="col-sm-6 form-group">
					<label>接收人签字：</label> <input type="text" class="form-inline">
				</div>
						
				<div class="col-sm-4 form-group">
					<label>日期：</label> <input type="date" class="form-inline">
				</div>
				</div>		
			</div>
			
			
			
			
		</form>
	</div>
</div>