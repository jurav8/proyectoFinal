package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.ModeloEspecialidad;
import org.proyectofinal.gestorpacientes.modelo.ModeloResultadoLaboratorio;

import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.PruebaDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;

import org.proyectofinal.gestorpacientes.vista.PanelPaciente;
import org.proyectofinal.gestorpacientes.vista.dialogos.DialogResultadosLaboratorio;

public class ControladorResultadoLaboratorio extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private DialogResultadosLaboratorio vista;
	private ModeloResultadoLaboratorio modelo;

	private ResultadoDeLaboratorio resultado;
	
	public ControladorResultadoLaboratorio(){
		
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
		resultado = new ResultadoDeLaboratorio("");
		modelo = ModeloResultadoLaboratorio.getInstancia(false, false);
		resultado.setIdPaciente((Paciente)vista.getPaciente().getSelectedItem());
		resultado.setIdPruebaLaboratorio((PruebaDeLaboratorio)vista.getPrueba().getSelectedItem());
		resultado.setResultado(vista.getResultado().getText());
		if (comando.equals("Guardar")) {
			modelo.crear(resultado);
			llenarTabla();
		}
		if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar este Resultado de laboratorio?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getTablaPorDefecto()
						.getValueAt(vista.getTabla().getSelectedRow(), 0)
						.toString()));
				llenarTabla();
			}
			if (comando.equals("Editar")) {
				resultado.setIdResultadoLaboratorio(Integer.parseInt(vista.getId().getText()));
				modelo.modificar(resultado);
				llenarTabla();
			}
			if (comando.equals("Nuevo")) {
				vista.getResultado().setText("");
			}
		}
	}
	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (ResultadoDeLaboratorio resultado : modelo.getListado()) {
			vista.getTablaPorDefecto().addRow((new Object[] { 
					resultado.getIdPruebaLaboratorio() ,resultado.getIdPaciente().getNombre(), resultado.getIdPruebaLaboratorio().getNombreDeLaPrueba(), resultado.getResultado()}));
			
		}
	}
}
