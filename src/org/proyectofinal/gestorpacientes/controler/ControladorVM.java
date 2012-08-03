package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.Administrador;
import org.proyectofinal.gestorpacientes.vista.dialogos.VentanaMedico;
import org.proyectofinal.gestorpacientes.vista.dialogos.VentanaPaciente;

public class ControladorVM extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaMedico vista;
	private ModeloMedico modelo;
	private Medico paciente;

	public ControladorVM(JDialog vista, Modelo modelo) {
		super();
		this.vista =  (VentanaMedico) vista;
		this.modelo = (ModeloMedico) modelo;
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
		for (Medico medico : modelo.getListado()) {
			vista.getDm().addRow(
					(new Object[] { medico.getId(), medico.getNombre(),
							medico.getApellido(), medico.getCedula() }));

		}
	}
}
