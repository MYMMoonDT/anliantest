<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：类比企业选择登记
表码：                       ALJC/JL32-03
 -->
<div class="panel panel-default">
	<div class="panel-heading">类比企业选择登记</div>
	<div class="panel-body">
		<form>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>建设项目名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>项目编号</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>类比企业名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>编写人</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<label>建设项目生产规模（t/a）</label> <textarea rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>类比项目生产规模（t/a）</label> <textarea rows="4" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>类比项目内容</label> <textarea rows="14" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>类比项目生产生产工艺流程</label> <textarea rows="9" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>填表人签字</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>填表时间</label> <input type="date" class="form-control">
				</div>
			</div>			
		</form>
	</div>
</div>