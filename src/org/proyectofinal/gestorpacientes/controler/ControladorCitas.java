package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloCita;
import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelCita;

public class ControladorCitas extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelCita vista;
	private ModeloCita modelo;
	private ModeloPaciente modeloP;
	private ModeloMedico modeloM;
	private Citas cita;

	public ControladorCitas(Panel vista, Modelo modelo) {
		super();
		this.vista = (PanelCita) vista;
		this.modelo = (ModeloCita) modelo;
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
		cita = new Citas();
		modeloP = ModeloPaciente.getInstancia(false, false);
		modeloM = ModeloMedico.getInstancia(false, false);
		cita.setCausa(vista.getCausa().getText());
		cita.setFecha(vista.getFecha().getDate());
		cita.setHora(vista.getHoras().getValue() + ":"
				+ vista.getMinutos().getValue() + " "
				+ vista.getAmPm().getSelectedItem().toString());
		cita.setIdPaciente((Paciente) modeloP.consultar(Integer.parseInt(vista
				.getIdPaciente().getText())));
		cita.setIdMedico((Medico) modeloM.consultar(Integer.parseInt(vista
				.getIdMedico().getText())));
		cita.setMedico(Integer.parseInt(vista.getIdMedico().getText()));

		if (comando.equals("Guardar")) {
			modelo.crear(cita);
			llenarTabla();
		}

		if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar esta cita?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getTablaPorDefecto()
						.getValueAt(vista.getTabla().getSelectedRow(), 0)
						.toString()));
				llenarTabla();

			}
		}
		if (comando.equals("Editar")) {
			cita.setIdCitas(Integer.parseInt(vista.getIdCita().getText()));
			modelo.modificar(cita);
			llenarTabla();
		}

		if (comando.equals("Nuevo")) {
			vista.getCausa().setText("");
			vista.getPaciente().setText("");
			vista.getMedico().setText("");
			vista.getHoras().setValue(0);
			vista.getMinutos().setValue(0);
			vista.getAmPm().setSelectedIndex(0);
			// vista.getFecha().setText("");
			vista.getCausa().setText("");
		}
	}

	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Citas cita : modelo.desplegar()) {
			vista.getTablaPorDefecto().addRow(
					(new Object[] { cita.getIdCitas(),
							cita.getIdMedico().getId(),
							cita.getIdPaciente().getId(),
							cita.getIdPaciente().getNombre(),
							cita.getIdMedico().getNombre(), cita.getFecha(),
							cita.getHora(), cita.getCausa() }));
		}
	}

}
