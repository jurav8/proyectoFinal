package org.proyectofinal.gestorpacientes.modelo.entidades;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Citas.getAll", query = "from Citas")
@Table(name = "Citas")
public class Citas {
	
	@Id
	@GenericGenerator(name="citas" , strategy="increment")
	@GeneratedValue(generator="citas")
	private int idCitas;
	private Date fecha;
	private String hora;
	private String causa;
	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente idPaciente;
	@OneToOne
	@JoinColumn(name = "medico_id")
	private Medico idMedico;
	private int medico;
	
	public int getIdCitas() {
		return idCitas;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
	public String getCausa() {
		return causa;
	}
	public void setIdCitas(int idCitas) {
		this.idCitas = idCitas;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Medico getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

	public Paciente getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getMedico() {
		return medico;
	}
	public void setMedico(int medico) {
		this.medico = medico;
	}
	
	

}
