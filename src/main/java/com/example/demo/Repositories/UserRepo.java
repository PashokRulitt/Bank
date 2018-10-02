package com.example.demo.Repositories;

import com.example.demo.domens.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    List<User> findByEmail(String email);

   List<User> findByPassword(String password);
}
