package com.parker.app.restAPI.Repo;

import com.parker.app.restAPI.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
