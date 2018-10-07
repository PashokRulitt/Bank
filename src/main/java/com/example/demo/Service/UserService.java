package com.example.demo.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users addUser(UserDTO userDTO){
        if (userRepo.findByUsername(userDTO.getUsername()) == null &&
                userDTO.getPassword().equals(userDTO.getConfirm())) {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            return userRepo.save(new Users(userDTO));
        }

        return null;


        }
        public Users findUser(String username){

        return userRepo.findByUsername(username);
        }


    private boolean editEmail(Users users, String email){
        if(StringUtils.isEmpty(email)){
            return  false;
        }else{
            users.setEmail(email);
            return  true;
        }
    }
    private boolean editPassword(Users users,String password,
                                String newpassword,
                                String confirm   )
    {
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newpassword) || StringUtils.isEmpty(confirm)  ){
            return false;
        }
        boolean isNewPassword = (!StringUtils.isEmpty(newpassword) && newpassword.equals(confirm));
        boolean checkPassword = passwordEncoder.matches(password,users.getPassword());
        if(isNewPassword &&  checkPassword){
            users.setPassword(passwordEncoder.encode(newpassword));
            return true;
        }else {
            return  false;
        }
    }

    public void updateProfile(Users users,
                              String password,
                              String confirm,
                              Model model,
                              String email,
                              String newpassword)
    {
        if(!editEmail(users, email)){
            model.addAttribute("email","Can't change email");
        }

        if (editPassword(users,newpassword,password,confirm)){
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
