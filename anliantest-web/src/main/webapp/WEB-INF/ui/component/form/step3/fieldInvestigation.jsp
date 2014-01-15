<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<link rel="stylesheet" href="${context}/ui/css/form.css">
<!-- 
本表单对应文件：职业病危害评价现场调查表
表码：                       ALJC/JL32-13
 -->
<div class="panel panel-default">
	<div class="panel-heading">职业病危害评价现场调查表</div>
	<div class="panel-body">
		<form>
			<div class="row">
				<div class="col-sm-8 form-group">
					<label>建设单位</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>受理编号</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 form-group">
					<label>建设项目</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>报告编号</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 form-group">
					<label>单位地址</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>委托单位类型</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 form-group">
					<label>所属行业</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 form-group">
					<h3>员工数量</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>管理人员</label> <input type="number" class="form-control">
				</div>
				<div class="col-sm-6 form-group">
					<label>生产人员</label> <input type="number" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label class="control-label">委托单位内部职业卫生管理部门</label>
					<div class="contorl">
						<label class="radio-inline"> <input type="radio" name="optionsRadios">有
						</label>
						<label class="radio-inline"> <input type="radio" name="optionsRadios">无
						</label>
					</div>
				</div>
				<div class="col-sm-3 form-group">
					<label>部门名称</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-3 form-group">
					<label>人数</label> <input type="number" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>联系人1</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>工作部门</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>联系电话</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>联系人2</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>工作部门</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>联系电话</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 form-group">
					<table class="table table-bordered" style="TABLE-LAYOUT: fixed">
						<thead>
							<tr>
								<th>产品名称</th>
								<th>年产量</th>
								<th>产品名称</th>
								<th>年产量</th>
								<th>产品名称</th>
								<th>年产量</th>
							</tr>
						</thead>
						<tbody>
							<tr contenteditable="true">
								<td></td>
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
								<td></td>
							</tr>
							<tr contenteditable="true">
								<td></td>
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
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>建设单位提供的资料</label> <textarea rows="10" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<h2>现场情况调查</h2>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>总工艺流程</label> <textarea rows="6" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>原辅材料清单</label> <textarea rows="7" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>调查人员</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>陪同人员</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-4 form-group">
					<label>日期</label> <input type="date" class="form-control">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<h2>建设项目总平面布局图</h2>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>备注</label> <textarea rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>检测布点图<input type="file"></label> 
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<h2>各车间工艺调查</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>车间名称</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>生产工艺流程</label> <textarea rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>检测点</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-12 form-group">
					<label>检测布点图<input type="file"></label> 
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>车间名称</label> <input type="text" class="form-control">
				</div>
			</div>
			<div class="row">			
				<div class="col-sm-12 form-group">
					<label>生产工艺流程</label> <textarea rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>检测点</label> <input type="text" class="form-control">
				</div>
				<div class="col-sm-12 form-group">
					<label>检测布点图<input type="file"></label> 
				</div>
			</div>
		</form>
	</div>
</div>