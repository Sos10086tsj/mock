package com.cherong.mock.web.controller;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import com.cherong.mock.web.vo.SelectVo;

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
	public Pagination<Card> store(HttpServletRequest request){
		CardQueryVo queryVo = new CardQueryVo();
		if (StringUtils.isNotEmpty(request.getParameter("mdcardno"))) {
			queryVo.setMdcardno(request.getParameter("mdcardno").trim());
		}
		int pageNum = Integer.parseInt(request.getParameter("page"));
		if (pageNum > 0) {
			pageNum -- ;
		}
		return this.cardLogic.findPage(queryVo, new PageRequest(pageNum, Integer.parseInt(request.getParameter("limit"))));
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public ResponseVo update(Card card){
		this.cardLogic.update(card);
		return ResponseVo.getSuccessResponse();
	}
	
	@ResponseBody
	@RequestMapping(value = "mdcardno")
	public List<SelectVo> mdcardno(String query,HttpServletRequest request){
		return this.cardLogic.findMdcardno(query.trim() + "%");
	}
}
