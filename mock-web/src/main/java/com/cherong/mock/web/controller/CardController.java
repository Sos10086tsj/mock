package com.cherong.mock.web.controller;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.bank.logic.CardLogic;
import com.cherong.mock.web.vo.ResponseVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
@Controller
@RequestMapping(value = "card")
public class CardController {
	@Resource
	private CardLogic cardLogic;

	/**
	 * 进入卡片管理页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "")
	public String card(Model model){
		return "card/card";
	}
	
	/**
	 * 获取卡片store
	 * @param queryVo
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "store")
	public Pagination<Card> store(
//			@RequestParam(value="queryVo", required =false)CardQueryVo queryVo, @RequestParam(value="page", required =false) PageVo pageVo, 
			HttpServletRequest request){
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = (String) params.nextElement();
			System.out.println(">>>>>>>>>>>>>");
			System.out.println(param + ":" + request.getParameter(param));
		}
		CardQueryVo queryVo = new CardQueryVo();
		return this.cardLogic.findPage(queryVo, new PageRequest(Integer.parseInt(request.getParameter("page")) - 1, Integer.parseInt(request.getParameter("limit"))));
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public ResponseVo update(List<Card> cards){
		for (Card card : cards) {
			this.cardLogic.update(card);
		}
		return ResponseVo.getSuccessResponse();
	}
}
