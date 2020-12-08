package com.codehub.pf.team4.controller;


import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RepairService repairService;

    // *************************************************** //
    // ======================== ADMIN ================== //
    // *************************************************** //

    @GetMapping(value = {"", "home"})
    public String getAdminHome(Model model) throws Exception{
        model.addAttribute("activeRepairs", repairService.getOngoingRepairsOfTheDay());
        return "admin-home-view";
    }
}
