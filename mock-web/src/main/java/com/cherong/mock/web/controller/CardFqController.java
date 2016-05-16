package com.cherong.mock.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.vo.CardFqQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.bank.logic.CardFqLogic;
import com.cherong.mock.web.vo.ResponseVo;
import com.cherong.mock.web.vo.SelectVo;

/**
 * Description: 分期action
 * Auth:Paris
 * Date:May 12, 2016
**/
@Controller
@RequestMapping(value = "cardFq")
public class CardFqController {
	
	@Resource
	private CardFqLogic cardFqLogic;

	/**
	 * 进入卡片分期页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "")
	public String cardFq(Model model, @RequestParam(required=false)String mdcardno,HttpServletRequest request){
		model.addAttribute("mdcardno", mdcardno);
		return "cardFq/cardFq";
	}
	
	/**
	 * 获取卡片分期store
	 * @param queryVo
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "store")
	public Pagination<CardFq> store(HttpServletRequest request){
		CardFqQueryVo queryVo = new CardFqQueryVo();
		if (StringUtils.isNotEmpty(request.getParameter("mdcardno"))) {
			queryVo.setMdcardno(request.getParameter("mdcardno").trim());
		}
		int pageNum = Integer.parseInt(request.getParameter("page"));
		if (pageNum > 0) {
			pageNum -- ;
		}
		return this.cardFqLogic.findPage(queryVo, new PageRequest(pageNum, Integer.parseInt(request.getParameter("limit"))));
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public ResponseVo update(CardFq cardFq){
		this.cardFqLogic.update(cardFq);
		return ResponseVo.getSuccessResponse();
	}
	
	@ResponseBody
	@RequestMapping(value = "mdcardno")
	public List<SelectVo> mdcardno(String query,HttpServletRequest request){
		return this.cardFqLogic.findMdcardnoLike(query.trim() + "%");
	}
}
