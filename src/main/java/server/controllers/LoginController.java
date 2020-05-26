package server.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.dto.UserAuth;

@Controller
@RequestMapping(value = {"/login", "/"})
public class LoginController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping()
    public String login(){
        return "login/login";
    }


//    @ResponseBody
    @PostMapping()
    public UserAuth logIn(@RequestParam(value = "login") String login){
        return new UserAuth(login, "sudo");
    }

}
