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

//        private boolean checkEmail(){
//        boolean isOk
//            userRepo.findSuchEmail(userRepo);
//        }
    private boolean editEmail(Users users, String email){
        if(StringUtils.isEmpty(email) ){
            return  false;
        }else{
            String userEmail = users.getEmail();
            boolean isEmailChanged = (email != null && !email.equals(userEmail) || userEmail !=null && !userEmail.equals(email));
            if(isEmailChanged) {
                users.setEmail(email);
                return true;
            } else {return false;}
        }
    }
    private boolean editPassword(Users users,String oldpassword,
                                String newpassword,
                                String confirm   )
    {
        if(StringUtils.isEmpty(oldpassword) || StringUtils.isEmpty(newpassword) || StringUtils.isEmpty(confirm )){
            return false;
        }
        boolean isNewPassword = (!StringUtils.isEmpty(newpassword) && newpassword.equals(confirm));
        boolean checkPassword = passwordEncoder.matches(oldpassword,users.getPassword());
        if(isNewPassword &&  checkPassword){
            users.setPassword(passwordEncoder.encode(newpassword));
            return true;
        }else {
            return  false;
        }
    }

    public void updateProfile(Users users,
                              String oldpassword,
                              String confirm,
                              Model model,
                              String email,
                              String newpassword)
    {
        if(!editEmail(users, email)){
            model.addAttribute("emailError","Can't change email");
        }

        if (editPassword(users,oldpassword,newpassword,confirm)){
            model.addAttribute("passwordSuccess","Success");
        }else {
            model.addAttribute("passwordError","Error changing password");


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
