package com.example.demo.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import javax.validation.constraints.Email;
import java.awt.*;

public class UserService {
    @Autowired
    public UserRepo userRepo;

    private Users addUser(UserDTO userDTO){

        if (userRepo.findByEmail(userDTO.getEmail()).isEmpty() && userDTO.getPassword().equals(userDTO.getPassword2())) {

            userDTO.setPassword(userDTO.getPassword());
            return userRepo.save(new Users (userDTO));


        }

        return null;
    }
}
