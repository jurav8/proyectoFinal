package org.proyectofinal.gestorpacientes.vista;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelListaDeMedicos extends Panel{
	private JComboBox especialidad;
	private JList lista;
	private JButton btnBuscar;

	public PanelListaDeMedicos() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medicos por especialidad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(277, 72, 66, 14);
		add(lblEspecialidad);
		
	    especialidad = new JComboBox();
		especialidad.setBounds(353, 72, 173, 20);
		add(especialidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(60, 139, 818, 417);
		add(scrollPane);
		
		lista = new JList();
		scrollPane.setViewportView(lista);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(PanelListaDeMedicos.class.getResource("/Imagenes/icons/search-icon.png")));
		btnBuscar.setBounds(562, 70, 89, 23);
		add(btnBuscar);
	}

	public void setEspecialidad(JComboBox especialidad) {
		this.especialidad = especialidad;
	}

	public void setLista(JList lista) {
		this.lista = lista;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JComboBox getEspecialidad() {
		return especialidad;
	}

	public JList getLista() {
		return lista;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
