package org.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(){
		return "ui/page/home";
	}
}
