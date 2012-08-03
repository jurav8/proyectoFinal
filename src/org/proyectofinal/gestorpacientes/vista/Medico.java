package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.l2fprod.common.swing.JOutlookBar;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.Frame;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.proyectofinal.gestorpacientes.controler.ControladorCitas;
import org.proyectofinal.gestorpacientes.controler.ControladorListadoPaciente;
import org.proyectofinal.gestorpacientes.controler.ControladorPaciente;
import org.proyectofinal.gestorpacientes.controler.ControladorRecetas;
import org.proyectofinal.gestorpacientes.controler.ControladorUsuario;
import org.proyectofinal.gestorpacientes.modelo.FabricaDeModelos;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.entidades.CriterioDeBusqueda;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Medico extends JFrame {

	private static final long serialVersionUID = 1L;;
	private JPanel contentPane;
	private JLabel Opt;
	private JComboBox comboBox;
	private JTextField buscador;
	private JPanel panel1;
	private Panel panel;
	private Modelo modelo;
	private FabricaDePaneles fabricaP;
	private FabricaDeModelos fabricaM;
	private JLabel pacientes;
	private TableRowSorter<TableModel> modeloOrdenado;
	private JComboBox comboBuscador;

	public Medico() {
		init();
	}

	public void init() {

		fabricaP = new FabricaDePaneles();
		fabricaM = new FabricaDeModelos();
		setTitle("M\u00E9dico");

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
		outlookBar.setBounds(0, 0, 306, 363);
		panel_3.add(outlookBar);
		outlookBar.setBackground(new Color(248, 248, 255));

		JPanel mantenimientos = new JPanel();
		mantenimientos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null,
				null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		mantenimientos.setBackground(Color.WHITE);
		outlookBar
				.addTab("Mantenimientos",
						new ImageIcon(
								Medico.class
										.getResource("/Imagenes/icons/Action-configure-icon.png")),
						mantenimientos, null);
		mantenimientos.setLayout(null);

		pacientes = new JLabel("Pacientes");
		pacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("este si");
				panel = fabricaP.getPanel(pacientes.getText());
				modelo = fabricaM.getModelo(pacientes.getText());
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
				new ControladorPaciente(panel, modelo);
			}
		});
		pacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pacientes.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/patient-icon.png")));
		pacientes.setHorizontalAlignment(SwingConstants.CENTER);
		pacientes.setBounds(1, 11, 312, 24);
		mantenimientos.add(pacientes);

		JLabel lblNewLabel_2 = new JLabel("Citas");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel = fabricaP.getPanel("Citas");
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
				new ControladorCitas(panel, fabricaM.getModelo("Citas"));
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/Appointment-Cool-icon.png")));
		lblNewLabel_2.setBounds(1, 37, 312, 24);
		mantenimientos.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Recetas");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel = fabricaP.getPanel("Recetas");
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
				new ControladorRecetas(panel, fabricaM.getModelo("Recetas"));
			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/pill-icon.png")));
		lblNewLabel_3.setBounds(2, 66, 311, 24);
		mantenimientos.add(lblNewLabel_3);
		
		JLabel lblPruebasDeLaboratorio = new JLabel("Pruebas de laboratorio");
		lblPruebasDeLaboratorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		lblPruebasDeLaboratorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPruebasDeLaboratorio.setIcon(new ImageIcon(Medico.class.getResource("/Imagenes/icons/Lab-icon.png")));
		lblPruebasDeLaboratorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPruebasDeLaboratorio.setBounds(1, 95, 312, 24);
		mantenimientos.add(lblPruebasDeLaboratorio);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlightText);
		separator_2.setForeground(SystemColor.control);
		separator_2.setBounds(0, 36, 313, 3);
		mantenimientos.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(SystemColor.textHighlightText);
		separator_3.setForeground(SystemColor.control);
		separator_3.setBounds(0, 63, 313, 3);
		mantenimientos.add(separator_3);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(SystemColor.control);
		separator_6.setBackground(SystemColor.textHighlightText);
		separator_6.setBounds(1, 89, 313, 3);
		mantenimientos.add(separator_6);

		JPanel busqueda = new JPanel();
		busqueda.setSize(new Dimension(20, 13));
		busqueda.setSize(50, 10);
		busqueda.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
				Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		busqueda.setBackground(Color.WHITE);
		outlookBar.addTab(
				"B\u00FAsqueda",
				new ImageIcon(Medico.class
						.getResource("/Imagenes/icons/Search-icon (1).png")),
				busqueda, null);
		busqueda.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Buscar pacientes por:");
		lblNewLabel_4.setBounds(90, 12, 120, 16);
		busqueda.add(lblNewLabel_4);

		comboBuscador = new JComboBox();
		comboBuscador.setModel(new DefaultComboBoxModel(CriterioDeBusqueda
				.values()));
		comboBuscador.setBounds(55, 33, 201, 22);
		busqueda.add(comboBuscador);

		JLabel lblTodoOParte = new JLabel("Todo o parte de la palabra a buscar");
		lblTodoOParte.setBounds(54, 67, 202, 16);
		busqueda.add(lblTodoOParte);

		buscador = new JTextField();
		buscador.setBounds(55, 86, 201, 20);
		busqueda.add(buscador);
		buscador.setColumns(10);

		buscador.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				// Filtro para el buscador
				panel = fabricaP.getPanel("Lista de pacientes");
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
				new ControladorListadoPaciente(panel, fabricaM
						.getModelo("Pacientes"));
				modeloOrdenado = new TableRowSorter<TableModel>(panel
						.getTablaPorDefecto());
				panel.getTabla().setRowSorter(modeloOrdenado);
				if (comboBuscador.getSelectedItem().equals(
						CriterioDeBusqueda.nombre)) {
					modeloOrdenado.setRowFilter(RowFilter.regexFilter(
							buscador.getText(), 1));
				}
				else if(comboBuscador.getSelectedItem().equals(
						CriterioDeBusqueda.apellido)) {
					modeloOrdenado.setRowFilter(RowFilter.regexFilter(
							buscador.getText(), 2));
				}
				else if(comboBuscador.getSelectedItem().equals(
						CriterioDeBusqueda.cedula)) {
					modeloOrdenado.setRowFilter(RowFilter.regexFilter(
							buscador.getText(), 3));
				}
			}
		});

		JPanel listados = new JPanel();
		listados.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
				Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		listados.setBackground(Color.WHITE);
		outlookBar
				.addTab("Listados",
						new ImageIcon(
								Medico.class
										.getResource("/Imagenes/icons/distributor-report-icon.png")),
						listados, null);
		listados.setLayout(null);

		JLabel lblListaDeMdicos = new JLabel("Lista de m\u00E9dicos");
		lblListaDeMdicos.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListaDeMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeMdicos.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/nurse-icon.png")));
		lblListaDeMdicos.setBounds(0, 26, 304, 16);
		listados.add(lblListaDeMdicos);

		JLabel lblListaDePacientes = new JLabel("Lista de pacientes");
		lblListaDePacientes.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListaDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePacientes.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/patient-icon.png")));
		lblListaDePacientes.setBounds(0, 81, 304, 16);
		listados.add(lblListaDePacientes);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 59, 304, 3);
		listados.add(separator_4);

		JPanel estadisticas = new JPanel();
		estadisticas.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null,
				null, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		estadisticas.setBackground(Color.WHITE);
		outlookBar.addTab(
				"Estad\u00EDsticas",
				new ImageIcon(Medico.class
						.getResource("/Imagenes/icons/statistics-icon.png")),
				estadisticas, null);
		estadisticas.setLayout(null);

		JLabel lbldicos = new JLabel("M\u00E9dicos mas visitados");
		lbldicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel = fabricaP.getPanel("Top medicos");
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
			}
		});
		lbldicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbldicos.setHorizontalAlignment(SwingConstants.CENTER);
		lbldicos.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/nurse-icon.png")));
		lbldicos.setBounds(0, 26, 304, 25);
		estadisticas.add(lbldicos);

		JLabel lblPadecimientos = new JLabel("Padecimientos mas frecuentes");
		lblPadecimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel = fabricaP.getPanel("Top padecimientos");
				panel.setVisible(true);
				panel.setPadre(getPadre());
				agregaPanel(panel);
			}
		});
		lblPadecimientos.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPadecimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPadecimientos.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/icons/broken-icon.png")));
		lblPadecimientos.setBounds(0, 91, 304, 16);
		estadisticas.add(lblPadecimientos);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 68, 304, 3);
		estadisticas.add(separator_5);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/Content.png")));
		lblNewLabel.setBounds(0, 0, 306, 618);
		panel_3.add(lblNewLabel);

		panel1 = new JPanel();
		panel1.setLayout(null);

		((JComponent) panel1).setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(336, 103, 930, 618);
		panel1.add(PanelPaciente.getInstancia());
		new ControladorPaciente(PanelPaciente.getInstancia(),
				fabricaM.getModelo("Pacientes"));
		contentPane.add(panel1);

		JLabel lblAyuda = new JLabel("Ayuda");
		lblAyuda.setIcon(new ImageIcon(Medico.class
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
		Opt.setIcon(new ImageIcon(Medico.class
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
		lblNewLabel1.setIcon(new ImageIcon(Medico.class
				.getResource("/Imagenes/background.png")));
		lblNewLabel1.setBounds(0, 0, 1276, 750);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel1);
	}

	public JLabel getPacientes() {
		return pacientes;
	}

	public void setPacientes(JLabel pacientes) {
		this.pacientes = pacientes;
	}

	public Frame getPadre() {
		return this;
	}

	public void agregaPanel(JPanel panelIn2) {
		panel1.removeAll();
		panel1.repaint();
		panel1.updateUI();
		panel1.add(panelIn2);

	}
}
