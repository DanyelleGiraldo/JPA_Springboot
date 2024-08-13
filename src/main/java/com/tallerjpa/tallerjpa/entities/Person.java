package com.tallerjpa.tallerjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition =  "VARCHAR(50)", nullable = false)
    private String name;

    @Column(columnDefinition =  "VARCHAR(50)", nullable = false)
    private String lastName;

    @Column(columnDefinition =  "VARCHAR(50)", nullable = false)
    private String programmingLanguage;

    public Person() {
    }
    
    public Person(Long id, String name, String lastName, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }  
    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", lastname=" + lastName + ", programmingLanguage="
                + programmingLanguage + "]";
    }
}
