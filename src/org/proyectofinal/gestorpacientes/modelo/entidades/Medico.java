package org.proyectofinal.gestorpacientes.modelo.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Medico.getAll", query = "from Medico")
@Table(name = "Medicos")
public class Medico extends Persona {

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "idMedico", targetEntity = RelacionEspecialidadMedico.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<RelacionEspecialidadMedico> especialidades;

	public Medico() {
		setEspecialidades(new ArrayList<RelacionEspecialidadMedico>());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<RelacionEspecialidadMedico> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(
			List<RelacionEspecialidadMedico> especialidades) {
		this.especialidades = especialidades;
	}

}
