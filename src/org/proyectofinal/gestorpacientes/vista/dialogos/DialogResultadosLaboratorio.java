package org.proyectofinal.gestorpacientes.vista.dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.PruebaDeLaboratorio;

public class DialogResultadosLaboratorio extends IDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedorTabla;
	private JTextField id;
	private JTextField resultado;
	private JScrollPane scrollTabla;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JLabel lblCodigo;
	private JLabel lblResultado;
	private JComboBox<Paciente> paciente;
	private JLabel lblPrueba;
	private JComboBox<PruebaDeLaboratorio> prueba;
	
	public DialogResultadosLaboratorio(Frame padre, boolean modal) {
		super(padre, modal);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		getContentPane().setLayout(null);
		getContentPane().add(getId());
		getContentPane().add(getResultado());
		getContentPane().add(getScrollTabla());
		getContentPane().add(getEditarGuardar());
		getContentPane().add(getNuevoEliminar());
		getContentPane().add(getLblCodigo());
		getContentPane().add(getLblResultado());
		
		
		getContentPane().add(getPaciente());
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(43, 109, 46, 14);
		getContentPane().add(lblPaciente);
		getContentPane().add(getLblPrueba());
		getContentPane().add(getPrueba());
	}
	
	/***********************************************************************
 	* 			Combo box Prueba de laboratorio
 	***********************************************************************/
	public JComboBox<PruebaDeLaboratorio> getPrueba(){
		if(prueba == null){
			prueba = new JComboBox<PruebaDeLaboratorio>();
			prueba.setBounds(114, 62, 86, 20);
			prueba.setEditable(false);
		}
		return prueba;
	}
	/***********************************************************************
 	* 			Combo box Paciente
 	***********************************************************************/
	public JComboBox<Paciente> getPaciente(){
		if(paciente == null){
			paciente = new JComboBox();
			paciente.setBounds(112, 106, 119, 20);
		}
		return paciente;
	}
	
	/***********************************************************************
 	* 		 TextField Codigo
 	***********************************************************************/
	public JTextField getId(){
		if(id == null){
			id = new JTextField(10);
			id.setBounds(114, 25, 86, 20);
			id.setName("codigo");
			id.setEditable(false);
		}
		return id;
	}
	/***********************************************************************
 	* 		 TextField Resultado
 	***********************************************************************/
	public JTextField getResultado(){
		if(resultado == null){
			resultado = new JTextField(30);
			resultado.setBounds(321, 62, 246, 20);
			resultado.setName("nombre");
			resultado.setEditable(false);
		}
		return resultado;
	}
	/***************************************************
	 *   SCrollPanel de la tabla
	 **************************************************/
	public JScrollPane getScrollTabla(){
		if(scrollTabla == null){
			scrollTabla = new JScrollPane(getPanelContenedorTable());
			scrollTabla.setBounds(20, 137, 569, 214);
		}
		return scrollTabla;
	}
	/***********************************************************************
 	* 		 Panel Contenedor del Scroll de la tabla
 	***********************************************************************/
	public JPanel getPanelContenedorTable(){
		if(panelContenedorTabla == null){
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			panelContenedorTabla.add(getPanelTabla());
		}
		return panelContenedorTabla;
	}
	/***********************************************************************
 	* 		 Panel Contenedor de los botones Editar y Guardar
 	***********************************************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.setBounds(380, 93, 187, 35);
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}
	/***********************************************************************
 	* 		 Panel Contenedor de los botones Nuevo y Eliminar
 	***********************************************************************/
	public JPanel getNuevoEliminar(){
		if(nuevoEliminar == null){
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.setBounds(372, 357, 195, 43);
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}
	private JLabel getLblCodigo() {
		if (lblCodigo == null) {
			lblCodigo = new JLabel("ID:");
			lblCodigo.setBounds(43, 28, 46, 14);
		}
		return lblCodigo;
	}
	private JLabel getLblResultado() {
		if (lblResultado == null) {
			lblResultado = new JLabel("Resultado:");
			lblResultado.setBounds(242, 65, 69, 14);
		}
		return lblResultado;
	}
	private JLabel getLblPrueba() {
		if (lblPrueba == null) {
			lblPrueba = new JLabel("Prueba");
			lblPrueba.setBounds(43, 65, 46, 14);
		}
		return lblPrueba;
	}
}
