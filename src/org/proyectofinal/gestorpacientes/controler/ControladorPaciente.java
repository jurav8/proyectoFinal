package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelPaciente;

public class ControladorPaciente extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelPaciente vista;
	private ModeloPaciente modelo;
	private Paciente paciente;

	public ControladorPaciente(Panel vista, Modelo modelo) {
		super();
		this.vista = (PanelPaciente) vista;
		this.modelo = (ModeloPaciente) modelo;
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

		paciente = new Paciente();
		paciente.setApellido(vista.getApellido().getText());
		paciente.setCedula(vista.getCedula().getText());
		paciente.setDireccion(vista.getDireccion().getText());
		paciente.setNombre(vista.getNombre().getText());
		paciente.setTelefonoCasa(vista.getTelefono().getText());
		paciente.setTelefonoCelular(vista.getCelular().getText());
		paciente.setFechaNacimiento(vista.getFecha().getDate());
		paciente.setFumador(vista.getFumador().getSelectedIndex());
		paciente.setAlergias(vista.getAlergia().getText());
		paciente.setNombreFoto(vista.getRuta());
		
		if (comando.equals("Guardar")) {
			modelo.crear(paciente);
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
		    paciente.setNombreFoto(vista.getRuta());
			paciente.setId(Integer.parseInt(vista.getIdPaciente().getText()));
			modelo.modificar(paciente);
			llenarTabla();
		}

		if (comando.equals("Nuevo")) {
			vista.getApellido().setText("");
			vista.getCedula().setText("");
			vista.getDireccion().setText("");
			vista.getNombre().setText("");
			vista.getTelefono().setText("");
			vista.getCelular().setText("");
			vista.getFumador().setSelectedIndex(0);
			vista.getAlergia().setText("");
		}

		
	}

	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Paciente paciente : modelo.getListado()) {
				vista.getTablaPorDefecto().addRow((new Object[] { paciente.getId(),
						paciente.getNombre(), paciente.getApellido(),
						paciente.getTelefonoCasa(),
						paciente.getTelefonoCelular(), paciente.getCedula(),
						paciente.getDireccion(), paciente.getAlergias(),
						paciente.getFumador(), paciente.getFechaNacimiento(),paciente.getNombreFoto()}));
			
		}
	}
}
