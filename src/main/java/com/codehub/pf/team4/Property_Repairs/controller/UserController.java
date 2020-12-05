package com.codehub.pf.team4.Property_Repairs.controller;

import com.codehub.pf.team4.Property_Repairs.Tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserController userRepository;

    @GetMapping("hello")
    public String hello(Model model) {
        //model.addAttribute("username", "someone");
        return "hello";
    }

    @GetMapping("user")
    @ResponseBody
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
