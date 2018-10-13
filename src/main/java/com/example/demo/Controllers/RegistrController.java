package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RegistrController {

@Autowired
public UserService userService;




    @GetMapping("/recovery")
    public String recover(){
        return "recovery";
    }

    @PostMapping("/recovery")
    public String postRecover(@RequestParam String email, Model model) {
        if (StringUtils.isEmpty(email)) {
            model.addAttribute("emailRecoveryError", "Field is empty");
            return "recovery";
        } else {
//            Optional<User> userOptional = userService.findByEmail(email);
//             if (userOptional.isPresent()) {
                userService.passwordRecovery();//userOptional.get()
                model.addAttribute("SendMessageRecoveryWaring", "We send you a new password to current email address");
                return "redirect:/login";
//            } else {
//                model.addAttribute("SendMessageRecoveryError", "Email does't exist");
//                return "recovery";
            }

        }

//    }


    @RequestMapping( value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String add(UserDTO userDTO, Model model) throws InterruptedException {
        User user = userService.addUser(userDTO);
        if (user != null) {
            model.addAttribute("users", user);
//            model.addAttribute("registerSuccess", "Success");
            return "redirect:/login";
        }else {
//            model.addAttribute("registerError","Can't register ");
            return "/registration";
        }


    }

}
