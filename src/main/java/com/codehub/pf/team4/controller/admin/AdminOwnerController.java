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

import static com.codehub.pf.team4.utils.GlobalAttributes.ERROR_MESSAGE;

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
        // --- search code here --- //
        Optional<UserModel> owner = Optional.empty();

        if (!afm.equals("")) owner = userService.findUserByAfm(afm);
        else if (!email.equals(""))  owner = userService.findUserByEmail(email);
        System.out.println("I work");
        model.addAttribute(OWNER, owner.orElse(null));
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

        model.addAttribute(USER_FORM, new UserForm());
        model.addAttribute(USER_HOUSE_TYPE, HouseType.values());
        model.addAttribute(OWNER, theOwner.orElse(null));

        return "pages/admin-edit-owners-view";
    }

    @PostMapping("/owners/create")
    public String postAdminOwner(Model model, @Valid @ModelAttribute(USER_FORM) UserForm userForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during update");
            return "pages/admin-edit-owners-view";
        }

        Optional<UserModel> theOwner = userService.updateUser(userForm);
        if(theOwner.isEmpty()) return "pages/admin-edit-owners-view";
        return "redirect:/admin/owners/" + theOwner.get().getId(); // redirect to updated owner
    }

    @PostMapping("owners/delete/{id}")
    public String deleteAdminOwner(@PathVariable("id") Long id) {
        System.out.println(userService.deleteById(id));
        return "redirect:/admin/owners";
    }
}