package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;

import com.l2fprod.common.swing.JButtonBar;
import javax.swing.JButton;
import com.l2fprod.common.swing.JOutlookBar;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Frame;
import javax.swing.border.SoftBevelBorder;


import org.proyectofinal.gestorpacientes.controler.ControladorCitas;
import org.proyectofinal.gestorpacientes.controler.ControladorPaciente;
import org.proyectofinal.gestorpacientes.modelo.ManejardoDeEntidades;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrador extends JFrame {

	private static final long serialVersionUID = 1L;;
	private JPanel contentPane;
	private JLabel Opt;
	private JComboBox comboBox;
	private JTextField textField;
	private JPanel panelIn;
	private JPanel panel;
	private FabricaDePaneles fabrica;

	public Administrador() {
		init();
	}

	public void init() {

		fabrica = new FabricaDePaneles();
		setTitle("Administrador");

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1284, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Font f = new Font("Tahoma", Font.BOLD, 11);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBounds(10, 103, 306, 618);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JOutlookBar outlookBar = new JOutlookBar();
		outlookBar.setAutoscrolls(true);
		outlookBar.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		outlookBar.setBounds(0, 0, 306, 341);
		panel_3.add(outlookBar);
		outlookBar.setBackground(new Color(248, 248, 255));

		JPanel mantenimientos = new JPanel();
		mantenimientos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null,
				null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		mantenimientos.setBackground(Color.WHITE);
		outlookBar
				.addTab("Mantenimientos",
						new ImageIcon(
								Administrador.class
										.getResource("/Imagenes/icons/Action-configure-icon.png")),
						mantenimientos, null);
		mantenimientos.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Pacientes");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelIn = fabrica.getPanel("Pacientes");
				panelIn.setVisible(true);
				agregaPanel(panelIn);
				new ControladorPaciente((PanelPaciente) panelIn,
						ManejardoDeEntidades.getEnlace(false, false));

			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/patient-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1, 28, 312, 24);
		mantenimientos.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Citas");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelIn = fabrica.getPanel("Citas");
				panelIn.setVisible(true);
				agregaPanel(panelIn);
				new ControladorCitas((PanelCita) panelIn,
						ManejardoDeEntidades.getEnlace(false, false));
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/Appointment-Cool-icon.png")));
		lblNewLabel_2.setBounds(1, 54, 312, 24);
		mantenimientos.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Recetas");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/pill-icon.png")));
		lblNewLabel_3.setBounds(2, 83, 311, 24);
		mantenimientos.add(lblNewLabel_3);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUsuarios.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/Add-Male-User-icon.png")));
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(1, 0, 312, 24);
		mantenimientos.add(lblUsuarios);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlightText);
		separator_2.setForeground(SystemColor.control);
		separator_2.setBounds(0, 53, 313, 3);
		mantenimientos.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(SystemColor.textHighlightText);
		separator_3.setForeground(SystemColor.control);
		separator_3.setBounds(0, 80, 313, 3);
		mantenimientos.add(separator_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.control);
		separator_1.setBackground(SystemColor.textHighlightText);
		separator_1.setBounds(1, 25, 313, 3);
		mantenimientos.add(separator_1);

		JPanel busqueda = new JPanel();
		busqueda.setSize(new Dimension(20, 13));
		busqueda.setSize(50, 10);
		busqueda.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
				Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		busqueda.setBackground(Color.WHITE);
		outlookBar.addTab(
				"B\u00FAsqueda",
				new ImageIcon(Administrador.class
						.getResource("/Imagenes/icons/Search-icon (1).png")),
				busqueda, null);
		busqueda.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Buscar pacientes por:");
		lblNewLabel_4.setBounds(90, 12, 120, 16);
		busqueda.add(lblNewLabel_4);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Nombre",
				"Apellido", "C\u00E9dula" }));
		comboBox_1.setBounds(55, 33, 201, 22);
		busqueda.add(comboBox_1);

		JLabel lblTodoOParte = new JLabel("Todo o parte de la palabra a buscar");
		lblTodoOParte.setBounds(54, 67, 202, 16);
		busqueda.add(lblTodoOParte);

		textField = new JTextField();
		textField.setBounds(55, 86, 201, 20);
		busqueda.add(textField);
		textField.setColumns(10);

		JPanel listados = new JPanel();
		listados.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
				Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		listados.setBackground(Color.WHITE);
		outlookBar
				.addTab("Listados",
						new ImageIcon(
								Administrador.class
										.getResource("/Imagenes/icons/distributor-report-icon.png")),
						listados, null);
		listados.setLayout(null);

		JLabel lblListaDeMdicos = new JLabel("Lista de m\u00E9dicos");
		lblListaDeMdicos.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListaDeMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeMdicos.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/nurse-icon.png")));
		lblListaDeMdicos.setBounds(0, 21, 304, 16);
		listados.add(lblListaDeMdicos);

		JLabel lblListaDePacientes = new JLabel("Lista de pacientes");
		lblListaDePacientes.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListaDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePacientes.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/patient-icon.png")));
		lblListaDePacientes.setBounds(0, 76, 304, 16);
		listados.add(lblListaDePacientes);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 55, 304, 3);
		listados.add(separator_4);

		JPanel estadisticas = new JPanel();
		estadisticas.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null,
				null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		estadisticas.setBackground(Color.WHITE);
		outlookBar.addTab(
				"Estad\u00EDsticas",
				new ImageIcon(Administrador.class
						.getResource("/Imagenes/icons/statistics-icon.png")),
				estadisticas, null);
		estadisticas.setLayout(null);

		JLabel lbldicos = new JLabel("M\u00E9dicos mas visitados");
		lbldicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbldicos.setHorizontalAlignment(SwingConstants.CENTER);
		lbldicos.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/nurse-icon.png")));
		lbldicos.setBounds(0, 15, 304, 25);
		estadisticas.add(lbldicos);

		JLabel lblPadecimientos = new JLabel("Padecimientos mas frecuentes");
		lblPadecimientos.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPadecimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPadecimientos.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/broken-icon.png")));
		lblPadecimientos.setBounds(0, 76, 304, 16);
		estadisticas.add(lblPadecimientos);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 55, 304, 3);
		estadisticas.add(separator_5);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/Content.png")));
		lblNewLabel.setBounds(0, 0, 306, 618);
		panel_3.add(lblNewLabel);

		panel = new JPanel();
		panel.setLayout(null);

		((JComponent) panel).setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(336, 103, 930, 618);
		panel.add(PanelPaciente.getInstancia());
		contentPane.add(panel);

		JLabel lblAyuda = new JLabel("Ayuda");
		lblAyuda.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/Help-icon.png")));
		lblAyuda.setForeground(Color.DARK_GRAY);
		lblAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAyuda.setBounds(1020, 40, 112, 49);
		contentPane.add(lblAyuda);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(1125, 40, 19, 45);
		contentPane.add(separator);

		Opt = new JLabel("Cerrar sesi\u00F3n");
		Opt.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/icons/logout-icon.png")));
		Opt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Opt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Opt.setForeground(Color.DARK_GRAY);
		Opt.setBounds(1142, 40, 124, 49);
		contentPane.add(Opt);

		Font f1 = new Font("Tahoma", Font.BOLD, 11);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 0, 0, 0);
		getContentPane().add(scrollPane1);

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBackground(new Color(248, 248, 255));
		lblNewLabel1.setIcon(new ImageIcon(Administrador.class
				.getResource("/Imagenes/background.png")));
		lblNewLabel1.setBounds(0, 0, 1276, 750);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel1);
	}

	public void agregaPanel(JPanel panelIn2){
		panel.removeAll();
		panel.repaint();
		panel.updateUI();
		panel.add(panelIn2);
		
	}
}
