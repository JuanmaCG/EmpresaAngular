package com.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.entities.Nomina;
import com.angular.service.NominaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NominaController {

	@Autowired
	NominaService nominaService;
		
	@GetMapping("/nomina/{dni}")
	public Nomina getNomina(@RequestParam String dni) throws Exception {
		return nominaService.findById(dni); 
	}
	
	@GetMapping("/nomina")
	public List<Nomina> getAllNominas(){
		return nominaService.getAll();
	}
}