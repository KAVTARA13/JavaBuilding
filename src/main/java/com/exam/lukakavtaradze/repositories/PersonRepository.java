package com.exam.lukakavtaradze.repositories;

import com.exam.lukakavtaradze.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT u FROM Person u")
    List<Person> getAll();
}
