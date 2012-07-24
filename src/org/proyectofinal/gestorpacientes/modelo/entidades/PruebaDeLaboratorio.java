package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PruebaDeLaboratorio {

	@Id
	@GenericGenerator(name="persona" , strategy="increment")
	@GeneratedValue(generator="persona")
	private int codigoPrueba;
	private String nombreDeLaPrueba;
	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente idPaciente;
	
	public int getCodigoPrueba() {
		return codigoPrueba;
	}
	public String getNombreDeLaPrueba() {
		return nombreDeLaPrueba;
	}
	public void setCodigoPrueba(int codigoPrueba) {
		this.codigoPrueba = codigoPrueba;
	}
	public void setNombreDeLaPrueba(String nombreDeLaPrueba) {
		this.nombreDeLaPrueba = nombreDeLaPrueba;
	}
	public Paciente getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	
}
