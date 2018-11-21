package com.mvc.board.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.mvc.board.dto.InformationDto;
import com.mvc.board.dto.PagingDto;
import com.mvc.board.service.WebGameService;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "WebGameService")
	private WebGameService webGameService;

	@RequestMapping("/")
	public String home() {
		log.debug("logback setting success!");
		return "home";
	}

	//게시판
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request, HttpSession session) throws Exception {

		// 페이징
		int first = 1;
		int currentPageNo = 1;
		int maxPost = 5;
		if (request.getParameter("pages") != null)
			currentPageNo = Integer.parseInt(request.getParameter("pages"));

		PagingDto pagingDto = new PagingDto(currentPageNo, maxPost);

		int offset = (pagingDto.getCurrentPageNo() - 1) * pagingDto.getMaxPost();

		Map<String, Object> map = webGameService.getBoardList(offset, pagingDto.getMaxPost());

		int count = webGameService.count();

		pagingDto.setNumberOfRecords(count);
		pagingDto.setReset(first);
		pagingDto.makePaging();

		model.addAttribute("page", map.get("list"));
		model.addAttribute("paging", pagingDto);
		
		return "list";
	}

	//회원가입
	@RequestMapping(value = "/sign_up", method = RequestMethod.POST)
	public String sign_up(@ModelAttribute("dto") InformationDto dto, HttpSession session, Model model) throws NoSuchAlgorithmException {

		webGameService.sign_up(dto, session);

		return "redirect:list";
	}

	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, Model model, @ModelAttribute("dto") InformationDto dto)
			throws NoSuchAlgorithmException {

		ModelAndView mav = new ModelAndView();

		boolean result = webGameService.login(dto, session);

		if (result == true) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("home");
			mav.addObject("msg", "fail");
		}

		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.getAttribute("id");
		webGameService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list");
		return mav;
	}

	// 회원가입 페이지
	@RequestMapping(value = "/signup_view")
	public String signup_view(@ModelAttribute("dto") InformationDto dto) {

		return "signup_view";
	}



}
