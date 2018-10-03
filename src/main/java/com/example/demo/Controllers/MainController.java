package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

@Autowired
public UserService userService;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @PostMapping("/profile")
    public String profilepost(@RequestParam String username,
                              @RequestParam String oldpassword,
                              @RequestParam String newpassword,
                              @RequestParam String repeatpassword,
                              Model model)
{


//        userService.updateProfile(username,oldpassword,newpassword,repeatpassword,);

       return "profile" ;
}

}
