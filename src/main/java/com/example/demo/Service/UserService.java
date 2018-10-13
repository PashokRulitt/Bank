package com.example.demo.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.UserDTO.UserDTO;
import com.example.demo.domens.User;
//import com.sun.xml.internal.ws.resources.SenderMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  EmailService emailService;

    public Optional<User> findByEmail (String email){
        return userRepo.findByEmail(email);
    }

    public User addUser(UserDTO userDTO){
        if (userRepo.findByUsername(userDTO.getUsername()) == null &&//tut we search in other way |||userRepo.findByUsername(username)
                userDTO.getPassword().equals(userDTO.getConfirm())) {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            return userRepo.save(new User(userDTO));
        }

        return null;

        }
        private void sendMessage( String user ,String message, String titleMessage){//User user,
//        if(!StringUtils.isEmpty(user.getEmail())){
         emailService.send(user,titleMessage,  message);// user.getEmail()
        }
//        }
        public void passwordRecovery(){//User user
//        if(user != null) {
//            if (!StringUtils.isEmpty(user.getEmail())) {
                String newpassword = UUID.randomUUID().toString().substring(24, 36);
//                user.setPassword(passwordEncoder.encode(newpassword));
//                userRepo.save(user);
                String message = String.format(
                        "Hi, %s! \n" +
                                "Here is your new password: %s ",
                     "kostya"   , newpassword);//user.getUsername()
                String titleMessage = "LNPO-bank(recovery password)";
                sendMessage("legkoy1973@gmail.com", message, titleMessage);


//            }
//        }else {
//            throw new NullPointerException();
//        }
        }

    private boolean editEmail(User user, String email){
        if(StringUtils.isEmpty(email) ){
            return  false;
        }else{
            String userEmail = user.getEmail();
            boolean isEmailChanged = (email != null && !email.equals(userEmail) || userEmail !=null && !userEmail.equals(email));
            if(isEmailChanged) {
                user.setEmail(email);
                return true;
            } else {return false;}
        }
    }
    private boolean editPassword(User user, String oldpassword,
                                 String newpassword,
                                 String confirm   )
    {
        if(StringUtils.isEmpty(oldpassword) || StringUtils.isEmpty(newpassword) || StringUtils.isEmpty(confirm )){
            return false;
        }
        boolean isNewPassword = (!StringUtils.isEmpty(newpassword) && newpassword.equals(confirm));
        boolean checkPassword = passwordEncoder.matches(oldpassword, user.getPassword());
        if(isNewPassword &&  checkPassword){
            user.setPassword(passwordEncoder.encode(newpassword));
            return true;
        }else {
            return  false;
        }
    }

    public void updateProfile(User user,
                              String oldpassword,
                              String confirm,
                              Model model,
                              String email,
                              String newpassword)
    {
        if(!editEmail(user, email)){
            model.addAttribute("emailError","Can't change email");
        }

        if (editPassword(user,oldpassword,newpassword,confirm)){
            model.addAttribute("passwordSuccess","Success");
        }else {
            model.addAttribute("passwordError","Error changing password");


        }
        userRepo.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        User users = userRepo.findByUsername(user);
        if (users == null) {
            throw new UsernameNotFoundException("est uje");
        }

        return users;
    }

}
