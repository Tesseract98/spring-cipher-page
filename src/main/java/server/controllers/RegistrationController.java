package server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.dto.RegistrationDtoResponse;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String getPage(Model model){
        RegistrationDtoResponse response = new RegistrationDtoResponse();
        model.addAttribute("registerForm", response);
        return "register/registration";
    }

    @PostMapping
    @ResponseBody
    public RegistrationDtoResponse registerUser(Model model, @ModelAttribute("registerForm")RegistrationDtoResponse response){
        return response;
//        return "redirect:/";
    }

}
