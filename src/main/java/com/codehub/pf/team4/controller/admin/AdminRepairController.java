package com.codehub.pf.team4.controller.admin;

import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.GlobalAttributes;
import com.codehub.pf.team4.utils.validators.RepairValidator;
import com.codehub.pf.team4.utils.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private final String STATE = "STATE";
    private final String REPAIR_TYPE = "REPAIR_TYPE";

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

    @GetMapping(value = "repairs")
    public String getAdminRepairsPage(Model model, @RequestParam Optional<Integer> page) {

        int realPage = 0;
        if(page.isPresent()) realPage = page.get() > 0? page.get() - 1 : 0;
        Page<RepairModel> repairModelsPaged = repairService.getAllAsPage(realPage);

        if(repairModelsPaged.isEmpty()) return "redirect:/admin/repairs";
        model.addAttribute(REPAIRS, repairModelsPaged);

        return "pages/admin-repairs-view";
    }

    @GetMapping(value = "repairs/{id}")
    public String getAdminRepairPage(Model model, @PathVariable("id") Long id) {

        Optional<RepairModel> theRepair = repairService.getRepairById(id);
        if(theRepair.isEmpty()) return "redirect:/admin/repairs";

        model.addAttribute(REPAIR, theRepair.get());
        return "pages/admin-repair-view";
    }

    @GetMapping(value = "repairs/search")
    public String getAdminSearchRepairPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                                        @RequestParam(value = "date", defaultValue = "") String date,
                                                        @RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                                        @RequestParam(value = "toDate", defaultValue = "") String toDate) {
        if (afm.isBlank() && date.isBlank() && fromDate.isBlank() && toDate.isBlank()) {
            model.addAttribute(GlobalAttributes.IS_EMPTY,false);
            return "pages/admin-search-repairs-view";
        }


        List<RepairModel> repairs = new ArrayList();
        if (!afm.isBlank()) {
            if(UserValidator.isValidAfm(afm))  repairs = userService.getRepairsByUserAfm(afm);
        } else if(!date.isBlank()) {
            if(RepairValidator.isValidDate(date)) repairs = repairService.getRepairsByDate(date);
        } else if (!fromDate.isBlank() && !toDate.isBlank()) {
            if(RepairValidator.isValidDate(fromDate) && RepairValidator.isValidDate(toDate)) {
                repairs = repairService.getRepairsByDate(fromDate, toDate);
            }
        }

        model.addAttribute(REPAIRS, repairs);
        model.addAttribute(GlobalAttributes.IS_EMPTY, repairs.isEmpty());

        return "pages/admin-search-repairs-view";
    }
    @GetMapping(value = "/repairs/create")
    public String getAdminCreateRepairsPage(Model model){
        model.addAttribute(REPAIR_FORM, new RepairForm());
        model.addAttribute(REPAIR_TYPE, RepairType.values());
        model.addAttribute(STATE, State.values());
        return "pages/admin-create-repairs-view";
    }

    @GetMapping(value = "repairs/edit/{id}")
    public String getAdminEditRepairsPage(@PathVariable("id") Long id, Model model) {
        Optional<RepairForm> theRepair = repairService.getRepairByIdAsForm(id);
        if (theRepair.isEmpty()) return "redirect:/admin/repairs";

        model.addAttribute(REPAIR_FORM, theRepair.get());
        model.addAttribute(REPAIR_TYPE, RepairType.values());
        model.addAttribute(STATE, State.values());
        model.addAttribute(IS_PRESENT, theRepair.isPresent());

        return "pages/admin-edit-repairs-view";
    }

    @PostMapping("/repairs/create")
    public String postAdminCreateRepair(Model model, @Valid @ModelAttribute(REPAIR_FORM) RepairForm repairForm,
                                 BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            model.addAttribute(REPAIR_TYPE, RepairType.values());
            model.addAttribute(STATE, State.values());

            return "pages/admin-create-repairs-view";
        }
        Optional<RepairModel> newRepair = repairService.addRepair(repairForm);
        if(newRepair.isEmpty()) return "pages/admin-create-repairs-view";
        return "redirect:/admin/repairs/" + newRepair.get().getId();
    }

    @PostMapping(value = "repairs/edit/{id}")
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
    public String deleteRepair(@PathVariable("id") Long id, Model model, @RequestParam Optional<Long> userId) {
        long theId = userId.isPresent()? userId.get() : -1;
        if(!repairService.deleteRepairById(id)) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "The ID you submitted to delete does not exist");
        }
        if(theId != -1) return "redirect:/admin/owners/" + theId;
        return "redirect:/admin/repairs";
    }
}