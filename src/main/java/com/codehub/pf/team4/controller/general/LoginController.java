package com.codehub.pf.team4.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value = "")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping(value = "/admin")
    public String loginConfirmation(){
            return "redirect:/admin";
    }

    @GetMapping(value = "/")
    public String loginBack(){
        return "redirect:";
    }

}
