package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class RepairController {

    private final String REPAIR = "repair";
    private final String REPAIRS = "repair";
    private final String IS_PRESENT = "isPresent";

    @Autowired
    UserService userService;

    @Autowired
    RepairService repairService;

    // *************************************************** //
    // ======================== REPAIRS ================== //
    // *************************************************** //

    @GetMapping(value = "repairs")
    public String getAdminRepairsPage(Model model) {
        // --- repairs showcase here --- //
        model.addAttribute(REPAIRS, repairService.getAllRepairs());
        return "admin-repairs-view";
    }

    @GetMapping(value = "repairs/{id}")
    public String getAdminRepairPage(Model model, @PathVariable("id") Long id) {
        // --- repairs showcase here --- //
        model.addAttribute(REPAIR, repairService.getRepairById(id));
        return "admin-repair-view";
    }

    @GetMapping(value = "repairs/search") // Search 'repairs/user' by 'date' queryString
    public String getAdminSearchRepairPage(Model model, @RequestParam(value = "afm", defaultValue = "") String afm,
                                           @RequestParam(value = "date", defaultValue = "") String date) {
        // --- search code here --- //
        List<Repair> repairs = new ArrayList();

        if(!afm.equals("")) repairs = userService.getRepairsByUserAfm(afm);
        else if(!date.equals(""))  repairs = repairService.getRepairsByDate(date);

        model.addAttribute(REPAIRS, repairs);
        model.addAttribute(IS_PRESENT, repairs.size() > 0);
        return "admin-search-repairs-view";
    }

    @GetMapping(value = "repairs/edit/{id}") // Edit repair by its id
    public String getAdminEditRepairsPage(@PathVariable("id") Long id, Model model) {
        Optional<Repair> theRepair = repairService.getRepairById(id);

        model.addAttribute(REPAIR, theRepair.orElse(null));
        model.addAttribute(IS_PRESENT, theRepair.isPresent());

        return "admin-edit-repairs-view";
    }



    @PostMapping("repairs")
    public String postRepair(@RequestBody Repair repair, Model model) {
        // --- create code here --- //
        Optional<Repair> newRepair = repairService.postRepair(repair);

        if(newRepair.isEmpty()) return "redirect:/admin/repairs"; // if repairs not found redirect to repairs

        return "redirect:/admin/repairs/" + newRepair.get().getId();
    }

    @PutMapping(value = "repairs/{id}") // Edit repair by its id
    public String putRepairEditOwnersPage(@RequestBody Repair repair, Model model) {
        Optional<Repair> theRepair = repairService.updateRepair(repair);

        if(theRepair.isEmpty()) return "redirect:/admin/repairs"; // if repairs not found redirect to repairs

        return "redirect:/admin/repairs/" + theRepair.get().getId();
    }

    @DeleteMapping(value = "repairs/{id}")
    public String deleteRepair(@PathVariable("id") Long id) {
        repairService.deleteRepairById(id);
        return "redirect:/admin/repairs";
    }
}
