package com.hib.repositories;

import com.hib.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Håvard on 11/16/2016.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
