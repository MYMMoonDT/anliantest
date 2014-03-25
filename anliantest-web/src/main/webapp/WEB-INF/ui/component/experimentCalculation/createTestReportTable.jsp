<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">

<div class="panel panel-primary">
	<div class="panel-heading">创建检测报告</div>
	<div class="panel-body">
		<form action="${context}/createTestReportTable" role="form" method="POST">
<!-- temp item -->
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>报告编号</label> <input name="testReportNum" type="text" class="form-control" required="">
				</div>
			</div>
<!-- temp item end -->
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>样品名称</label> <input name="sampleName" type="text" class="form-control" required="">
				</div>
				<div class="col-sm-6 form-group">
					<label>样品数量</label> <input name="sampleNum" type="text" class="form-control" required="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>受检单位</label> <input name="testUnitName" type="text" class="form-control" required="">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>样品状态</label> <input name="sampleStatus" type="text" class="form-control" required="">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-6 form-group">
					<label>受检单位地址</label> <input name="testUnitAddress" type="text" class="form-control" required="">
				</div>			
				<div class="col-sm-6 form-group">
					<label>检测性质</label> <input name="testProperty" type="text" class="form-control" required="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>委托单位</label> <input name="entrustUnitName" type="text" class="form-control" required="">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-6 form-group">
					<label>采样日期</label> <input name="sampleTimeStart" type="date" class="form-control" required="">
				</div>
				<div class="col-sm-6 form-group">
					<label>至</label> <input name="sampleTimeEnd" type="date" class="form-control" required="">
				</div>
			</div>
			<div class="row">		
				<div class="col-sm-6 form-group">
					<label>接受日期</label> <input name="receiveTimeStart" type="date" class="form-control" required="">
				</div>
				<div class="col-sm-6 form-group">
					<label>至</label> <input name="receiveTimeEnd" type="date" class="form-control" required="">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-6 form-group">
					<label>检测日期</label> <input name="testTimeStart" type="date" class="form-control" required="">
				</div>
				<div class="col-sm-6 form-group">
					<label>至</label> <input name="testTimeEnd" type="date" class="form-control" required="">
				</div>
			</div>
			<div class="row">				
				<div class="col-sm-6 form-group">
					<label>报告日期</label> <input name="reportTime" type="date" class="form-control" required="">
				</div>
			</div>
<!-- 			<div class="row">			 -->
<!-- 				<div class="col-sm-4 form-group"> -->
<!-- 					<label>编制人</label> <input name="testTime" type="text" class="form-control"> -->
<!-- 				</div>			 -->
<!-- 				<div class="col-sm-4 form-group"> -->
<!-- 					<label>审核人</label> <input name="reportTime" type="text" class="form-control"> -->
<!-- 				</div>		 -->
<!-- 				<div class="col-sm-4 form-group"> -->
<!-- 					<label>签发人</label> <input name="reportTime" type="text" class="form-control"> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>日期</label> <input name="tableTime" type="date" class="form-control" required="">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">创建并输入检测结果</button>		
		</form>
	</div>
</div>