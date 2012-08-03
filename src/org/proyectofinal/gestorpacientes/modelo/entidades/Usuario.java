package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Usuario.getAll", query = "from Usuario")
public class Usuario {
	
	@Id
	@GenericGenerator(name="persona" , strategy="increment")
	@GeneratedValue(generator="persona")
	private int idUsuario;
	private String usuario;
	private String clave;
	private String rango;
	
	public Usuario(){
		
	}

	public Usuario(String usuario, String clave,String rango) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.rango=rango;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}
	
	

}
