package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelListaDeMedicos;
import org.proyectofinal.gestorpacientes.vista.PanelListaDePacientes;

public class ControladorListadoPaciente extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelListaDePacientes listaPacientes;
	private ModeloPaciente modeloPaciente;

	
	public ControladorListadoPaciente(Panel listaPacientes,
			Modelo modeloPaciente) {
		super();
		this.listaPacientes = (PanelListaDePacientes) listaPacientes;
		this.modeloPaciente = (ModeloPaciente) modeloPaciente;
		init();
	}

	private void init() {
		llenarTablaPaciente();
		listaPacientes.getBtnVerHistorial().setActionCommand("VerHistorial");
		listaPacientes.getBtnVerHistorial().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent comando) {
	
		if (comando.equals("VerHistorial")) {

		}

	}

	private void llenarTablaPaciente() {
		listaPacientes.getTablaPorDefecto().setNumRows(0);
		for (Paciente paciente : modeloPaciente.getListado()) {
			listaPacientes.getTablaPorDefecto().addRow(
					(new Object[] { paciente.getId(), paciente.getNombre(),
							paciente.getApellido(), paciente.getCedula(), paciente.getNombreFoto()}));

		}

	}
}
