package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

@Autowired
public UserService userService;

//private Users currentUser= userService.findUser()
    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";

    }

    @PostMapping("/profile")
    public String profilepost( @AuthenticationPrincipal Users users,
                              @RequestParam String email,
                              @RequestParam String password,
                              @RequestParam String newpassword,
                              @RequestParam String confirm,
                              Model model) {

        userService.updateProfile(users, password, confirm, model, email, newpassword);




            return "profile";
        }


    }