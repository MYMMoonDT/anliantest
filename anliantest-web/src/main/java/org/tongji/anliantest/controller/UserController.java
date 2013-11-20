package org.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends AbstractController {
	@RequestMapping("login")
	public String login(){
		return "home";
	}
}
