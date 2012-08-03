package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import javax.swing.DefaultComboBoxModel;

import org.proyectofinal.gestorpacientes.controler.ControladorEspecialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Perfiles;
import org.proyectofinal.gestorpacientes.vista.dialogos.DialogEspecialidad;
import org.proyectofinal.gestorpacientes.vista.dialogos.VentanaPaciente;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JButton especial;
	private JComboBox<Object> perfil;		
	private JPanel panelContenedorTabla;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JLabel lblCodigo;
	private JLabel lblUsuario;
	private JLabel lblDireccion;
	private JLabel lblCedula_1;
	private JTextField especialidad;
	private JLabel idUsuario;
	private JLabel idPersona;
	
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
		
		getTabla().addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent me) {
				
				getIdPersona().setText(getTablaPorDefecto().getValueAt(
						getTabla().getSelectedRow(), 10).toString());
				getIdUsuario().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 0).toString());
				getCodigo().setText(getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 0).toString());
				getUsuario().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 1).toString());
				getClave().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 2).toString());
				getNombre().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());

				getApellido().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 4).toString());
				
				getTelefono().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 5).toString());
				getCelular().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 6).toString());
				getCedula().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 8).toString());
				getDireccion().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 7).toString());
			}});
		
		especialidad = new JTextField();
		especialidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DialogEspecialidad vp = new DialogEspecialidad(getPadre(), true);
				vp.setLocationRelativeTo(null);
				vp.setVisible(true);
				
			/*	paciente.setText(vp.getNombre() + " " + vp.getApellido());
				idPaciente.setText(Integer.toString(vp.getId()));*/
			}
		});
		especialidad.setColumns(10);
		
		idUsuario = new JLabel("");
		idUsuario.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
										.addComponent(especialidad, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(getConfirmarClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(idUsuario)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(92)
											.addComponent(getIdPersona())))
									.addPreferredGap(ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
									.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(getPanelContenedorTable(), GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE))))
					.addGap(42))
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
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEspecialidad)
								.addComponent(especialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(getConfirmarClave(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLabel_3())
								.addComponent(getScrollDireccion(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addGap(38)
					.addComponent(getPanelContenedorTable(), GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getIdPersona())
								.addComponent(idUsuario))))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	public JLabel getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(JLabel idUsuario) {
		this.idUsuario = idUsuario;
	}
	public JTextField getEspecialidad() {
		return especialidad;
	}
	/********************************************************
	*	JComboBox Perfil
	*********************************************************/
	public JComboBox getPerfil(){
		if(perfil == null){
			perfil = new JComboBox<Object>();
			perfil.setModel(new DefaultComboBoxModel(Perfiles.values()));
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
		}
		return telefono;
	}
	/********************************************************
	*	JTextField Cedula
	*********************************************************/
	public JTextField getCelular(){
		if(celular == null){
			celular = new JTextField(15);
		}
		return celular;
	}
	/********************************************************
	*	JTextField Codigo
	*********************************************************/
	public JTextField getCodigo(){
		if(codigo == null){
			codigo = new JTextField(15);
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
		}
		return direccion;
	}
	/********************************************************
	*	JTextField Usuario
	*********************************************************/
	public JTextField getUsuario(){
		if(usuario == null){
			usuario = new JTextField(17);
			usuario.setName("usuario");
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
			getTablaPorDefecto().setDataVector(
					null,
					new String[] {"id","Usuario","Cotraseña", "Nombre", "Apellido" , "Teléfono",
							"Celular","Dirección", "Cédula","Perfil","IdPersona"});
			ocultaColumnas(getTabla(), new int[] {0,1,2,10});
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
	public JLabel getIdPersona() {
		if (idPersona == null) {
			idPersona = new JLabel("");
			idPersona.setVisible(false);
		}
		return idPersona;
	}
	public void setIdPersona(JLabel idPersona) {
		this.idPersona = idPersona;
	}
}
