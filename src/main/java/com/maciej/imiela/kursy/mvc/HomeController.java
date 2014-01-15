/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.service.MyService;

/**
 * 
 * @author Maciej
 */
@Controller
public class HomeController {

	private MyService service;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public HomeController(MyService service) {
		this.service = service;
	}

	@RequestMapping(value = { "/", "/home", "index" }, method = RequestMethod.GET)
	public String showHomePage(Model model) {
		User u = service.getUser(1);
		model.addAttribute("user", u);
		logger.info("{}.", u);
		return "index";
	}
	// <start id="spittlesPerPage"/>
	// public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	//
	// private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;
	//
	// public void setSpittlesPerPage(int spittlesPerPage) {
	// this.spittlesPerPage = spittlesPerPage;
	// }
	//
	// public int getSpittlesPerPage() {
	// return spittlesPerPage;
	// }
	// <end id="spittlesPerPage"/>
}
