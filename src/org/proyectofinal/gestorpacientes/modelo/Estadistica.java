package org.proyectofinal.gestorpacientes.modelo;

public class Estadistica {

	private Object id;
	private Object total;

	public Estadistica(Object id, Object total) {
		super();
		this.setId(id);
		this.setTotal(total);
	}

	public Object getMedicoId() {
		return id;
	}

	public Object getTotal() {
		return total;
	}

	public void setId(Object medicoId) {
		this.id = medicoId;
	}

	public void setTotal(Object total) {
		this.total = total;
	}

	
}
