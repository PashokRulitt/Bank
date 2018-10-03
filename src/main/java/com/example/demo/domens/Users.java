package com.example.demo.domens;


import com.example.demo.UserDTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class Users {

    public Users(UserDTO userDTO){
        setEmail(userDTO.getEmail());
        setPassword(userDTO.getPassword());
    }

    public Users( String username,  String password, boolean active, @Email String email) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.email = email;
    }

    public Users() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")

    private String username;

    @Column(name = "password")

    private  String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email")
    @Email

    private String email;

//    @Column(name = "accounts")
//    private Accounts account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

   public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
