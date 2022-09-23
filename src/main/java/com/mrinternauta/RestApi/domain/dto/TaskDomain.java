package com.mrinternauta.RestApi.domain.dto;

import com.mrinternauta.RestApi.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TaskDomain {
    @Autowired
    private Long id;
    @Autowired
    private String name;
    @Autowired
    private Boolean done;
    @Autowired
    private LocalDate createdAt;
    @Autowired
    private Long idUser;

    @Autowired
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
