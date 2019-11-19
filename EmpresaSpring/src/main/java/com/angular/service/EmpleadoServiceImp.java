package com.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.entities.Empleado;
import com.angular.repositories.EmpleadoRepository;
import com.angular.repositories.NominaRepository;
import com.angular.entities.Nomina;
import com.angular.service.NominaServiceImp;

import exception.ResourceNotFoundException;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empRepo;
	@Autowired
	private NominaRepository nominaRepo;

	@Override
	public List<Empleado> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Empleado findByDni(String dni) {
		Optional<Empleado> emp = empRepo.findById(dni);
		
		return emp.orElseThrow(() -> new ResourceNotFoundException("Empleado no existente"));
	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		if(empRepo.findById(empleado.getDni()).isPresent()) {
			throw new ResourceNotFoundException("Empleado existente");
		}else {
			nominaRepo.save(new Nomina(empleado.getDni(), NominaServiceImp.sueldo(empleado)));
			return empRepo.save(empleado);
		}
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		Optional<Empleado> emp = empRepo.findById(empleado.getDni());
		Optional<Nomina> nomina = nominaRepo.findById(empleado.getDni());
		if(emp.isPresent()) {
			Nomina nominaActualizada = nomina.get();
			Empleado empActualizado = emp.get();
			empActualizado.setAnyos(empleado.getAnyos());
			empActualizado.setCategoria(empleado.getCategoria());
			empActualizado.setDni(empleado.getDni());
			empActualizado.setNombre(empleado.getNombre());
			empActualizado.setSexo(empleado.getSexo());
			if((empleado.getCategoria() != empActualizado.getCategoria()) || (empleado.getAnyos() != empActualizado.getAnyos())){
				nominaActualizada.setSalario(NominaServiceImp.sueldo(empActualizado));
			}
			nominaRepo.save(nominaActualizada);
			empRepo.save(empActualizado);
			return empActualizado;
			
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}

	@Override
	public void deleteEmpleadoByDni(String dni) {
		// TODO Auto-generated method stub
		Optional<Empleado> emp = empRepo.findById(dni);
		if(emp.isPresent()) {
			empRepo.delete(emp.get());
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
		
	}
	
}
