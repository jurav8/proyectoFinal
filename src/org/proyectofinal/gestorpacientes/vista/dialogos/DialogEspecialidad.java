package org.proyectofinal.gestorpacientes.vista.dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.proyectofinal.gestorpacientes.controler.ControladorEspecialidad;
import org.proyectofinal.gestorpacientes.modelo.ModeloEspecialidad;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class DialogEspecialidad extends IDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedorTabla;
	private JTextField codigo;
	private JScrollPane scrollTabla;
	private JTextField nombre;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	
	public DialogEspecialidad(Frame padre, boolean modal) {
		super(padre, modal);
		getContentPane().setBackground(Color.WHITE);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public void init(){
		setSize(650, 430);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		
		JLabel lblNombre = new JLabel("Nombre:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblCodigo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(getCodigo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(402)
					.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(getScrollTabla(), GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(402)
					.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCodigo))
						.addComponent(getCodigo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNombre))
						.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(getScrollTabla(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
		//new ControladorEspecialidad(this,ModeloEspecialidad.getInstancia(false, false));
		
	}
	
	/***************************************************
	 *  TextField Codigo
	 **************************************************/
	public JTextField getCodigo(){
		if(codigo == null){
			codigo = new JTextField(10);
			codigo.setName("codigo");
		}
		return codigo;
	}
	/***************************************************
	 *   TextField Nombre
	 **************************************************/
	public JTextField getNombre(){
		if(nombre == null){
			nombre = new JTextField(30);
			nombre.setName("nombre");
		}
		return nombre;
	}
	/***************************************************
	 *   SCrollPanel de la tabla
	 **************************************************/
	public JScrollPane getScrollTabla(){
		if(scrollTabla == null){
			scrollTabla = new JScrollPane(getPanelContenedorTable());
			scrollTabla.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return scrollTabla;
	}
	/***************************************************
	 *   TextField panel contenedor de la tabla 
	 **************************************************/
	public JPanel getPanelContenedorTable(){
		if(panelContenedorTabla == null){
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			getTablaPorDefecto().setDataVector(
					null,
					new String[] {"Codigo","Especialidad"});
			panelContenedorTabla.add(getPanelTabla(), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}
	/***************************************************
	 *   PanelContenedor de los botones Editar y Guardar
	 **************************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}
	/***************************************************
	 *   PanelContenedor de los botones Nuevo y Eliminar
	 **************************************************/
	public JPanel getNuevoEliminar(){
		if(nuevoEliminar == null){
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}
}
