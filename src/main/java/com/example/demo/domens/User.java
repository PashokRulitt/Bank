package com.example.demo.domens;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Builder
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "users_tbl")//prefix tbl
public class User {

//    public User(UserDTO userDTO){
//        setEmail(userDTO.getEmail());
//        setPassword(userDTO.getPassword());
//    }
// not right
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String userName;
//    userName camel case
//user_name венгерская анотация
    @Column(name = "password")
    private  String password;

    @Column(name = "active")
    private boolean active;

    @Email
    @Column(name = "email")
    private String email;






//    @Column(name = "accounts")
//    private Accounts account;



    }

