package com.exam.lukakavtaradze.repositories;

import com.exam.lukakavtaradze.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    @Query("SELECT u FROM Building u")
    List<Building> getAll();

//    List<Building> getAllByPersonI
}
