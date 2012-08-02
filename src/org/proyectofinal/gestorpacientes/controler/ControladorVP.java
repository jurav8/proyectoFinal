package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.Administrador;
import org.proyectofinal.gestorpacientes.vista.VentanaPaciente;

public class ControladorVP extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPaciente vista;
	private ModeloPaciente modelo;
	private Paciente paciente;

	public ControladorVP(JDialog vista, Modelo modelo) {
		super();
		this.vista =  (VentanaPaciente) vista;
		this.modelo = (ModeloPaciente) modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		llenarTabla();
		vista.getBtnSeleccionar().setActionCommand("Seleccionar");
		vista.getBtnSeleccionar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		paciente = new Paciente();

		if (comando.equals("Seleccionar")) {
			vista.setId(Integer.valueOf(vista.getDm()
					.getValueAt(vista.getTable().getSelectedRow(), 0)
					.toString()));
			vista.setNombre(vista.getDm()
					.getValueAt(vista.getTable().getSelectedRow(), 1)
					.toString());
			vista.setApellido(vista.getDm()
					.getValueAt(vista.getTable().getSelectedRow(), 2)
					.toString());
			vista.dispose();
		}

	}

	public void llenarTabla() {
		vista.getDm().setNumRows(0);
		for (Paciente paciente : modelo.desplegar()) {
			vista.getDm().addRow(
					(new Object[] { paciente.getId(), paciente.getNombre(),
							paciente.getApellido(), paciente.getCedula(), }));

		}
	}
}
