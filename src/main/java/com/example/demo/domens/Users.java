package com.example.demo.domens;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "username")
    @NotBlank(message = "Can't be empty")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "Can't be empty")
    private  String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email")
    @Email
    @NotBlank(message = "Can't be empty")
    private String email;

//    @Column(name = "accounts")
//    private Accounts account;

}
