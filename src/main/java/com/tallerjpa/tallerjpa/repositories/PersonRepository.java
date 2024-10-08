package com.tallerjpa.tallerjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tallerjpa.tallerjpa.entities.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    
    @Query("select p from Person where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);
}
