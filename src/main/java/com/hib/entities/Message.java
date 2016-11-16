package com.hib.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Håvard on 11/16/2016.
 */

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private Long userId;
    private String name;

    public Message() {

    }

    public Message(String content, Long userId, String name) {
        this.content = content;
        this.userId = userId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
