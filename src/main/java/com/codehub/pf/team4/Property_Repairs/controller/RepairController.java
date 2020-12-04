package com.codehub.pf.team4.Property_Repairs.controller;

import com.codehub.pf.team4.Property_Repairs.Tables.Repair;
import com.codehub.pf.team4.Property_Repairs.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/repair")
    public List<Repair> repair() {
        return repairRepository.findAll();
    }
}
