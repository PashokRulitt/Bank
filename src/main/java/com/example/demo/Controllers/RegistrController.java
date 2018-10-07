package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrController {

@Autowired
public UserService userService;

    @RequestMapping( value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String add(UserDTO userDTO, Model model) throws InterruptedException {
        Users users = userService.addUser(userDTO);
        if (users != null) {
            model.addAttribute("users", users);
        }else {
            model.addAttribute("users","Error");
        }

        return "redirect:/login";
    }

}
