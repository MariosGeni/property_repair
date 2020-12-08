package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class RepairController {

    @Autowired
    UserService userService;

    @Autowired
    RepairService repairService;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("username", "Niazi");
        return "hello";
    }

    @GetMapping
    @ResponseBody
    public List<Repair> getRepairs() {
        return userService.getRepairsByUserAfm(123456789);
    }

    @GetMapping("repairs")
    @ResponseBody
    public List<Repair> getAllRepairs() {
        return repairService.getAllRepairs();
    }


    // *************************************************** //
    // ======================== REPAIRS ================== //
    // *************************************************** //

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
