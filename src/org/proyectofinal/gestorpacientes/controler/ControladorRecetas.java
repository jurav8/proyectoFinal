package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import java.awt.print.Book;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Impresora;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloCita;
import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.ModeloPadecimiento;
import org.proyectofinal.gestorpacientes.modelo.ModeloReceta;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelCita;
import org.proyectofinal.gestorpacientes.vista.PanelReceta;

public class ControladorRecetas extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelReceta vista;
	private ModeloReceta modelo;
	private ModeloPaciente modeloP;
	private ModeloPadecimiento modeloPad;
	private Recetas receta;

	public ControladorRecetas(Panel vista, Modelo modelo) {
		super();
		this.vista = (PanelReceta) vista;
		this.modelo = (ModeloReceta) modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		llenarTabla();
		vista.getImprimir().setActionCommand("Imprimir");
		vista.getNuevo().setActionCommand("Nuevo");
		vista.getGuardar().setActionCommand("Guardar");
		vista.getEliminar().setActionCommand("Eliminar");
		vista.getEditar().setActionCommand("Editar");
		vista.getImprimir().addActionListener(this);
		vista.getEditar().addActionListener(this);
		vista.getGuardar().addActionListener(this);
		vista.getEliminar().addActionListener(this);
		vista.getNuevo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		receta = new Recetas();
		receta.setMedicamentos(vista.getMedicamento().getText());
		modeloP = ModeloPaciente.getInstancia(false, false);
		modeloPad = ModeloPadecimiento.getInstancia(false, false);
		receta.setIdPaciente((Paciente) modeloP.consultar(Integer
				.parseInt(vista.getIdPaciente().getText())));
		receta.setIdPadecimientos((Padecimientos) modeloPad.consultar(Integer
				.parseInt(vista.getIdPadecimiento().getText())));

		if (comando.equals("Guardar")) {
			modelo.crear(receta);
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
			receta.setIdReceta(Integer.parseInt(vista.getIdReceta().getText()));
			modelo.modificar(receta);
			llenarTabla();
		}

		if (comando.equals("Nuevo")) {
			vista.getPaciente().setText("");
			vista.getpadecimiento().setText("");
			vista.getMedicamento().setText("");
		}
		
		if(comando.equals("Imprimir")){
			PrinterJob print = PrinterJob.getPrinterJob();
			Book book = new Book();
			book.append(new Impresora(modelo.consultar(1)), print.defaultPage());
			print.setPageable(book);
			if(print.printDialog()){
				try{
					print.print();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		}
	}

	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Recetas receta : modelo.desplegar()) {
			vista.getTablaPorDefecto().addRow(
					(new Object[] { receta.getIdReceta(),
							receta.getIdPadecimientos().getIdPadecimiento(),
							receta.getIdPaciente().getId(),
							receta.getIdPaciente().getNombre(),
							receta.getIdPadecimientos().getNombre(),
							receta.getMedicamentos() }));
		}
	}

}
