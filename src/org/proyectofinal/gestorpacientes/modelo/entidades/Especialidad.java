package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Especialidad {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int codigoEspecialidad;
	private String nombreEspecialidad;

	public int getCodigoEspecialidad() {
		return codigoEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public Especialidad() {

	}

	public Especialidad(int codigoEspecialidad, String nombreEspecialidad) {
		super();
		this.codigoEspecialidad = codigoEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public void setCodigoEspecialidad(int codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

}
