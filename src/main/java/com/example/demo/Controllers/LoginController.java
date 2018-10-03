package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

//    @PostMapping
//    public String login(Users user,
//                        Model model)
//    {
//        Users users = userService.login(user);
//        if (users != null) {
//            model.addAttribute("users", users);
//        }else {
//            model.addAttribute("users","Can't be logged");
//        }
//        return "redirect:/hello";
//    }

}
