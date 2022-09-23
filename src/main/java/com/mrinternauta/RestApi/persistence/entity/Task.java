package com.mrinternauta.RestApi.persistence.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "done", nullable = true)
    private Boolean done;

    @Column(name = "createdAt", nullable = false)
    private LocalDate createdAt;

    @Column(name = "idUser")
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    User user;

    public Task(Long id) {
        this.id = id;
    }

    public Task() {
    }
    public Task(Long id, String name, Boolean done, LocalDate createdAt, User user) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Task(Long id, String name, Boolean done, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.createdAt = createdAt;
    }

    public Task(String name, Boolean done, LocalDate createdAt) {
        this.name = name;
        this.done = done;
        this.createdAt = createdAt;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
