package com.example.demo.Repositories;

import com.example.demo.domens.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<Users,Long> {

    List<Users> findByEmail(String email);


}
