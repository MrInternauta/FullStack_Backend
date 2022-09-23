package com.mrinternauta.RestApi.domain.dto;

import com.mrinternauta.RestApi.persistence.entity.Rol;
import com.mrinternauta.RestApi.persistence.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

public class UserDomain {
    @Autowired
    private Long id;
    @Autowired
    private String name;
    @Autowired
    private String email;
    @Autowired
    private String password;
    @Autowired
    private String imageUrl;
    @Autowired
    private LocalDate createdAt;
    @Autowired
    private LocalDate lastLogin;
    @Autowired
    private Long idRol;
    @Autowired
    private Rol rol;
    @Autowired
    private List<Task> tasks;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }


    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
