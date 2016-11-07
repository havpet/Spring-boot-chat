package com.hib.repositories;

import com.hib.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by haava on 11/3/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
