package com.codehub.pf.team4.controller.general;

import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.utils.GlobalAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value = "")
    public String loginPage(){
        return "user/login";
    }



    @PostMapping(value = "")
    public String loginConfirmation(){
            return "pages/admin-home-view";
    }

}
