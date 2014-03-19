<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">

<script src="${context}/ui/js/experimentCalculation.js"></script>

<div class="panel panel-default">
	<div class="panel-heading">实验数据输入</div>
	<div class="panel-body">
		<form id="formid" action="${context}/addTestReportItemAndCalc" role="form" method="POST">
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>车间/岗位</label> <input name="testWorkshopJob" id="position" type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>危害因素</label>
					<select name="testSubstanceId" id="substance" class="form-control">
					</select>
				</div>
				<div class="col-sm-6 form-group" id="detail" >
					<label>因素名称</label> <input name="testSubstanceDetailedName" type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>样品编号</label> <input name="testSampleNum" id="no" type="text" class="form-control">
				</div>
			</div>
			<div class="dayData">
				<div class="row">
					<div class="col-sm-6 form-group">
						<label>日期</label> <input name="testTime" type="date" class="date form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<label>检测结果</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>接触时间</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>采集时间</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[0]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[0]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[0]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[0]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[0]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[0]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[0]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[0]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[0]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[0]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[0]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[0]" value="15" type="text" class="time form-control">
					</div>
				</div>
			</div>
			<div class="dayData">
				<div class="row">
					<div class="col-sm-6 form-group">
						<label>日期</label> <input name="testTime" type="date" class="date form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<label>检测结果</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>接触时间</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>采集时间</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[1]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[1]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[1]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[1]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[1]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[1]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[1]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[1]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[1]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[1]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[1]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[1]" value="15" type="text" class="time form-control">
					</div>
				</div>
			</div>
			<div class="dayData">
				<div class="row">
					<div class="col-sm-6 form-group">
						<label>日期</label> <input name="testTime" type="date" class="date form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<label>检测结果</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>接触时间</label>
					</div>
					<div class="col-sm-4 form-group">
						<label>采集时间</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[2]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[2]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[2]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[2]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[2]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[2]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[2]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[2]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[2]" value="15" type="text" class="time form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 form-group">
						<input name="testResult[2]" type="text" class="data form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testTouchTime[2]" type="text" class="time form-control">
					</div>
					<div class="col-sm-4 form-group">
						<input name="testCollectTime[2]" value="15" type="text" class="time form-control">
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-default">继续</button>
		</form>
<!-- 		<button id="next_btn" type="button" class="btn btn-default">继续</button> -->
<!-- 		<button id="finish_btn" type="button" class="btn btn-primary">完成</button> -->
	</div>
</div>