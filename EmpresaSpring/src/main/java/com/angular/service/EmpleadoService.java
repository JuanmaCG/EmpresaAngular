package com.angular.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angular.entities.Empleado;

@Service
public interface EmpleadoService {

	public List<Empleado> findAll();
	public Empleado findByDni(String dni);
	public Empleado createEmpleado(Empleado empleado);
	public Empleado updateEmpleado(Empleado empleado);
	public void deleteEmpleadoByDni(String dni);
	
}
