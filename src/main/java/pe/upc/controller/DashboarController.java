package pe.upc.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboarController {

    @GetMapping(value = "dashboard")
    public String dashboard() {
        return "dashboard/dashboard";
    }

}
