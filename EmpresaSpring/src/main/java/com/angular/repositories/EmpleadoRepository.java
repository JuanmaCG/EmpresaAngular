package com.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

}
