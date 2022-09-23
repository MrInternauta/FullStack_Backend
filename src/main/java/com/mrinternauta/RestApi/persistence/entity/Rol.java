package com.mrinternauta.RestApi.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = true, length = 45)
    private String description;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> users;

    public Rol() {
    }

    public Rol(Long id, String name, String description, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }
    public Rol(Long id) {
        this.id = id;
    }

    public Rol(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Rol(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
