package org.proyectofinal.gestorpacientes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RelacionPadecimientoPaciente {

	@Id
	@GenericGenerator(name = "persona", strategy = "increment")
	@GeneratedValue(generator = "persona")
	private int id;
	@OneToOne
	@JoinColumn(name = "padecimiento_id")
	private Padecimientos idPadeciemiento;
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente idPaciente;

	public Padecimientos getIdPadeciemiento() {
		return idPadeciemiento;
	}

	public void setIdPadeciemiento(Padecimientos idPadeciemiento) {
		this.idPadeciemiento = idPadeciemiento;
	}

	public Paciente getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
