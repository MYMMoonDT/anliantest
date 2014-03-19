package edu.tongji.anliantest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import edu.tongji.anliantest.model.EmployeeInfo;

@Controller
public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";
	protected static final String EMPLOYEE_CONTEXT = "EMPLOYEE_CONTEXT";
	
	protected EmployeeInfo getSessionEmployee(HttpServletRequest request){
		return (EmployeeInfo)request.getSession().getAttribute(EMPLOYEE_CONTEXT);
	}
	
	protected void setSessionEmployee(HttpServletRequest request, EmployeeInfo employee){
		request.getSession().setAttribute(EMPLOYEE_CONTEXT, employee);
	}
	
	public final String getAppbaseUrl(HttpServletRequest request, String url){
		Assert.hasLength(url, "url not null");
		Assert.isTrue(url.startsWith("/"), "start with /");
		return request.getContextPath() + url;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
}
