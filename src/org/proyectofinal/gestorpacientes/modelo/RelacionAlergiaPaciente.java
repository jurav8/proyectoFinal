package org.proyectofinal.gestorpacientes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RelacionAlergiaPaciente {
	
	@Id
	@GenericGenerator(name="persona" , strategy="increment")
	@GeneratedValue(generator="persona")
	private int id;
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente idPacientes;
	@OneToOne
	@JoinColumn(name = "alergia_id")
	private Alergia idAlergia;

	public Paciente getAlergiaPaciente() {
		return idPacientes;
	}

	public void setAlergiaPaciente(Paciente alergiaPaciente) {
		this.idPacientes = alergiaPaciente;
	}

	public Alergia getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(Alergia idAlergia) {
		this.idAlergia = idAlergia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
