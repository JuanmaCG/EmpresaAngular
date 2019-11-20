package com.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.angular.entities.Empleado;
import com.angular.service.EmpleadoService;
import com.angular.service.NominaService;

import exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	EmpleadoService empService;
	@Autowired
	NominaService nominaService;
	
	@GetMapping("/empleados")
	public List<Empleado> getAllEmp(){
		return empService.findAll();
	}
	
	@GetMapping("/empleados/{dni}")
	public Empleado getEmpByDni(@PathVariable String dni) {
		return empService.findByDni(dni);
	}
	
	@PostMapping("/empleados")
	public void createEmp(@RequestBody Empleado empleado) {	
		empService.createEmpleado(empleado);
	}
	
	@DeleteMapping("/empleados/{dni}")
	public void deleteEmp(@PathVariable String dni) {
		empService.deleteEmpleadoByDni(dni);
		nominaService.deleteNominaByDni(dni);
	}
	
	@PatchMapping("/empleados/{dni}")
	public void updateEmp(@RequestBody Empleado empleado) {
		empService.updateEmpleado(empleado);
		nominaService.updateNomina(empleado);
	}
}
