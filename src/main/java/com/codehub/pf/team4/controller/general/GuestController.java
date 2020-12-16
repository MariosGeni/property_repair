package com.codehub.pf.team4.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GuestController {

    @GetMapping(value = "")
    public String guestPage(){
        return "user/guest";
    }

    @PostMapping(value = "")
    public String guestPagetoLogin(){
        return "/user/login";
    }

}
