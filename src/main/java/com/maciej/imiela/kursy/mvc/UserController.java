package com.maciej.imiela.kursy.mvc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.service.MyService;

@Controller
@RequestMapping("/users")
public class UserController {
	private MyService service;
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	public UserController(MyService service) {
		this.service = service;
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public String userDetails(@RequestParam("id") Long userID, Model model) {
		User u = service.getUser(userID);
		model.addAttribute("user", u);
		logger.info("{}.", u);
		return "users/details";
	}

//	@RequestMapping(method = RequestMethod.GET, params = "new")
//	public String createNewUser(Model model) {
//		model.addAttribute("user", new User());
//		return "users/edit";
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public String saveNewUser(@Valid User user, BindingResult bResult) {
//		if (bResult.hasErrors()) {
//			return "users/edit";
//		}
//		service.saveUser(user);
//		return "redirect:/users/user?id=" + user.getId();
//	}
}
