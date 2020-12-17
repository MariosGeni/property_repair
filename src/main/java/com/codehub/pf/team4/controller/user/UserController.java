package com.codehub.pf.team4.controller.user;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.repository.UserRepository;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.StatusProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @GetMapping("home")
    public String getHomePage(Model model) {
        model.addAttribute("repairs", userService.getRepairsByUserId(1L));
        model.addAttribute("userName", userService.findUserByEmail(StatusProvider.getLoggedInEmail()).get().getFirstName());
        return "pages/home";
    }
}
