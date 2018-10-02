package com.example.demo.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;


    public User addUser(UserDTO userDTO){
        userRepo.findByEmail(userDTO.getEmail()).isEmpty() && userDTO.getPassword().equals(userDTO.getPassword2())

        if (userRepo.findByEmail(userDTO.getEmail()).isEmpty() && userDTO.getPassword().equals(userDTO.getPassword2())) {

//            userDTO.setPassword(userDTO.getPassword());
            return userRepo.save(new User(userDTO));

        }

        return null;
    }
    public User login(User user){
        if(userRepo.findByEmail(user.getEmail())!= null &&
                userRepo.findByPassword(user.getPassword()).equals(user.getPassword())  ) {
            return user;
        }else{
            return null;
        }

    }
}
