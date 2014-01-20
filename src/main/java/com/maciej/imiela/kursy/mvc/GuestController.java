/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.mvc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maciej.imiela.kursy.domain.ContactMessage;
import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.service.MyService;

/**
 * 
 * @author Maciej
 */
@Controller
public class GuestController {
	public static final String SUCCES_MESSAGE = "Message was sent!";
	public static final String FAIL_MESSAGE = "Message wasn't sent due to unexpected error, please try again!";

	private MyService service;
	private MailSender mailSender;
	private static final Logger logger = LoggerFactory
			.getLogger(GuestController.class);

	public GuestController(MyService service, MailSender mailSender) {
		this.service = service;
		this.mailSender = mailSender;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String showHomePage(
			@RequestParam(value = "message", required = false, defaultValue = "") String message,
			Model model) {
		User u = service.getUser(1);
		logger.info(message);
		model.addAttribute("message", message);
		model.addAttribute("user", u);
		logger.info("{}.", u);
		return "index";
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String createNewUser(Model model) {
		model.addAttribute("contactMessage", new ContactMessage());
		return "contact";
	}
        
        @RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public String pageUnderConstruction(Model model) {
		return "error";
	}
        
        @RequestMapping(value = { "/error/404" }, method = RequestMethod.GET)
	public String pageNotFound(Model model) {
		return "error/404";
	}
        
        @RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String displayAbout(Model model) {
		return "about";
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
	public String saveNewUser(@Valid ContactMessage contactMessage,
			BindingResult bResult) {
		if (bResult.hasErrors()) {
			return "contact";
		}

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("maciej.imiela@gmail.com");
		msg.setText(contactMessage.getMessage());
		msg.setSubject("Please contact me, as soon as you can: "
				+ contactMessage.getEmail());
		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			// log it and go on
			logger.error(ex.getMessage());
			return "redirect:/home?message=" + FAIL_MESSAGE;
		}
		return "redirect:/home?message=" + SUCCES_MESSAGE;
	}
        
        @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String displayLogInForm(Model model) {
		return "login";
	}
}
