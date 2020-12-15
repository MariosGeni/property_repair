package com.codehub.pf.team4.controller.admin;

import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.models.UserModel;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.GlobalAttributes;
import com.codehub.pf.team4.utils.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/admin")
public class AdminOwnerController {

    private final String OWNER = "owner";
    private final String OWNERS = "owners";
    private final String USER_FORM = "userForm";
    private final String USER_HOUSE_TYPE = "HOUSE_TYPE";

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
        List<UserModel> owners = userService.getAllUsers();
        model.addAttribute(OWNERS, owners);
        return "pages/admin-owners-view";
    }

    @GetMapping(value = "/owners/{id}")
    public String getAdminOwnerPage(@PathVariable("id") Long id, Model model) {
        // --- owners showcase here --- //
        Optional<UserModel> theUser = userService.findUserById(id);

        if(theUser.isEmpty()) return "redirect:/admin/owners";
        model.addAttribute(OWNER, theUser.get());
        return "pages/admin-owner-view";
    }

    @GetMapping(value = "/owners/search") // Search 'owner-user' by 'afm/email' queryString
    public String getAdminSearchOwnerPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                          @RequestParam(value = "email", defaultValue = "") String email) {

        if (afm.isBlank() && email.isBlank()) {
            model.addAttribute(GlobalAttributes.IS_EMPTY,false);
            return "pages/admin-search-owners-view";
        }

        // --- search code here --- //
        Optional<UserModel> owner = Optional.empty();

        if (!afm.equals("")) {
            Pattern  pattern = Pattern.compile("^[0-9]{9}$");
            if(pattern.matcher(afm).matches())  owner = userService.findUserByAfm(afm);
        }

        else if (!email.equals(""))  owner = userService.findUserByEmail(email);
        model.addAttribute(OWNER, owner.orElse(null));
        model.addAttribute(GlobalAttributes.IS_EMPTY, owner.isEmpty());

        return "pages/admin-search-owners-view";
    }

    @GetMapping(value = "/owners/create")
    public String getAdminCreateOwnerPage(Model model){
        model.addAttribute(USER_FORM, new UserForm());
        model.addAttribute(USER_HOUSE_TYPE, HouseType.values());
        return "pages/admin-create-owners-view";
    }

    @GetMapping(value = "/owners/edit/{id}") // Edit owner by its id
    public String getAdminEditOwnersPage(@PathVariable("id") Long id, Model model) {
        Optional<UserModel> theOwner = userService.findUserById(id);

        if(theOwner.isEmpty())
            return "redirect:/admin/owners"; //if user not found redirect him to admin owners page

        UserForm userForm = userService.findUserByIdAsUserForm(id).get();
        model.addAttribute(USER_FORM, userForm);
        //model.addAttribute(USER_FORM, userService.updateUserModel(theOwner));
        model.addAttribute(USER_HOUSE_TYPE, HouseType.values());

        return "pages/admin-edit-owners-view";
    }

    @PostMapping("/owners/create")
    public String postAdminOwner(Model model, @Valid @ModelAttribute(USER_FORM) UserForm userForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getModel());
            model.addAttribute(USER_FORM, userForm);
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            model.addAttribute(USER_HOUSE_TYPE, HouseType.values());
            return "pages/admin-create-owners-view";
        }

        Optional<UserModel> newUser = userService.addUser(userForm);
        if (newUser.isEmpty())
            return "pages/admin-create-owners-view";

        return "redirect:/admin/owners/" + newUser.get().getId();
    }

    @PostMapping("/owners/edit/{id}") // Edit owner by its id
    public String putAdminEditOwnersPage(Model model, @Valid @ModelAttribute(USER_FORM) UserForm userForm,
                                         BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(USER_FORM, userForm);
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            model.addAttribute(USER_HOUSE_TYPE, HouseType.values());
            return "pages/admin-edit-owners-view";
        }

        Optional<UserModel> theOwner = userService.updateUser(userForm);
        if (theOwner.isEmpty()) return "pages/admin-edit-owners-view";
        return "redirect:/admin/owners/" + theOwner.get().getId(); // redirect to updated owner
    }

    @PostMapping("owners/delete/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        System.out.println(userService.deleteById(id));
        return "redirect:/admin/owners";
    }
}