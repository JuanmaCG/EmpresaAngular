package com.angular.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nominas")
public class Nomina implements Serializable {
	

	@Id
	private String dni;
	
	private int salario;
	
	
	public Nomina() {}
	

	public Nomina(String dni, int salario) {
		super();
		this.dni = dni;
		this.salario = salario;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
}
