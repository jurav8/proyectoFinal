package org.proyectofinal.gestorpacientes.modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente extends Persona {

	private GregorianCalendar fechaNacimiento;
	private int fumador;
	private String nombreFoto;
	@OneToMany(mappedBy = "idPacientes", targetEntity = RelacionAlergiaPaciente.class, cascade = CascadeType.ALL)
	private List<RelacionAlergiaPaciente> alergia = new ArrayList<>();
	@OneToMany(mappedBy = "idPaciente", targetEntity = RelacionPadecimientoPaciente.class, cascade = CascadeType.ALL)
	private List<RelacionPadecimientoPaciente> padecimientos;

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

	public List<RelacionPadecimientoPaciente> getPadecimientos() {
		return padecimientos;
	}

	public void setPadecimientos(List<RelacionPadecimientoPaciente> padecimientos) {
		this.padecimientos = padecimientos;
	}

	public List<RelacionAlergiaPaciente> getAlergia() {
		return alergia;
	}

	public void setAlergia(List<RelacionAlergiaPaciente> alergia) {
		this.alergia = alergia;
	}
}
