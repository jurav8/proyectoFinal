package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;

import java.awt.Color;

public class PanelReceta extends Panel{

	private JPanel panelContenedorTabla;
	private JComboBox<Paciente> paciente;
	private JComboBox<Padecimientos> padecimiento;
	private JScrollPane scrollTabla;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	
	
	public PanelReceta(){
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Receta"));
		
		JLabel lblPaciente = new JLabel("Paciente:");
		
		JLabel lblPadecimiento = new JLabel("Padecimiento:");
		
		JLabel lblMedicamento = new JLabel("Medicamentos:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnNewButton = new JButton("...");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(getScrollTabla(), GroupLayout.PREFERRED_SIZE, 832, GroupLayout.PREFERRED_SIZE)
						.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPaciente, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(143))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(getPaciente(), GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPadecimiento, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(getPadecimiento(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMedicamento, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPadecimiento)
						.addComponent(lblMedicamento)
						.addComponent(lblPaciente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(getPadecimiento(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(getPaciente(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(getScrollTabla(), GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		setLayout(groupLayout);
	}
	/*****************************************
	 *  JComboBox Paciente
	 *****************************************/
	public JComboBox<Paciente> getPaciente(){
		if(paciente == null){
			paciente = new JComboBox<Paciente>();
			paciente.setName("paciente");
		}
		return paciente;
	}
	/*****************************************
	 *  JTextField Paciente
	 *****************************************/
	public JComboBox<Padecimientos> getPadecimiento(){
		if(padecimiento == null){
			padecimiento = new JComboBox<Padecimientos>();
			padecimiento.setName("medico");
		}
		return padecimiento;
	}
	/******************************************************
 	* 		 JScrollPanel para el JTextArea de Causa
 	*****************************************************/
	public JScrollPane getScrollTabla(){
		if(scrollTabla == null){
			scrollTabla = new JScrollPane(getPanelContenedorTable());
		}
		return scrollTabla;
	}
	/*****************************************
	 *  Panel contendor del Scroll para la tabla
	 *****************************************/
	public JPanel getPanelContenedorTable(){
		if(panelContenedorTabla == null){
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			panelContenedorTabla.add(getPanelTabla(new String []{"Paciente", "Padecimiento", "Medicamento"}), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}
	/*****************************************
	 *  Panel de los botones Editar y Guardar
	 *****************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}
	/*****************************************
	 *  	Panel e los botones Nuevo y Eliminar
	 *****************************************/
	public JPanel getNuevoEliminar(){
		if(nuevoEliminar == null){
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}
}
