package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class OwnerController {

    private final String OWNER = "owner";
    private final String IS_PRESENT = "isPresent";

    @Autowired
    UserService userService;

    @Autowired
    RepairService repairService;

    // *************************************************** //
    // ======================== OWNERS ================== //
    // *************************************************** //

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
        model.addAttribute(OWNER, newOwner);
        model.addAttribute(IS_PRESENT, newOwner != null);

        return "admin-search-owners-view";
    }

    @GetMapping(value = "/owners/search") // Search 'owner-user' by 'afm/email' queryString
    public String getAdminSearchOwnerPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                          @RequestParam(value = "email", defaultValue = "") String email) {
        // --- search code here --- //
        Optional<User> owner = Optional.empty();

        if(!afm.equals("")) owner = userService.findUserByAfm(afm);
         else if(!email.equals(""))  owner = userService.findUserByEmail(email);

        model.addAttribute(OWNER, owner);
        model.addAttribute(IS_PRESENT, owner.isPresent());
        return "admin-search-owners-view";
    }

    @GetMapping(value = "/owners/edit/{id}") // Edit owner by its id
    public String getAdminEditOwnersPage(@PathVariable("id") Long id, Model model) {
        Optional<User> theOwner = userService.findUserById(id);

        model.addAttribute(OWNER, theOwner.orElse(null));
        model.addAttribute(IS_PRESENT, theOwner.isPresent());

        return "admin-edit-owners-view";
    }

    @RequestMapping(value = "/owners/edit/{id}", method = RequestMethod.PUT) // Edit owner by its id
    public String putAdminEditOwnersPage(@RequestBody User owner, Model model) {
        Optional<User> theOwner = userService.updateUser(owner);

        model.addAttribute(OWNER, theOwner.orElse(null));
        model.addAttribute(IS_PRESENT, theOwner.isPresent());

        return "admin-search-owners-view";
    }

    @RequestMapping("owners/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "admin-owners-view";
    }
}