package com.codehub.pf.team4.controller.admin;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.GlobalAttributes;
import com.codehub.pf.team4.utils.validators.RepairValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminRepairController {

    private final String REPAIR = "repair";
    private final String REPAIRS = "repairs";
    private final String IS_PRESENT = "isPresent";
    private final String REPAIR_FORM = "repairForm";
    private final String STATE = "state";
    private final String REPAIR_TYPE = "repairType";

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @Autowired
    private RepairValidator repairValidator;

    @InitBinder(REPAIR_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(repairValidator);
    }


    // *************************************************** //
    // ======================= REPAIRS =================== //
    // *************************************************** //

    @GetMapping(value = "repairs")
    public String getAdminRepairsPage(Model model) {
        // --- repairs showcase here --- //
        model.addAttribute(REPAIRS, repairService.getAllRepairs());
        return "pages/admin-repairs-view";
    }

    @GetMapping(value = "repairs/{id}")
    public String getAdminRepairPage(Model model, @PathVariable("id") Long id) {
        // --- repairs showcase here --- //
        Optional<RepairModel> theRepair = repairService.getRepairById(id);
        if(theRepair.isEmpty()) return "redirect:/admin/repairs";

        model.addAttribute(REPAIR, theRepair.get());
        return "pages/admin-repair-view";
    }

    @GetMapping(value = "repairs/search") // Search 'repairs/user' by 'date' queryString
    public String getAdminSearchRepairPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                           @RequestParam(value = "date", defaultValue = "") String date) {
        // --- search code here --- //
        List<RepairModel> repairs = new ArrayList();
        if(!afm.equals("")) repairs = userService.getRepairsByUserAfm(afm);
        else if(!date.equals(""))  repairs = repairService.getRepairsByDate(date);

        model.addAttribute(REPAIRS, repairs);
        return "pages/admin-search-repairs-view";
    }
    @GetMapping(value = "/repairs/create")
    public String getAdminCreateRepairsPage(Model model){
        model.addAttribute(REPAIR_FORM, new RepairForm());
        model.addAttribute(REPAIR_TYPE, RepairType.values());
        model.addAttribute(STATE, State.values());
        return "pages/admin-create-repairs-view";
    }

    @GetMapping(value = "repairs/edit/{id}") // Edit repair by its id
    public String getAdminEditRepairsPage(@PathVariable("id") Long id, Model model) {
        Optional<RepairModel> theRepair = repairService.getRepairById(id);

        if(theRepair.isEmpty()) return "redirect:/admin/repairs";

        model.addAttribute(REPAIR, theRepair.orElse(null));
        model.addAttribute(IS_PRESENT, theRepair.isPresent());

        return "pages/admin-edit-repairs-view";
    }

    @PostMapping("repairs")
    public String postRepair(Model model, @Valid @ModelAttribute(REPAIR_FORM) RepairForm repairForm,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            return "pages/admin-edit-repairs-view";
        }

        Optional<RepairModel> newRepair = repairService.updateRepair(repairForm);
        if(newRepair.isEmpty()) return "pages/admin-edit-repairs-view";
        return "redirect:/admin/repairs/" + newRepair.get().getId();
    }
    @PostMapping("/repairs/create")
    public String postAdminOwner(Model model, @Valid @ModelAttribute(REPAIR_FORM) RepairForm repairForm,
                                 BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            model.addAttribute(REPAIR_TYPE, RepairType.values());
            model.addAttribute(STATE, State.values());

            return "pages/admin-create-repairs-view";
        }
        Optional<RepairModel> newRepair = repairService.addRepair(repairForm);
        if(newRepair.isEmpty()) return "pages/admin-create-owners-view";
        return "redirect:/admin/owners/" + newRepair.get().getId();
    }

    @PostMapping(value = "repairs/edit/{id}") // Edit repair by its id
    public String putRepairEditOwnersPage(Model model, @Valid @ModelAttribute(REPAIR_FORM) RepairForm repairForm,
                                          BindingResult bindingResult, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during update");
            return "pages/admin-edit-repairs-view";
        }

        Optional<RepairModel> theRepair = repairService.updateRepair(repairForm);
        if(theRepair.isEmpty()) return "pages/admin-edit-repairs-view";
        return "redirect:/admin/repairs/" + theRepair.get().getId();
    }

    @PostMapping(value = "repairs/delete/{id}")
    public String deleteRepair(@PathVariable("id") Long id, Model model) {
        if(!repairService.deleteRepairById(id)) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "The ID you submitted to delete does not exist");
        }
        return "redirect:/admin/repairs";
    }
}
