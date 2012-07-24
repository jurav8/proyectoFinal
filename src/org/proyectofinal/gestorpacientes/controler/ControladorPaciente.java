package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.ManejardoDeEntidades;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.PanelPaciente;

public class ControladorPaciente extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelPaciente vista;
	private ManejardoDeEntidades modelo;

	public ControladorPaciente(PanelPaciente vista, ManejardoDeEntidades modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		llenarTabla();
		vista.getNuevo().setActionCommand("Nuevo");
		vista.getGuardar().setActionCommand("Guardar");
		vista.getEliminar().setActionCommand("Eliminar");
		vista.getGuardar().addActionListener(this);
		vista.getEliminar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Guardar")) {
			modelo.crearPaciente(vista.getNombre().getText(), vista
					.getApellido().getText(), vista.getTelefono().getText(),
					null, vista.getDireccion().getText(), vista.getCedula()
							.getText(), null, 1, null, vista.getAlergia()
							.getText());
			llenarTabla();
		}
		
		if(comando.equals("Eliminar")){
			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar este paciente?");
			if (confirmacion == 0) {
			/*modelo.eliminar(Integer.parseInt(vista.getTablaPorDefecto(new String[] { "Nombre",
					"Apellido", "Telefono", "Cedula", "Direccion", "Alergia",
					"Fumador" }).getValueAt(vista.getTabla(new String[] { "Nombre",
					"Apellido", "Telefono", "Cedula", "Direccion", "Alergia",
					"Fumador" }).getSelectedRow(),3).toString()));
					*/
			
			/*************************************************************************		
					Preguntar a joel porque rayos para sacar el modelo
					y la tabla, tengo que pasarle una matriz con los encabezados de la tabla. 
					
		  ******************************************/
			llenarTabla();
			
		}
		}

	}

	public void llenarTabla(){
		vista.getTablaPorDefecto(new String[] { "Nombre",
				"Apellido", "Telefono", "Cedula", "Direccion", "Alergia",
				"Fumador" }).setNumRows(0);
		for(Paciente paciente:modelo.getPacientes()){
		vista.getTablaPorDefecto(new String[] { "Nombre",
				"Apellido", "Telefono", "Cedula", "Direccion", "Alergia",
				"Fumador" }).addRow((new Object[]{paciente.getNombre(),
						paciente.getApellido(),paciente.getTelefonoCasa(), paciente.getCedula(),
						paciente.getDireccion(),paciente.getAlergias(),paciente.getFumador()}));
		}
	}
}
