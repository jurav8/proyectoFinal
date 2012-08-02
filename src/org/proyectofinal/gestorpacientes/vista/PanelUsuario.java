package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;

public class PanelUsuario extends Panel {

	private JTextField nombre;
	private JTextField apellido;
	private JTextField cedula;
	private JTextField telefono;
	private JTextField celular;
	private JTextField codigo;
	private JScrollPane scrollDireccion;
	private JTextField usuario;
	private JTextField clave;
	private JTextField confirmarClave;
	private JTextArea direccion;
	private JComboBox<Especialidad> especialidad;
	private JButton especial;
	private JComboBox<Object> perfil;		/** resolver esto desde que hable con savi**/
	private JButton manteniminetoEspecialidad;
	private JPanel panelContenedorTabla;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JLabel lblCodigo;
	private JLabel lblUsuario;
	private JLabel lblDireccion;
	private JLabel lblCedula_1;
	
	public PanelUsuario(){
		super();
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Mantenimento de Usuario"));
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblAoellido = new JLabel("Apellido:");
		
		JLabel lblTelefono = new JLabel("Telefono:");
		
		JLabel lblCelular = new JLabel("Celular: ");
		
		JLabel lblPerfil = new JLabel("Perfil: ");
		
		JLabel lblClave = new JLabel("Clave:");
		
		JLabel lblConfirmarClave = new JLabel("confirmar clave: ");
		
		JLabel lblEspecialidad = new JLabel("Especialidad: ");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNombre)
					.addGap(48)
					.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblTelefono)
					.addGap(26)
					.addComponent(getTelefono(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(getLabel_2())
					.addGap(10)
					.addComponent(getUsuario(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblAoellido, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(getApellido(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addComponent(lblCelular)
					.addGap(26)
					.addComponent(getCelular(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(106)
					.addComponent(lblPerfil)
					.addGap(10)
					.addComponent(getPerfil(), GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(getPanelContenedorTable(), GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(688)
					.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getLabel_3())
							.addGap(42)
							.addComponent(getScrollDireccion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConfirmarClave)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(15)
									.addComponent(lblEspecialidad)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getConfirmarClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(getEspecialidad(), GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(getMantenimientoEspecialidad(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getLabel_4(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(getCedula(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(108)
							.addComponent(getLabel_1())
							.addGap(26)
							.addComponent(getCodigo(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(lblClave)
							.addGap(10)
							.addComponent(getClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNombre))
						.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTelefono))
						.addComponent(getTelefono(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(getLabel_2()))
						.addComponent(getUsuario(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblAoellido, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(getApellido(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCelular))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(getCelular(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPerfil))
						.addComponent(getPerfil(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(getLabel_4()))
						.addComponent(getCedula(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(getLabel_1()))
						.addComponent(getCodigo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblClave))
						.addComponent(getClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(lblConfirmarClave)
							.addGap(17)
							.addComponent(lblEspecialidad))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getConfirmarClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(getEspecialidad(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(getMantenimientoEspecialidad()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLabel_3())
								.addComponent(getScrollDireccion(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addGap(38)
					.addComponent(getPanelContenedorTable(), GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
	/********************************************************
	*	JComboBox Perfil
	*********************************************************/
	public JComboBox getPerfil(){
		if(perfil == null){
			perfil = new JComboBox<Object>();
			perfil.setName("perfil");
		}
		return perfil;
	}
	/********************************************************
	*	JTextField Nombre
	*********************************************************/
	public JTextField getNombre(){
		if(nombre == null){
			nombre = new JTextField(15);
			nombre.setName("nombre");
			nombre.setEditable(false);
		}
		return nombre;
	}
	/********************************************************
	*	JTextField Apellido
	*********************************************************/
	public JTextField getApellido(){
		if(apellido == null){
			apellido = new JTextField(15);
			apellido.setName("apellido");
			apellido.setEditable(false);
		}
		return apellido;
	}
	/********************************************************
	*	JTextField Cedula
	*********************************************************/
	public JTextField getCedula(){
		if(cedula == null){
			cedula = new JTextField(15);
			cedula.setName("cedula");
			cedula.setEditable(false);
		}
		return cedula;
	}
	/********************************************************
	*	JTextField Telefono
	*********************************************************/
	public JTextField getTelefono(){
		if(telefono == null){
			telefono = new JTextField(15);
			telefono.setName("telefono");
			telefono.setEditable(false);
		}
		return telefono;
	}
	/********************************************************
	*	JTextField Cedula
	*********************************************************/
	public JTextField getCelular(){
		if(celular == null){
			celular = new JTextField(15);
			celular.setEditable(false);
		}
		return celular;
	}
	/********************************************************
	*	JTextField Codigo
	*********************************************************/
	public JTextField getCodigo(){
		if(codigo == null){
			codigo = new JTextField(15);
			codigo.setEditable(false);
		}
		return codigo;
	}
	/********************************************************
	*	JScrollPane contenedor de Direccion
	*********************************************************/
	public JScrollPane getScrollDireccion(){
		if(scrollDireccion == null){
			scrollDireccion = new JScrollPane();
			scrollDireccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			scrollDireccion.setViewportView(getDireccion());
		}
		return scrollDireccion;
	}
	/********************************************************
	*	JTextArea Direccion
	*********************************************************/
	public JTextArea getDireccion(){
		if(direccion == null){
			direccion = new JTextArea(2, 25);
			direccion.setName("direccion");
			direccion.setLineWrap(true);
			direccion.setEditable(false);
		}
		return direccion;
	}
	/********************************************************
	*	JComboBox<Especialidad> Especialidad
	*********************************************************/
	public JComboBox<Especialidad> getEspecialidad(){
		if(especialidad == null){
			especialidad = new JComboBox<Especialidad>();
			especialidad.setName("especialidad");
		}
		return especialidad;
	}
	/********************************************************
	*	JButton Mantenimiento Especialidad
	*********************************************************/
	public JButton getMantenimientoEspecialidad(){
		if(manteniminetoEspecialidad == null){
			manteniminetoEspecialidad = new JButton("...");
			manteniminetoEspecialidad.setToolTipText("Mantenimineto especialidad");
			
		}
		return manteniminetoEspecialidad;
	}
	/********************************************************
	*	JTextField Usuario
	*********************************************************/
	public JTextField getUsuario(){
		if(usuario == null){
			usuario = new JTextField(17);
			usuario.setName("usuario");
			usuario.setEditable(false);
		}
		return usuario;
	}
	/********************************************************
	*	JTextField  clave
	*********************************************************/
	public JTextField getClave(){
		if(clave == null){
			clave = new JTextField(17);
			clave.setName("clave");
			clave.setEditable(false);
		}
		return clave;
	}
	/********************************************************
	*	JTextField Confirmar clave
	*********************************************************/
	public JTextField getConfirmarClave(){
		if(confirmarClave == null){
			confirmarClave = new JTextField(17);
			confirmarClave.setName("confirmarClave");
			confirmarClave.setEditable(false);
		}
		return confirmarClave;
	}
	/********************************************************
	*	Panel Editar y Guardar
	*********************************************************/
	public JPanel getEditarGuardar(){
		if(editarGuardar == null){
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}
	/********************************************************
	*	JButton Eliminar
	*********************************************************/
	public JPanel getNuevoEliminar(){
		if(nuevoEliminar == null){
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}

/********************************************************
	panel contenedor del ScrollPane de la tabla
*********************************************************/
	
	public JPanel getPanelContenedorTable(){
		if(panelContenedorTabla == null){
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			panelContenedorTabla.add(getPanelTabla(), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}
	private JLabel getLabel_1() {
		if (lblCodigo == null) {
			lblCodigo = new JLabel("Codigo:");
		}
		return lblCodigo;
	}
	private JLabel getLabel_2() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario: ");
		}
		return lblUsuario;
	}
	private JLabel getLabel_3() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel("Direccion:");
		}
		return lblDireccion;
	}
	private JLabel getLabel_4() {
		if (lblCedula_1 == null) {
			lblCedula_1 = new JLabel("Cedula:");
		}
		return lblCedula_1;
	}
}
