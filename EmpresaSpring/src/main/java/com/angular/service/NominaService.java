package com.angular.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angular.entities.Empleado;
import com.angular.entities.Nomina;

@Service
public interface NominaService {
	
	Nomina updateNomina(Empleado emp);
	Nomina findById(String dni);
	List<Nomina> getAll();
	public void deleteNominaByDni(String dni);
}
