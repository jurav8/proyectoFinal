package org.proyectofinal.gestorpacientes.vista;

public class FabricaDePaneles {

	private Panel panel;
	
	public Panel getPanel(String peticion){
		panel=null;
		if(peticion.equals("Usuarios")){
			panel=new PanelUsuario();
		}
		
		else if(peticion.equals("Pacientes")){
			panel=PanelPaciente.getInstancia();
		}
		
		else if(peticion.equals("Citas")){
			panel=PanelCita.getInstancia();
		}
		else if(peticion.equals("Recetas")){
			panel=PanelReceta.getInstancia();
		}
		else if(peticion.equals("Lista de pacientes")){
			panel=PanelListaDePacientes.getInstancia();
		}
		else if(peticion.equals("Top medicos")){
			panel= new PanelTopMedicos();
		}
		else if(peticion.equals("Top padecimientos")){
			panel= new PanelTopPadecimientos();
		}
		return panel;
		
	}
	
}
