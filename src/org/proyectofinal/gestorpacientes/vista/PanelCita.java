package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import org.proyectofinal.gestorpacientes.modelo.ManejardoDeEntidades;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import java.awt.Color;

public class PanelCita extends Panel{

	private static PanelCita instancia;
	private JScrollPane scrollTabla;
	private JPanel panelContenedorTabla;
	private JComboBox<Paciente> paciente;
	private JComboBox<Medico> medico;
	private JTextField fecha;
	private JTextField hora;
	private JScrollPane scrollCausa;
	private JTextArea causa;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JLabel lblPaciente;
	private JLabel lblMedico;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JLabel lblCausa;
	
	private PanelCita(){
		setBackground(Color.WHITE);
		setSize(940, 615);
		setBorder(new TitledBorder("Cita"));
		setLayout(null);
		add(getPaciente());
		add(getPanelContenedorTable());
		add(getMedico());
		add(getFecha());
		add(getHora());
		add(getScrollCausa());
		add(getScrollTabla());
		add(getEditarGuardar());
		add(getNuevoEliminar());
		add(getScrollCausa());
		add(getLblPaciente());
		add(getLblMedico());
		add(getLblFecha());
		add(getLblHora());
		add(getLblCausa());
		
	}
	
	public static PanelCita getInstancia() {
		if (instancia == null)
			instancia = new PanelCita();

		return instancia;
	}
	/***********************************************************************
 	* 		 JTextField Paciente
 	***********************************************************************/
	public JComboBox<Paciente> getPaciente(){
		if(paciente == null){
			paciente = new JComboBox<Paciente>();
			paciente.setBounds(86, 79, 166, 20);
			paciente.setName("paciente");
		}
		return paciente;
	}
	/***********************************************************************
 	* 		 JTextField Medico
 	***********************************************************************/
	public JComboBox<Medico> getMedico(){
		if(medico == null){
			medico = new JComboBox<Medico>();
			medico.setBounds(86, 147, 166, 20);
			medico.setName("medico");
		}
		return medico;
	}
	/***********************************************************************
 	* 		 JTextField Fecha
 	***********************************************************************/
	public JTextField getFecha(){
		if(fecha == null){
			fecha = new JTextField(20);
			fecha.setBounds(389, 79, 166, 20);
			fecha.setName("fecha");
		}
		return fecha;
	}
	/***********************************************************************
 	* 		 JTextField Hora
 	***********************************************************************/
	public JTextField getHora(){
		if(hora == null){
			hora = new JTextField(20);
			hora.setBounds(389, 147, 166, 20);
			hora.setName("hora");
		}
		return hora;
	}
	/***********************************************************************
 	* 		 JScrollPanel para el JTextArea de Causa
 	***********************************************************************/
	public JScrollPane getScrollCausa(){
		if(scrollCausa == null){
			scrollCausa = new JScrollPane();
			scrollCausa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			scrollCausa.setBounds(667, 76, 206, 42);
			scrollCausa.setViewportView(getCausa());
		}
		return scrollCausa;
	}
	/***********************************************************************
 	* 		 JTextField Causa
 	***********************************************************************/
	public JTextArea getCausa(){
		if(causa == null){
			causa = new JTextArea(2, 25);
			causa.setName("causa");
			causa.setLineWrap(true);
		}
		return causa;
	}
	/******************************************************
 	* 		 JScrollPanel para el JTextArea de Causa
 	*****************************************************/
	public JScrollPane getScrollTabla(){
		if(scrollTabla == null){
			scrollTabla = new JScrollPane();
			scrollTabla.setBounds(647, 473, 2, 2);
		}
		return scrollTabla;
	}
	/***********************************************************************
 	* 		 Panel Conetedor de la tabla
 	***********************************************************************/
	public JPanel getPanelContenedorTable(){
		if(panelContenedorTabla == null){
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setBounds(49, 215, 857, 322);
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			panelContenedorTabla.add(getPanelTabla(new String []{"Paciente", "Medico", "Fecha", "Hora", "Causa"}), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}
	/***********************************************************************
 	* 		 Panel para los botones Editar y Guardar
 	***********************************************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.setBounds(679, 147, 187, 35);
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}
	/***********************************************************************
 	* 		Panel para los botones Nuevo y Eliminar
 	***********************************************************************/
	public JPanel getNuevoEliminar(){
		if(nuevoEliminar == null){
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.setBounds(710, 577, 195, 43);
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}
	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(86, 54, 46, 14);
		}
		return lblPaciente;
	}
	private JLabel getLblMedico() {
		if (lblMedico == null) {
			lblMedico = new JLabel("Medico:");
			lblMedico.setBounds(86, 122, 46, 14);
		}
		return lblMedico;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha:");
			lblFecha.setBounds(389, 54, 46, 14);
		}
		return lblFecha;
	}
	private JLabel getLblHora() {
		if (lblHora == null) {
			lblHora = new JLabel("Hora:");
			lblHora.setBounds(389, 122, 46, 14);
		}
		return lblHora;
	}
	private JLabel getLblCausa() {
		if (lblCausa == null) {
			lblCausa = new JLabel("Causa:");
			lblCausa.setBounds(667, 54, 46, 14);
		}
		return lblCausa;
	}
}
