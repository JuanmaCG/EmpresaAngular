package com.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.entities.Nomina;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, String>{

}
