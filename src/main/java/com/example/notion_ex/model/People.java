package com.example.notion_ex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName, lastName;

    /*public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }*/
}
