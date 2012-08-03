package org.proyectofinal.gestorpacientes.modelo.entidades;

public enum Perfiles {
	Administrador("administrador"), Medico("medico"), Asistente("asistente");

	String perfil;

	private Perfiles(String perfil) {
		this.perfil = perfil;
	}

	public String toString() {
		return perfil;
	}
}
