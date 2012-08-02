package org.proyectofinal.gestorpacientes.vista;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import org.proyectofinal.gestorpacientes.controler.ControladorVM;
import org.proyectofinal.gestorpacientes.controler.ControladorVP;
import org.proyectofinal.gestorpacientes.modelo.FabricaDeModelos;

public class VentanaMedico extends JDialog{

	private JButton btnSeleccionar;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private String nombre;
	private String apellido;
	private int id;
	private DefaultTableModel dm;
	@SuppressWarnings("unused")
	private ControladorVM cvp;
	private FabricaDeModelos fabricaM;
	private Frame padre;
	
	public VentanaMedico(Frame padre, boolean modal) {
		super(padre,modal);
		this.setPadre(padre);
		init();
	}
		
	public void init(){
		fabricaM=new FabricaDeModelos();
		getContentPane().setBackground(Color.WHITE);
		setSize(443, 490);
		setTitle("Medicos");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(26, 69, 391, 366);
		getContentPane().add(scrollPane);
		
		dm=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id","Nombre", "Apellido", "Cedula"
				}
			);
		
		table = new JTable();
		table.setModel(dm);
		scrollPane.setViewportView(table);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setIcon(new ImageIcon(VentanaMedico.class.getResource("/Imagenes/icons/Actions-dialog-ok-apply-icon.png")));
		btnSeleccionar.setBounds(302, 23, 115, 23);
		getContentPane().add(btnSeleccionar);
		
		textField = new JTextField();
		textField.setBounds(97, 23, 195, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel Buscar = new JLabel("Buscar");
		Buscar.setIcon(new ImageIcon(VentanaMedico.class.getResource("/Imagenes/icons/search-icon.png")));
		Buscar.setBounds(27, 29, 61, 14);
		getContentPane().add(Buscar);
		
		cvp=new ControladorVM(this,fabricaM.getModelo("Medicos"));
		
	}

	public DefaultTableModel getDm() {
		return dm;
	}

	public void setDm(DefaultTableModel dm) {
		this.dm = dm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String toString(){
		return "VentanaPaciente";		
	}

	public Frame getPadre() {
		return padre;
	}

	public void setPadre(Frame padre) {
		this.padre = padre;
	}
}

	


