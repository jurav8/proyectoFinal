package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RelacionEspecialidadMedico {

	@Id
	@GenericGenerator(name="persona" , strategy="increment")
	@GeneratedValue(generator="persona")
	private int id;
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico idMedico;
	
	@OneToOne
	@JoinColumn(name = "especialidad_id")
	private Especialidad idEspecialidad;

	public Medico getIdMedico() {
		return idMedico;
	}

	public Especialidad getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

	public void setIdEspecialidad(Especialidad idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
