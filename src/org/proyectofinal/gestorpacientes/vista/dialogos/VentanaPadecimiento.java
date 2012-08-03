package org.proyectofinal.gestorpacientes.vista.dialogos;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import org.proyectofinal.gestorpacientes.controler.ControladorPadecimiento;
import org.proyectofinal.gestorpacientes.modelo.FabricaDeModelos;

public class VentanaPadecimiento extends JDialog{

	private JButton btnSeleccionar;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private String nombre;
	private int id;
	private DefaultTableModel dm;
	private FabricaDeModelos fabricaM;
	private Frame padre;
	private JLabel lblCodigo;
	private JTextField codigo;
	private JLabel lblNombre;
	private JTextField nombres;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private TableRowSorter<TableModel> modeloOrdenado;
	
	public VentanaPadecimiento(Frame padre, boolean modal) {
		super(padre,modal);
		this.setPadre(padre);
		init();
	}
		
	public void init(){
		fabricaM=new FabricaDeModelos();
		getContentPane().setBackground(Color.WHITE);
		setSize(443, 500);
		setTitle("Padecimientos");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(27, 108, 391, 303);
		getContentPane().add(scrollPane);
		
		dm=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nombre"
				}
			);
		
		table = new JTable();
		table.setModel(dm);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				getCodigo().setText(getDm().getValueAt(
								getTable().getSelectedRow(), 0).toString());
				getNombres().setText(getDm().getValueAt(
						getTable().getSelectedRow(), 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setIcon(new ImageIcon(VentanaPadecimiento.class.getResource("/Imagenes/icons/Actions-dialog-ok-apply-icon.png")));
		btnSeleccionar.setBounds(302, 23, 115, 23);
		getContentPane().add(btnSeleccionar);
		
		textField = new JTextField();
		textField.setBounds(87, 23, 195, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyAdapter() {

			@Override
		  	public void keyReleased(KeyEvent arg0) {
		  		//Filtro para el buscador
		  		modeloOrdenado=new TableRowSorter<TableModel>(dm);
				table.setRowSorter(modeloOrdenado);
				modeloOrdenado.setRowFilter(RowFilter.regexFilter(textField.getText(),0,1));				
		  	}
		  });
		
		JLabel Buscar = new JLabel("Buscar");
		Buscar.setIcon(new ImageIcon(VentanaPadecimiento.class.getResource("/Imagenes/icons/search-icon.png")));
		Buscar.setBounds(27, 29, 61, 14);
		getContentPane().add(Buscar);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(26, 69, 46, 14);
		getContentPane().add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(66, 66, 148, 23);
		getContentPane().add(codigo);
		codigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(224, 69, 46, 14);
		getContentPane().add(lblNombre);
		
		nombres = new JTextField();
		nombres.setColumns(10);
		nombres.setBounds(269, 66, 148, 23);
		getContentPane().add(nombres);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(VentanaPadecimiento.class.getResource("/Imagenes/icons/Action-edit-add-icon.png")));
		btnAgregar.setBounds(27, 427, 115, 23);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(VentanaPadecimiento.class.getResource("/Imagenes/icons/Edit-icon.png")));
		btnEditar.setBounds(166, 427, 115, 23);
		getContentPane().add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(VentanaPadecimiento.class.getResource("/Imagenes/icons/Actions-edit-delete-icon.png")));
		btnBorrar.setBounds(303, 427, 115, 23);
		getContentPane().add(btnBorrar);
		
		new ControladorPadecimiento(this,fabricaM.getModelo("Padecimientos"));
		
	}

	public JTextField getCodigo() {
		return codigo;
	}

	public JTextField getNombres() {
		return nombres;
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
	public Frame getPadre() {
		return padre;
	}

	public void setPadre(Frame padre) {
		this.padre = padre;
	}
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	
}

	


