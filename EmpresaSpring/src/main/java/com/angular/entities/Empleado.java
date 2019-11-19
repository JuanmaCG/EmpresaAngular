package com.angular.entities;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleado {

	@Id
	private String dni;
	private String nombre;
	private char sexo;
	private int categoria;
	private int anyos;

	public Empleado() {	}

	
	
	public Empleado(String dni, String nombre, char sexo, int categoria, int anyos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}



	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;	
	}
	
	public void incrAnyo() {
		this.anyos++;
	}
	
	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	@Override
	public String toString() {
		return "Empleado [categoria=" + categoria + ", anyos=" + anyos + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}
	
	
	
}
