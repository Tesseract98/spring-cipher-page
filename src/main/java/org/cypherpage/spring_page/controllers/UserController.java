package org.cypherpage.spring_page.controllers;

import org.cypherpage.spring_page.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sudo")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String printAllDB(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userTable";
    }

}
