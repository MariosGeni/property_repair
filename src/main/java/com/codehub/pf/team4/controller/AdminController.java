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

    // *************************************************** //
    // ======================== OWNERS ================== //
    // *************************************************** //

    @GetMapping(value = {"", "home"})
    public String getAdminHome(Model model) throws Exception{
        model.addAttribute("activeRepairs", repairService.getOngoingRepairsOfTheDay());
        return "admin-home-view";
    }

    @GetMapping(value = "/owners")
    public String getAdminOwnersPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                     @RequestParam(value = "email", defaultValue = "") String email) {
        // --- owners showcase here --- //
        model.addAttribute("owners", userService.getAllUsers());
        return "admin-owners-view";
    }

    @PostMapping("/owners")
    public String postAdminOwner(@RequestBody User owner, Model model) {
        // --- create code here --- //
        User newOwner = userService.addUser(owner);
        model.addAttribute("owner", newOwner);
        model.addAttribute("isPresent", newOwner != null);

        return "admin-search-owners-view";
    }

    @GetMapping(value = "/owners/search") // Search 'owner-user' by 'afm/email' queryString
    public String getAdminSearchOwnerPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm, @RequestParam(value = "email", defaultValue = "") String email) {
        // --- search code here --- //
        Optional<User> owner = Optional.empty();
        if(!afm.equals("")) {
            owner = userService.findUserByAfm(afm);
            model.addAttribute("owner", owner);
            owner = userService.findUserByEmail(email);
        }

        model.addAttribute("owner", owner);
        model.addAttribute("isPresent", owner.isPresent());
        return "admin-search-owners-view";
    }

    @GetMapping(value = "/owners/edit/{id}") // Edit owner by its id
    public String getAdminEditOwnersPage(@PathVariable("id") Long id, Model model) {
        Optional<User> theOwner = userService.findUserById(id);

        model.addAttribute("owner", theOwner.orElse(null));
        model.addAttribute("isPresent", theOwner.isPresent());

        return "admin-edit-owners-view";
    }

    @RequestMapping(value = "/owners/edit/{id}", method = RequestMethod.PUT) // Edit owner by its id
    public String putAdminEditOwnersPage(@RequestBody User owner, Model model) {
        Optional<User> theOwner = userService.updateUser(owner);

        model.addAttribute("owner", theOwner.orElse(null));
        model.addAttribute("isPresent", theOwner.isPresent());

        return "admin-search-owners-view";
    }

    @RequestMapping("owners/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "admin-owners-view";
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
