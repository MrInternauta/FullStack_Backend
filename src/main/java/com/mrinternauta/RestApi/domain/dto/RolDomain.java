package com.mrinternauta.RestApi.domain.dto;


import org.springframework.beans.factory.annotation.Autowired;

public class RolDomain {
    @Autowired
    private Long id;
    @Autowired
    private String name;
    @Autowired
    private String description;

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

}
