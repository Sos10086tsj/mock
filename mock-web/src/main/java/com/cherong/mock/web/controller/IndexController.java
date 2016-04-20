package com.cherong.mock.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cherong.mock.domain.api.user.model.User;
import com.cherong.mock.web.exception.constant.ExceptionConstant;
import com.cherong.mock.web.exception.user.BaseUserException;
import com.cherong.mock.web.sys.logic.UserLogic;
import com.cherong.mock.web.vo.ResponseVo;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 20, 2016
**/
@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private UserLogic userLogic;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseVo login(Model model, HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			this.userLogic.userLogin(username, password, request.getSession().getId());
		} catch (BaseUserException e) {
			logger.error("{}",e);
			return ResponseVo.getFailureResponse(e.getCode(), e.getMessage());
		}catch (Exception e) {
			logger.error("{}",e);
			return ResponseVo.getFailureResponse(ExceptionConstant.UNKNOWN_EXCEPTION.CODE,ExceptionConstant.UNKNOWN_EXCEPTION.MESSAGE);
		}
		return ResponseVo.getSuccessResponse();
	}
	
	@RequestMapping(value = "homepage", method = RequestMethod.GET)
	public String homepage(Model model, HttpServletRequest request){
		User currentUser = this.userLogic.getUser(request.getSession().getId());
		model.addAttribute("name", currentUser.getName());
		return "homepage";
	}
}
