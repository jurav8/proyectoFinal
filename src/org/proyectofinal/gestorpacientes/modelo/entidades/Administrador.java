package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="administradores")
public class Administrador extends Persona {

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
