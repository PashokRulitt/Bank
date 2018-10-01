package com.example.demo.Repositories;

import com.example.demo.domens.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<Users,Long> {

}
