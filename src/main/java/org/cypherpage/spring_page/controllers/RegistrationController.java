package org.cypherpage.spring_page.controllers;

import org.cypherpage.spring_page.dto.RegistrationDtoResponse;
import org.cypherpage.spring_page.model.Role;
import org.cypherpage.spring_page.model.User;
import org.cypherpage.spring_page.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public String getPage(Model model) {
        RegistrationDtoResponse registrationDtoResponse = new RegistrationDtoResponse();
        model.addAttribute("registerForm", registrationDtoResponse);
        return "registration";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("registerForm") RegistrationDtoResponse response, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (userRepo.findByLogin(response.getLogin()) != null) {
            model.addAttribute("errorMessage", "данный логин уже используется");
            return "registration";
        }
        User user = response.createUser();
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }

}
