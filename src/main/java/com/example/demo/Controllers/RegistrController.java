package com.example.demo.Controllers;

import com.example.demo.Service.UserService;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrController {

private final UserService userService;

    public RegistrController(UserService userService) {
        this.userService = userService;
    }//@Autowired

    @RequestMapping( value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String add(UserDTO userDTO, Model model)
    {
        User user = userService.addUser(userDTO);
        if (user != null) {
            model.addAttribute("users", user);
        }else {
            model.addAttribute("users","Can't be created");
        }
        return "redirect:/login";
    }

}
