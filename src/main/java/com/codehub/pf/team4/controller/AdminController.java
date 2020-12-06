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
    UserService userService;

    @Autowired
    RepairService repairService;

    @GetMapping(value = "")
    @ResponseBody
    public String getAdminHome() {
        return "admin-home-view";
    }

    @GetMapping(value = "/owners")
    @ResponseBody
    public String getAdminOwnersPage() {
        // --- owners showcase here --- //
        return "admin-owners-view";
    }

    @GetMapping(value = "/owners/search") // Search 'owner-user' by 'afm/email' queryString
    @ResponseBody
    public String getAdminSearchOwnerPage(@RequestParam(value = "afm", defaultValue = "") String afm,
                                          @RequestParam(value = "email", defaultValue = "") String email) {
        // --- search code here --- //
        return "admin-owners-view";
    }

    @GetMapping(value = "/owners/edit/{id}") // Edit owner by its id
    @ResponseBody
    public String getAdminEditOwnersPage(@PathVariable("id") Long id, Model model) {
        Optional<User> theOwner = userService.findUserById(id);

        theOwner.ifPresent(owner -> { // if owner not null add to model
            model.addAttribute("owner", owner);
        });

        return "edit-owners-view";
    }

    @GetMapping(value = "/repairs")
    @ResponseBody
    public String getAdminRepairsPage() {
        // --- repairs showcase here --- //
        return "admin-repairs-view";
    }

    @GetMapping(value = "/repairs/search") // Search 'repairs/user' by 'date' queryString
    @ResponseBody
    public String getAdminSearchRepairPage(@RequestParam(value = "date", defaultValue = "") String date) {
        // --- search code here --- //
        return "search-repair-view";
    }

    @GetMapping(value = "/repairs/edit/{id}") // Edit repair by its id
    @ResponseBody
    public String getAdminEditRepairsPage(@PathVariable("id") Long id, Model model) {
        Optional<Repair> theRepair = repairService.getRepairById(id);

        theRepair.ifPresent(repair -> { // if repair not null add to model
            model.addAttribute("repair", repair);
        });

        return "edit-repair-view";
    }
}
