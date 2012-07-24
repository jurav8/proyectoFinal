package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class PanelPaciente extends Panel {

	private JTextField nombre;
	private JTextField apellido;
	private JTextField cedula;
	private JTextField telefono;
	private JTextArea direccion;
	private JComboBox<Boolean> fumador;
	private JButton foto;
	private JPanel editarGuardar;
	private JPanel panelContenedorTabla;
	private JPanel nuevoEliminar;
	private JScrollPane scrollDireccion;
	private JLabel lblDireccioon;
	private JLabel lblAlergia;
	private JLabel lblFumador;
	private JTextArea alergia;
	private static PanelPaciente instancia;

	private PanelPaciente() {
		super();
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Paciente"));

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblApellido = new JLabel("Apellido:");

		JLabel lblCedula = new JLabel("Cedula:");

		JLabel lblNacimiento = new JLabel("Nacimiento:");

		JLabel lblTelefono = new JLabel("Telefono:");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JDateChooser dateChooser = new JDateChooser();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(49)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lblNombre)
														.addComponent(
																lblApellido)
														.addComponent(lblCedula))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																getNombre(),
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																getApellido(),
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																getCedula(),
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNacimiento)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				lblTelefono))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				getLblDireccioon(),
																				GroupLayout.PREFERRED_SIZE,
																				46,
																				GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(6)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								getTelefono(),
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								getScrollDireccion(),
																								GroupLayout.PREFERRED_SIZE,
																								166,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				dateChooser,
																				GroupLayout.PREFERRED_SIZE,
																				168,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(24)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				getLblAlergia(),
																				GroupLayout.PREFERRED_SIZE,
																				46,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				getFumador(),
																				GroupLayout.PREFERRED_SIZE,
																				166,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																getEditarGuardar(),
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(5)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								scrollPane,
																								GroupLayout.PREFERRED_SIZE,
																								187,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								getLblFumador()))))
										.addGap(24)
										.addComponent(getFoto(),
												GroupLayout.PREFERRED_SIZE,
												130, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(49)
										.addComponent(
												getPanelContenedorTable(),
												GroupLayout.PREFERRED_SIZE,
												841, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(695)
										.addComponent(getNuevoEliminar(),
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(16)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(14)
																		.addComponent(
																				lblNombre)
																		.addGap(42)
																		.addComponent(
																				lblApellido)
																		.addGap(32)
																		.addComponent(
																				lblCedula))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(11)
																		.addComponent(
																				getNombre(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(36)
																		.addComponent(
																				getApellido(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(26)
																		.addComponent(
																				getCedula(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				getLblAlergia())
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPane,
																				GroupLayout.PREFERRED_SIZE,
																				33,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(4)
																		.addComponent(
																				getLblFumador())
																		.addGap(11)
																		.addComponent(
																				getFumador(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addComponent(
																				getEditarGuardar(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				getFoto(),
																				GroupLayout.PREFERRED_SIZE,
																				130,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(14)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												dateChooser,
																												GroupLayout.PREFERRED_SIZE,
																												22,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(31)
																										.addComponent(
																												getTelefono(),
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(26)
																										.addComponent(
																												getScrollDireccion(),
																												GroupLayout.PREFERRED_SIZE,
																												35,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblNacimiento)
																										.addGap(42)
																										.addComponent(
																												lblTelefono)
																										.addGap(32)
																										.addComponent(
																												getLblDireccioon())))))
										.addGap(47)
										.addComponent(
												getPanelContenedorTable(),
												GroupLayout.PREFERRED_SIZE,
												323, GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addComponent(getNuevoEliminar(),
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)));

		alergia = new JTextArea();
		scrollPane.setViewportView(alergia);
		setLayout(groupLayout);
	}

	public static PanelPaciente getInstancia() {
		if (instancia == null)
			instancia = new PanelPaciente();

		return instancia;
	}

	/*****************************************
	 * Textarea Alergia
	 *****************************************/
	public JTextArea getAlergia() {
		return alergia;
	}

	/*****************************************
	 * JTextField Nombre
	 *****************************************/
	public JTextField getNombre() {
		if (nombre == null) {
			nombre = new JTextField(20);
			nombre.setName("nombre");
		}
		return nombre;
	}

	/*****************************************
	 * JTextField Apellido
	 *****************************************/
	public JTextField getApellido() {
		if (apellido == null) {
			apellido = new JTextField(20);
			apellido.setName("apellido");
		}
		return apellido;
	}

	/*****************************************
	 * JTextField Telefono
	 *****************************************/
	public JTextField getTelefono() {
		if (telefono == null) {
			telefono = new JTextField(20);
			telefono.setName("telefono");
		}
		return telefono;
	}

	/*****************************************
	 * JTextField Cedula
	 *****************************************/
	public JTextField getCedula() {
		if (cedula == null) {
			cedula = new JTextField(20);
			cedula.setName("cedula");
		}
		return cedula;
	}

	/*****************************************
	 * Scroll Direccion
	 *****************************************/
	public JScrollPane getScrollDireccion() {
		if (scrollDireccion == null) {
			scrollDireccion = new JScrollPane();
			scrollDireccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
					null, null));
			scrollDireccion.setViewportView(getDireccion());
		}
		return scrollDireccion;
	}

	/*****************************************
	 * JTextField Direccion
	 *****************************************/
	public JTextArea getDireccion() {
		if (direccion == null) {
			direccion = new JTextArea(2, 25);
			direccion.setName("direccion");
			direccion.setLineWrap(true);
		}
		return direccion;
	}

	/*****************************************
	 * JComboBox Fumador
	 *****************************************/
	public JComboBox<Boolean> getFumador() {
		if (fumador == null) {
			fumador = new JComboBox<Boolean>();
			fumador.setModel(new DefaultComboBoxModel(
					new String[] { "Si", "No" }));
			fumador.setName("fumador");
		}
		return fumador;
	}

	/*****************************************
	 * JButton Foto
	 *****************************************/
	private JButton getFoto() {
		if (foto == null) {
			foto = new JButton();
			foto.setName("foto");
			cambarImangen(foto, "/Imagenes/icons/Head-physician-icon.png");
		}
		return foto;
	}

	/******************************************
	 * panel contenedor del ScrollPane de la tabla
	 *******************************************/
	public JPanel getPanelContenedorTable() {
		if (panelContenedorTabla == null) {
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			panelContenedorTabla.add(getPanelTabla(new String[] { "Nombre",
					"Apellido", "Telefono", "Cedula", "Direccion", "Alergia",
					"Fumador" }), BorderLayout.CENTER);
		}
		return panelContenedorTabla;
	}

	/*****************************************
	 * Panel de los botones Editar y Guardar
	 *****************************************/
	public JPanel getEditarGuardar() {
		if (editarGuardar == null) {
			editarGuardar = new JPanel(new FlowLayout());
			editarGuardar.setBackground(Color.WHITE);
			editarGuardar.add(getEditar());
			editarGuardar.add(getGuardar());
		}
		return editarGuardar;
	}

	/*****************************************
	 * Panel de los botones Nuevo y Eliminar
	 *****************************************/
	public JPanel getNuevoEliminar() {
		if (nuevoEliminar == null) {
			nuevoEliminar = new JPanel(new FlowLayout());
			nuevoEliminar.setBackground(Color.WHITE);
			nuevoEliminar.add(getNuevo());
			nuevoEliminar.add(getEliminar());
		}
		return nuevoEliminar;
	}

	private JLabel getLblDireccioon() {
		if (lblDireccioon == null) {
			lblDireccioon = new JLabel("Direccion");
		}
		return lblDireccioon;
	}

	private JLabel getLblAlergia() {
		if (lblAlergia == null) {
			lblAlergia = new JLabel("Alergias:");
		}
		return lblAlergia;
	}

	private JLabel getLblFumador() {
		if (lblFumador == null) {
			lblFumador = new JLabel("Fumador:");
		}
		return lblFumador;
	}
}
