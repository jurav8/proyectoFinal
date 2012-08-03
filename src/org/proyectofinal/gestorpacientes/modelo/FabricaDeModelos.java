package org.proyectofinal.gestorpacientes.modelo;

public class FabricaDeModelos {

	private Modelo modelo;

	public Modelo getModelo(String peticion) {
		modelo = null;
		if (peticion.equals("Usuarios")) {

		} else if (peticion.equals("Pacientes")) {
			modelo = ModeloPaciente.getInstancia(false, false);
		} else if (peticion.equals("Citas")) {
			modelo = ModeloCita.getInstancia(false, false);
		} else if (peticion.equals("Medicos")) {
			modelo = ModeloMedico.getInstancia(false,false);
		} else if (peticion.equals("Recetas")) {
			modelo = ModeloReceta.getInstancia(false,false);
		}
		 else if (peticion.equals("Padecimientos")) {
				modelo = ModeloPadecimiento.getInstancia(false, false);
			}
		return modelo;

	}

}
