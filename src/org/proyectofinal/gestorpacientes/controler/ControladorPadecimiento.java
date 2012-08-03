package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.ModeloPadecimiento;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;
import org.proyectofinal.gestorpacientes.vista.Administrador;
import org.proyectofinal.gestorpacientes.vista.dialogos.VentanaPaciente;
import org.proyectofinal.gestorpacientes.vista.dialogos.VentanaPadecimiento;

public class ControladorPadecimiento extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VentanaPadecimiento vista;
	private ModeloPadecimiento modelo;
	private Padecimientos padecimiento;

	public ControladorPadecimiento(JDialog vista, Modelo modelo) {
		super();
		this.vista = (VentanaPadecimiento) vista;
		this.modelo = (ModeloPadecimiento) modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		llenarTabla();
		vista.getBtnSeleccionar().setActionCommand("Seleccionar");
		vista.getBtnAgregar().setActionCommand("Guardar");
		vista.getBtnBorrar().setActionCommand("Eliminar");
		vista.getBtnEditar().setActionCommand("Editar");
		vista.getBtnEditar().addActionListener(this);
		vista.getBtnAgregar().addActionListener(this);
		vista.getBtnBorrar().addActionListener(this);
		vista.getBtnSeleccionar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		padecimiento = new Padecimientos();
		if(!vista.getCodigo().getText().equals(""))
			padecimiento.setIdPadecimiento(Integer.parseInt(vista.getCodigo().getText()));
		padecimiento.setNombre(vista.getNombres().getText());

		if (comando.equals("Seleccionar")) {
			vista.setId(Integer.valueOf(vista.getDm()
					.getValueAt(vista.getTable().getSelectedRow(), 0)
					.toString()));
			vista.setNombre(vista.getDm()
					.getValueAt(vista.getTable().getSelectedRow(), 1)
					.toString());
			vista.dispose();
		}
		if (comando.equals("Guardar")) {
			modelo.crear(padecimiento);
			llenarTabla();
		}

	    if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar este paciente?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getDm()
						.getValueAt(vista.getTable().getSelectedRow(), 0)
						.toString()));
				llenarTabla();

			}
		}
		if (comando.equals("Editar")) {
			modelo.modificar(padecimiento);
			llenarTabla();
		}

	}

	public void llenarTabla() {
		vista.getDm().setNumRows(0);
		for (Padecimientos padecimiento : modelo.getListado()) {
			vista.getDm().addRow(
					(new Object[] { padecimiento.getIdPadecimiento(),
							padecimiento.getNombre() }));
		}
	}

}