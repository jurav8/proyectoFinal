package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Padecimiento.getAll", query = "from Padecimientos")
public class Padecimientos {
	
	@Id
	@GenericGenerator(name="persona" , strategy="increment")
	@GeneratedValue(generator="persona")
	private int idPadecimiento;
	private String nombre;

	public int getIdPadecimiento() {
		return idPadecimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIdPadecimiento(int idPadecimiento) {
		this.idPadecimiento = idPadecimiento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
