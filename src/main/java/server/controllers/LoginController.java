package server.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import server.dto.RegistrationDtoResponse;
import server.dto.UserAuthorizationDtoResponse;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/login", "/"})
public class LoginController {

    @Value("${welcome.message}")
    private String message;

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
    public Object authorization(@Valid @ModelAttribute("authorization") UserAuthorizationDtoResponse response, BindingResult result){
        if(result.hasErrors()){
            return "login";
        }
        return "well done!";
    }

}
