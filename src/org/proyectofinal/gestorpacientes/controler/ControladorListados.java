package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelListaDeMedicos;
import org.proyectofinal.gestorpacientes.vista.PanelListaDePacientes;

public class ControladorListados extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelListaDeMedicos listaMedicos;
	private PanelListaDePacientes listaPacientes;
	public ControladorListados(PanelListaDeMedicos panel, ModeloMedico modelo) {
		super();
		this.listaMedicos = panel;
		init();
	}

	public ControladorListados(PanelListaDePacientes panel, ModeloPaciente modelo) {
		super();
		this.listaPacientes = (PanelListaDePacientes) panel;
		init();
	}

	private void init() {
		listaMedicos.getBtnBuscar().setActionCommand("BuscarMedico");
		listaPacientes.getBtnVerHistorial().setActionCommand("VerHistorial");
		listaMedicos.getBtnBuscar().addActionListener(this);
		listaPacientes.getBtnVerHistorial().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent comando) {
		if (comando.equals("BuscarMedico")) {

		}

		if (comando.equals("VerHistorial")) {

		}

	}

}
