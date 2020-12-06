package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.Tables.Repair;
import com.codehub.pf.team4.Tables.User;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @GetMapping("home")
    @ResponseBody
    public List<Repair> getAdminHome() {
            return repairService.getAllRepairs();
        }

    @GetMapping("users")
    @ResponseBody
    public List<User> getUsers() {
            return userService.getAllUsers();
        }

    @GetMapping("repairs")
    @ResponseBody
    public List<Repair> getRepairs() {
            return repairService.getAllRepairs();
        }

}
