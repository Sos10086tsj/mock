package com.cherong.mock.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
@Controller
@RequestMapping(value = "demo")
public class DemoController {
	@RequestMapping(value = "tab")
	public String tab(){
		return "demo/tab";
	}
}
