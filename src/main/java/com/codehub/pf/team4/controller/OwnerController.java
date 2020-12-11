package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.form.UserForm;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import static com.codehub.pf.team4.utils.GlobalAttributes.ERROR_MESSAGE;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class OwnerController {

    private final String OWNER = "owner";
    private final String OWNERS = "owners";
    private final String IS_PRESENT = "isPresent";
    private static final String OWNERS_FORM = "booksForm";
    private static final String OWNERS_CATEGORIES = "booksCategories";

    @Autowired
    UserService userService;

    @Autowired
    RepairService repairService;

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

        if(theOwner.isEmpty()) return "redirect:/admin/owners"; //if user not found redirect him to admin owners page

        model.addAttribute(OWNER, theOwner.orElse(null));

        return "admin-edit-owners-view";
    }

    @PostMapping("/owners")
    public String postAdminOwner(@RequestBody User owner, Model model) {
        // --- create code here --- //
        User newOwner = userService.addUser(owner);
        return "redirect:/admin/owners/" + newOwner.getId(); // redirect to created owner
    }

    @PutMapping("/owners/{id}") // Edit owner by its id
    public String putAdminEditOwnersPage(@RequestBody User owner, Model model) {
        Optional<User> theOwner = userService.updateUser(owner);

        if(theOwner.isEmpty()) return "redirect:/admin/owners"; //redirect to owners if owner not found

        return "redirect:/admin/owners/" + theOwner.get().getId(); // redirect to updated owner
    }

    @DeleteMapping("owners/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/owners";
    }

    @GetMapping(value = "/owner/create")
    public String ownerCreation(Model model){
        model.addAttribute(OWNERS_FORM, new UserForm());
        model.addAttribute(OWNERS_CATEGORIES, HouseType.values());
        return "";
    }

    @PostMapping(value = "/owner/create")
    public String createOwner(Model model, @ModelAttribute(OWNERS_FORM) UserForm userForm,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute(ERROR_MESSAGE, "Oops an error occured");
            return "";
        }
        userService.createUser(userForm);
        return "redirect:/owners";
    }
}