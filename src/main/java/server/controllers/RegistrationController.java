package server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import server.dto.RegistrationDtoResponse;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String getPage(Model model){
        RegistrationDtoResponse registrationDtoResponse = new RegistrationDtoResponse();
        model.addAttribute("registerForm", registrationDtoResponse);
        return "registration";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("registerForm")RegistrationDtoResponse response, BindingResult result){
        if(result.hasErrors()){
            return "registration";
        }
        return "redirect:/login";
    }

}
