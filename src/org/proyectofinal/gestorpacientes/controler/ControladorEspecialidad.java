package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloEspecialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.vista.dialogos.DialogEspecialidad;

public class ControladorEspecialidad extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private DialogEspecialidad vista;
	private ModeloEspecialidad modelo;

	private Especialidad especialidad;
	
	public ControladorEspecialidad(JDialog vista,Modelo modelo){
		this.modelo=(ModeloEspecialidad) modelo;
		this.vista=(DialogEspecialidad) vista;
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
		especialidad = new Especialidad();
		especialidad.setNombreEspecialidad(vista.getNombre().getText());
		
		if (comando.equals("Guardar")) {
			modelo.crear(especialidad);
			llenarTabla();
		}
		if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar esta especialidad?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getTablaPorDefecto()
						.getValueAt(vista.getTabla().getSelectedRow(), 0)
						.toString()));
				llenarTabla();
			}
			if (comando.equals("Editar")) {
				especialidad.setCodigoEspecialidad(Integer.parseInt(vista.getCodigo().getText()));
				modelo.modificar(especialidad);
				llenarTabla();
			}
			if (comando.equals("Nuevo")) {
				vista.getNombre().setText("");
			}
		}
	}
	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Especialidad especialidad : modelo.getListado()) {
			vista.getTablaPorDefecto().addRow((new Object[] { 
					especialidad.getCodigoEspecialidad(), especialidad.getNombreEspecialidad()}));
			
		}
	}
}
