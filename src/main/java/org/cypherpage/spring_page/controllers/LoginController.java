package org.cypherpage.spring_page.controllers;

import org.cypherpage.spring_page.dto.UserAuthorizationDtoResponse;
import org.cypherpage.spring_page.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/login", "/"})
public class LoginController {

    @Autowired
    UserRepository userRepo;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping()
    public String login(Model model){
        UserAuthorizationDtoResponse authorizationDtoResponse = new UserAuthorizationDtoResponse();
        model.addAttribute("authorization", authorizationDtoResponse);
        return "login";
    }

    @PostMapping()
//    @ResponseBody
    public Object authorization(@Valid @ModelAttribute("authorization") UserAuthorizationDtoResponse response, BindingResult result, Model model){
        if(result.hasErrors()){
            return "login";
        }
        if(userRepo.findByLoginAndPassword(response.getLogin(), response.getPassword()) == null){
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }
        return "well done!";
    }

}
