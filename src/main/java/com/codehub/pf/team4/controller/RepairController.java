package com.codehub.pf.team4.controller;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("username", "Niazi");
        return "hello";
    }

    @GetMapping("repair")
    @ResponseBody
    public List<Repair> getRepairs() {
        return userRepository.findRepairsByAfm(123456789);
    }

    @GetMapping("repairsOfTheDay")
    @ResponseBody
    public List<Repair> getRepairsOfTheDay() throws Exception {
        return repairRepository.findByDateIsBetweenAndStateEquals(start(), end(), State.ONGOING);
    }

    private Timestamp start() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = theDay() + " 09:00:00";
        return getFinalTime(sdf, today);
    }

    private Timestamp end() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = theDay() + " 23:59:59";
        return  getFinalTime(sdf, today);
    }

    private String theDay() {
        return new Timestamp(new Date().getTime()).toString().substring(0, 10);
    }

    private Timestamp getFinalTime(SimpleDateFormat sdf, String today) throws Exception {
        return new Timestamp(sdf.parse(today).getTime());
    }
}
