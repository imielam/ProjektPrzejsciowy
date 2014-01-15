/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.kursy.service.MyService;

/**
 * 
 * @author Maciej
 */
@Controller
public class HomeController {

	private MyService service;

	public HomeController(MyService service) {
		this.service = service;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		// model.put("spittles", service.getUser(1));
		return "info/about";
	}

	// <start id="spittlesPerPage"/>
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}
	// <end id="spittlesPerPage"/>
}
