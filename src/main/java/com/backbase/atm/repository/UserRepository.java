package com.backbase.atm.repository;

import com.backbase.atm.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AIRSoftware on 10/02/2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String user);

}
