package com.codehub.pf.team4.Property_Repairs.controller;

import com.codehub.pf.team4.Property_Repairs.Tables.Repair;
import com.codehub.pf.team4.Property_Repairs.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("username", "Niazi");
        return "hello";
    }

    @GetMapping("repair")
    @ResponseBody
    public List<Repair> getRepairs() {
        return repairRepository.findAll();
    }
}
