package org.proyectofinal.gestorpacientes.modelo.entidades;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Paciente.getAll", query = "from Paciente")
@Table(name = "Paciente")
public class Paciente extends Persona {

	private GregorianCalendar fechaNacimiento;
	private int fumador;
	private String nombreFoto;
	private String alergias;
	@OneToMany(mappedBy = "idPaciente", targetEntity = Recetas.class, cascade = CascadeType.ALL)
	private List<Recetas> receta;

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getFumador() {
		return fumador;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFumador(int fumador) {
		this.fumador = fumador;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public List<Recetas> getRecetas() {
		return receta;
	}

	public void setRecetas(List<Recetas> receta) {
		this.receta = receta;
	}
}
