package com.example.demo.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.validation.constraints.Email;
import java.awt.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepo userRepo;




    public Users addUser(UserDTO userDTO){

        if (userRepo.findByUsername(userDTO.getUsername()) != null && userDTO.getPassword().equals(userDTO.getPassword2())) {

//            userDTO.setPassword(userDTO.getPassword());
            return userRepo.save(new Users (userDTO));


        }

        return null;
    }
    private boolean editUsername(Users users, String username){
        if(StringUtils.isEmpty(username)){
            return  false;
        }else{
            users.setUsername(username);
            return  true;
        }
    }
    private boolean editPassword(Users users,String oldpassword,
                                String newpassword,
                                String repeatpassword   )
    {
        if(StringUtils.isEmpty(oldpassword) || StringUtils.isEmpty(newpassword) || StringUtils.isEmpty(repeatpassword)  ){
            return false;
        }
        boolean isNewPassword = (!StringUtils.isEmpty(newpassword) && newpassword.equals(repeatpassword));
        boolean isOldPassword = (oldpassword.equals(users.getPassword()));
        if(isNewPassword &&  isOldPassword){
            users.setPassword(newpassword);
            return true;
        }else {
            return  false;
        }
    }

    public void updateProfile(Users users,
                              String newpassword,
                              String repeatpassword,
                              Model model,
                              String username)
    {
        if(!editUsername(users, username)){
            model.addAttribute("username","Can't change name");
        }

        if (editPassword(users, username,newpassword,repeatpassword)){
            model.addAttribute("password","Success");
        }else {
            model.addAttribute("password","Error");
        }
        userRepo.save(users);

    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(user);
        if (users == null) {
            throw new UsernameNotFoundException("est uje");
        }

        return users;
    }

}
