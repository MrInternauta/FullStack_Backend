package com.mrinternauta.RestApi.persistence.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "imageUrl", nullable = true, length = 128)
    private String imageUrl;

    @Column(name = "createdAt", nullable = false)
    private LocalDate createdAt;

    @Column(name = "lastLogin", nullable = true)
    private LocalDate lastLogin;

    @Column(name = "idRol")
    private Long idRol;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idRol", insertable = false, updatable = false)
    private Rol rol;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Task> tasks;

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }

    public User(Long id, String name, String email, String password, String imageUrl, LocalDate createdAt, LocalDate lastLogin, Long idRol) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.idRol = idRol;
    }

    public User(Long id, String name, String email, String password, String imageUrl, LocalDate createdAt, LocalDate lastLogin, Long idRol, Rol rol, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.idRol = idRol;
        this.rol = rol;
        this.tasks = tasks;
    }

    public User(Long id, String name, String email, String password, String imageUrl, LocalDate createdAt, LocalDate lastLogin, Rol rol, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.rol = rol;
        this.tasks = tasks;
    }

    public User(Long id, String name, String email, String password, String imageUrl, LocalDate createdAt, LocalDate lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
    }

    public User(String name, String email, String password, String imageUrl, LocalDate createdAt, LocalDate lastLogin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
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
