package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import org.proyectofinal.gestorpacientes.modelo.ManejardoDeEntidades;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.PanelCita;

public class ControladorCitas extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelCita vista;
	private ManejardoDeEntidades modelo;

	public ControladorCitas(PanelCita vista, ManejardoDeEntidades modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		init();
		llenarTabla();
	}

	public void init() {
		// TODO Auto-generated method stub
		vista.getNuevo().setActionCommand("Nuevo");
		vista.getEditar().setActionCommand("Guardar");// el boton Guardar no se
														// ve, preguntar a Joel
		vista.getEditar().addActionListener(this);// tuve que hacerlo con el
													// editar por motivos de
													// prueba mientras tanto

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();		
		Medico medico = modelo.consultarMedico(1);
		List<Especialidad> lista = new ArrayList<Especialidad>();
		lista.add(modelo.consultarEspecialidad(12));
		ManejardoDeEntidades.getEnlace(false,false).crearMedico("juan", "pellerano", "809-590-2939", "809-387-3242",
				"La caleta, boca chica no.22", "001-9273893-1", new Usuario(
						"perensejo", "1234"), lista);

		if (comando.equals("Guardar")) {
			modelo.crearCitas(null, vista.getHora().getText(), vista.getCausa()
					.getText(), medico, modelo.consultarPaciente(1));
		}
		llenarTabla();

	}

	public void llenarTabla() {
		vista.getTablaPorDefecto(
				new String[] { "Paciente", "Medico", "Fecha", "Hora", "Causa" })
				.setNumRows(0);
		for (Citas cita : modelo.getCitas()) {
			vista.getTablaPorDefecto(
					new String[] { "Paciente", "Medico", "Fecha", "Hora",
							"Causa" })
					.addRow((new Object[] { cita.getIdPaciente(),
							cita.getIdMedico(), cita.getFecha(),
							cita.getHora(), cita.getCausa(), }));
		}
	}

}
