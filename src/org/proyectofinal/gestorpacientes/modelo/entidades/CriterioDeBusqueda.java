package org.proyectofinal.gestorpacientes.modelo.entidades;

public enum CriterioDeBusqueda {
	nombre("nombre"), apellido("apellido"), cedula("cedula");

	String criterio;

	private CriterioDeBusqueda(String criterio) {
		this.criterio = criterio;
	}

	public String toString() {
		return criterio;
	}
}
