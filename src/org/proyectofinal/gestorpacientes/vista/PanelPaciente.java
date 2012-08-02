package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.proyectofinal.gestorpacientes.controler.LectorDeArchivos;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelPaciente extends Panel {

	private static PanelPaciente instancia;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField cedula;
	private JTextField telefono;
	private JTextArea direccion;
	private JComboBox<Boolean> fumador;
	private JPanel editarGuardar;
	private JPanel panelContenedorTabla;
	private JPanel nuevoEliminar;
	private JScrollPane scrollDireccion;
	private JLabel lblDireccioon;
	private JLabel lblAlergia;
	private JLabel lblFumador;
	private JTextArea alergia;
	private String ruta="/Imagenes/icons/patient-icongrand.png";
	private JTextField celular;
	private JLabel foto;
	private MaskFormatter mascaraTel;
	private JDateChooser fecha;
	private JLabel idPaciente;
	

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

		fecha = new JDateChooser();

		JLabel lblCelular = new JLabel("Celular:");
		
		getTabla().addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent me) {
				getIdPaciente().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 0).toString());

				getNombre().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 1).toString());

				getApellido().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 2).toString());
				
				getTelefono().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());
				getCelular().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 4).toString());
				getCedula().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());
				getDireccion().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 6).toString());
				getAlergia().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 7).toString());
				getFumador().setSelectedIndex(Integer.valueOf(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 8).toString()));
				/*getFecha().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 9).toString());*/
					new LectorDeArchivos(getMe()).cargar(getFoto(), getTablaPorDefecto().getValueAt(
							getTabla().getSelectedRow(), 10).toString());	
				
			
			}});
		
	
		try {
			mascaraTel= new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
       
        celular = new JFormattedTextField(mascaraTel);
		celular.setName("cedula");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNombre)
										.addGap(18))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCelular, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCedula))
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(celular, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNacimiento)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(lblTelefono))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(getLblDireccioon(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
										.addComponent(getApellido(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(getTelefono())
												.addComponent(getScrollDireccion(), GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))))
								.addComponent(getCedula(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(getLblAlergia(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(getFumador(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
										.addComponent(getLblFumador())))
								.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(getFoto(), GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(getIdPaciente())
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(getPanelContenedorTable(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(getTelefono(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(getScrollDireccion(), GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNacimiento)
									.addGap(42)
									.addComponent(lblTelefono)
									.addGap(32)
									.addComponent(getLblDireccioon()))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblApellido))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(getNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getApellido(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(getCedula(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCedula))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCelular)
								.addComponent(celular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getLblAlergia())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(getLblFumador())
							.addGap(11)
							.addComponent(getFumador(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(getEditarGuardar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(getFoto(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35)
					.addComponent(getPanelContenedorTable(), GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getNuevoEliminar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getIdPaciente()))
					.addGap(9))
		);

		alergia = new JTextArea();
		scrollPane.setViewportView(alergia);
		setLayout(groupLayout);
	}

	public JDateChooser getFecha() {
		return fecha;
	}

	public JTextField getCelular() {
		return celular;
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
			telefono = new JFormattedTextField(mascaraTel);
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

	/******************************************
	 * panel contenedor del ScrollPane de la tabla
	 *******************************************/
	public JPanel getPanelContenedorTable() {
		if (panelContenedorTabla == null) {
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			getTablaPorDefecto().setDataVector(
					null,
					new String[] { "IdPaciente","Nombre", "Apellido", "Telefono","Celular","Cedula",
							"Direccion", "Alergia", "Fumador","Fecha de nacimiento","Foto" });
			ocultaColumnas(getTabla(), new int[] { 0,10 });
			panelContenedorTabla.add(getPanelTabla(), BorderLayout.CENTER);
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

	public String getRuta() {
		// TODO Auto-generated method stub
		return ruta;
	}

	public JLabel getFoto() {
		if (foto == null) {
			foto = new JLabel("");
			foto.setHorizontalAlignment(SwingConstants.CENTER);
			foto.setIcon(new ImageIcon(PanelPaciente.class.getResource(ruta)));
			foto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			foto.addMouseListener(new LectorDeArchivos(getMe()));
			foto.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return foto;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public PanelPaciente getMe(){
		return this;
		
	}

	public JLabel getIdPaciente() {
		if (idPaciente == null) {
			idPaciente = new JLabel("");
		}
		return idPaciente;
	}
}
