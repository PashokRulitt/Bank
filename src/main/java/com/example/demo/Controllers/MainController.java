package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.domens.User;
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

//private User currentUser= userService.findUser()
    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";

    }

    @PostMapping("/profile")
    public String profilepost(
                                @AuthenticationPrincipal User user,
                                @RequestParam String email,
                                @RequestParam String oldpassword,
                                @RequestParam String newpassword,
                                @RequestParam String confirm,
                              Model model) {

        userService.updateProfile(user, oldpassword, confirm, model, email, newpassword);




            return "profile";
        }


    }