package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrController {

    @GetMapping("registration")
    public String add(@RequestParam String email,
                      @RequestParam String password,
                      @RequestParam String confirm)
    {
        return "registration";
    }

}
