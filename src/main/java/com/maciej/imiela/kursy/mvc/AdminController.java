/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.mvc;

import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.service.MyService;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private MyService service;
    private static final Logger logger = LoggerFactory
            .getLogger(AdminController.class);

    public AdminController(MyService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/users"})
    public String userDetails(Model model) {
        List<User> u = service.getAllUsers();
        model.addAttribute("users", u);
        logger.info(Arrays.toString(u.toArray()));
        return "admin/users";
    }
}
