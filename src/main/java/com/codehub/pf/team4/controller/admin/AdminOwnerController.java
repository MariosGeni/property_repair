package com.codehub.pf.team4.controller.admin;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.model.UserModel;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminOwnerController {

    private final String OWNER = "owner";
    private final String OWNERS = "owners";
    private final String IS_PRESENT = "isPresent";
    private final String USER_FORM = "userForm";

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder(USER_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    // *************************************************** //
    // ======================== OWNERS ================== //
    // *************************************************** //

    @GetMapping(value = "/owners")
    public String getAdminOwnersPage(Model model) {
        // --- owners showcase here --- //
        model.addAttribute(OWNERS, userService.getAllUsers());
        return "admin-owners-view";
    }

    @GetMapping(value = "/owners/{id}")
    public String getAdminOwnerPage(@PathVariable("id") Long id, Model model) {
        // --- owners showcase here --- //
        model.addAttribute("owners", userService.findUserById(id));
        return "admin-owner-view";
    }

    @GetMapping(value = "/owners/search") // Search 'owner-user' by 'afm/email' queryString
    public String getAdminSearchOwnerPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                          @RequestParam(value = "email", defaultValue = "") String email) {
        // --- search code here --- //
        List<UserModel> owner = new ArrayList<>();

        if(!afm.equals("")) owner = userService.findUserByAfm(afm);
        else if(!email.equals(""))  owner = userService.findUserByEmail(email);

        model.addAttribute(OWNER, owner);
        model.addAttribute(IS_PRESENT, owner.isPresent());
        return "admin-search-owners-view";
    }

    @GetMapping(value = "/owners/edit/{id}") // Edit owner by its id
    public String getAdminEditOwnersPage(@PathVariable("id") Long id, Model model) {
        Optional<UserModel> theOwner = userService.findUserById(id);

        if(theOwner.isEmpty()) return "redirect:/admin/owners"; //if user not found redirect him to admin owners page

        model.addAttribute(OWNER, theOwner.orElse(null));

        return "admin-edit-owners-view";
    }

    @PostMapping("/owners")
    public String postAdminOwner(@RequestBody User owner, Model model) {
        // --- create code here --- //
        Optional <UserModel> newOwner = userService.addUser(new UserForm());
        return "redirect:/admin/owners/" + newOwner.getId(); // redirect to created owner
    }

    @PutMapping("/owners/{id}") // Edit owner by its id
    public String putAdminEditOwnersPage(@RequestBody User owner, Model model) {
        Optional<UserModel> theOwner = userService.updateUser(new UserForm());

        if(theOwner.isEmpty()) return "redirect:/admin/owners"; //redirect to owners if owner not found

        return "redirect:/admin/owners/" + theOwner.get().getId(); // redirect to updated owner
    }

    @DeleteMapping("owners/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/owners";
    }
}