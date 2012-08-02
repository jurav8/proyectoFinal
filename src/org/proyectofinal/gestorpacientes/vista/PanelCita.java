package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;

import org.proyectofinal.gestorpacientes.controler.ControladorPaciente;
import org.proyectofinal.gestorpacientes.controler.ControladorVP;
import org.proyectofinal.gestorpacientes.modelo.FabricaDeModelos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import com.toedter.components.JSpinField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelCita extends Panel{

	private static PanelCita instancia;
	private JScrollPane scrollTabla;
	private JPanel panelContenedorTabla;
	private JScrollPane scrollCausa;
	private JTextArea causa;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JLabel lblPaciente;
	private JLabel lblMedico;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JLabel lblCausa;
	private JTextField paciente;
	private JTextField medico;
	private JDateChooser fecha;
	
	public JLabel getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(JLabel idMedico) {
		this.idMedico = idMedico;
	}

	private FabricaDeModelos fabricaM;
	private JLabel idMedico;
	private JLabel idPaciente;
	private JLabel idCita;
	private JSpinField horas;
	private JSpinField minutos;
	private JComboBox amPm;

	private PanelCita(){
		setBackground(Color.WHITE);
		setSize(940, 615);
		setBorder(new TitledBorder("Cita"));
		setLayout(null);
		add(getPanelContenedorTable());
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
		add(getPaciente());
		add(getMedico());
		
		fabricaM=new FabricaDeModelos();
		
		fecha = new JDateChooser();
		fecha.setBounds(389, 76, 166, 20);
		add(fecha);
		
		idPaciente = new JLabel("");
		idPaciente.setVisible(false);
		idPaciente.setBounds(86, 11, 46, 14);
		add(idPaciente);
		
		idMedico = new JLabel("");
		idMedico.setVisible(false);
		idMedico.setBounds(166, 11, 46, 14);
		add(idMedico);
		add(getIdCita());
		
	    horas = new JSpinField();
		horas.setMaximum(12);
		horas.setBounds(389, 147, 36, 20);
		add(horas);
		
	    minutos = new JSpinField();
		minutos.setMaximum(60);
		minutos.setBounds(435, 147, 36, 20);
		add(minutos);
		
	    amPm = new JComboBox();
		amPm.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		amPm.setBounds(481, 147, 46, 20);
		add(amPm);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(429, 150, 25, 14);
		add(label);
		
		getTabla().addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent me) {
				getIdCita().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 0).toString());

				getIdMedico().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 1).toString());

				getIdPaciente().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 2).toString());
				
				getPaciente().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());
				getMedico().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 4).toString());
				/*getFecha().getSpinner().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());*/
				getCausa().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 7).toString());
				
				
			}
		});
		
	}

	
	public JSpinField getHoras() {
		return horas;
	}

	public JSpinField getMinutos() {
		return minutos;
	}

	public JComboBox getAmPm() {
		return amPm;
	}

	public JDateChooser getFecha() {
		return fecha;
	}

	public JLabel getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(JLabel idPaciente) {
		this.idPaciente = idPaciente;
	}

	public static PanelCita getInstancia() {
		if (instancia == null)
			instancia = new PanelCita();

		return instancia;
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
			getTablaPorDefecto().setDataVector(
					null,
					new String[] { "idCita","idMedico","idPaciente", "Paciente", "Medico", "Fecha",
							"Hora", "Causa"});
			ocultaColumnas(getTabla(), new int[] { 0,1,2 });
			panelContenedorTabla.add(getPanelTabla(), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}
	/***********************************************************************
 	* 		 Panel para los botones Editar y Guardar
 	***********************************************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.setBackground(Color.WHITE);
			editarGuardar.setBounds(667, 147, 206, 35);
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
			nuevoEliminar.setBackground(Color.WHITE);
			nuevoEliminar.setBounds(710, 577, 195, 43);
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}
	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(86, 54, 76, 14);
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
	public JTextField getPaciente() {
		if (paciente == null) {
			paciente = new JTextField();
			paciente.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					VentanaPaciente vp=new VentanaPaciente(getPadre(), true);
					vp.setLocationRelativeTo(null);
					vp.setVisible(true);
					paciente.setText(vp.getNombre() +" "+vp.getApellido());
					idPaciente.setText(Integer.toString(vp.getId()));
				}
			});
			paciente.setBounds(86, 79, 166, 20);
			paciente.setColumns(10);
		}
		return paciente;
	}
	public JTextField getMedico() {
		if (medico == null) {
			medico = new JTextField();
			medico.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					VentanaMedico vm=new VentanaMedico(getPadre(), true);
					vm.setLocationRelativeTo(null);
					vm.setVisible(true);
					medico.setText(vm.getNombre() +" "+vm.getApellido());
					idMedico.setText(Integer.toString(vm.getId()));
				}
			});
			medico.setBounds(86, 147, 166, 20);
			medico.setColumns(10);
		}
		return medico;
	}
	public JLabel getIdCita() {
		if (idCita == null) {
			idCita = new JLabel("");
			idCita.setVisible(false);
			idCita.setBounds(241, 11, 46, 14);
		}
		return idCita;
	}
}
