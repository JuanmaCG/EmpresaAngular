package com.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.entities.Empleado;
import com.angular.entities.Nomina;
import com.angular.repositories.NominaRepository;

import exception.ResourceNotFoundException;

@Service
public class NominaServiceImp implements NominaService{

	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
	
	public static int sueldo(Empleado empleado) {
		
		return SUELDO_BASE[empleado.getCategoria() -1 ] + 5000 * empleado.getAnyos();
	
	}
	
	@Autowired
	NominaRepository nominaRepo;
	
	@Override
	public Nomina updateNomina(Empleado emp) {
		// TODO Auto-generated method stub
		Optional<Nomina> nomina = nominaRepo.findById(emp.getDni());
		if(nomina.isPresent()) {
			Nomina nominaActualizado = nomina.get();
			nominaActualizado.setDni(emp.getDni());
			nominaActualizado.setSalario(sueldo(emp));
			nominaRepo.save(nominaActualizado);
			return nominaActualizado;
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}

	@Override
	public Nomina findById(String dni) throws Exception {
		Nomina nomina = nominaRepo.findById(dni).orElseThrow(() -> new Exception("No se ha encontrado la nomina"));
		return nomina;
		
	}

	@Override
	public List<Nomina> getAll() {
		// TODO Auto-generated method stub
		return nominaRepo.findAll();
	}

	
}
