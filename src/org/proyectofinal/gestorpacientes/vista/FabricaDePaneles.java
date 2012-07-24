package org.proyectofinal.gestorpacientes.vista;

import javax.swing.JPanel;

public class FabricaDePaneles {

	private JPanel panel;
	
	public JPanel getPanel(String peticion){
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
		return panel;
		
	}
	
}
