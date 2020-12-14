package com.codehub.pf.team4.controller.admin.rest.RestAdminOwnerController;

import com.codehub.pf.team4.repository.UserRepository;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class RestAdminOwnerController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("owner-search")
    public Map<String, Object> getOwnerSearch(HttpServletResponse response, @RequestParam("value") String value) {
        List<Map<String, Object>> results = userRepository.findUserByFieldValue(value);
        System.out.println(results.toString());
        return new HashMap<>() {{ put("data", results); }};
    }
}
