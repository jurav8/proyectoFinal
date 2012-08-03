package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.ModeloUsuario;
import org.proyectofinal.gestorpacientes.modelo.entidades.Asistentes;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelPaciente;
import org.proyectofinal.gestorpacientes.vista.PanelUsuario;

public class ControladorUsuario extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelUsuario vista;
	private ModeloUsuario modelo;
	private Asistentes asistente;

	public ControladorUsuario(Panel vista, Modelo modelo) {
		super();
		this.vista = (PanelUsuario) vista;
		this.modelo = (ModeloUsuario) modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub

			llenarTabla();
			vista.getNuevo().setActionCommand("Nuevo");
			vista.getGuardar().setActionCommand("Guardar");
			vista.getEliminar().setActionCommand("Eliminar");
			vista.getEditar().setActionCommand("Editar");
			vista.getEditar().addActionListener(this);
			vista.getGuardar().addActionListener(this);
			vista.getEliminar().addActionListener(this);
			vista.getNuevo().addActionListener(this);
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		
		
		if (comando.equals("Guardar")) {
			
			llenarTabla();
		}

		if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar este paciente?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getTablaPorDefecto()
						.getValueAt(vista.getTabla().getSelectedRow(), 0)
						.toString()));
				llenarTabla();

			}
		}
		if (comando.equals("Editar")) {
		  
			llenarTabla();
		}

		if (comando.equals("Nuevo")) {
			vista.getApellido().setText("");
			vista.getCedula().setText("");
			vista.getDireccion().setText("");
			vista.getNombre().setText("");
			vista.getTelefono().setText("");
			vista.getCelular().setText("");
			
		}

		
	}

	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Usuario usuario : modelo.getListado()) {
				vista.getTablaPorDefecto().addRow((new Object[] { }));
			
		}
	}
}
