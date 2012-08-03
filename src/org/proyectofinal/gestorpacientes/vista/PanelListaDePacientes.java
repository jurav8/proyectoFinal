package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;

import org.proyectofinal.gestorpacientes.controler.LectorDeArchivos;

public class PanelListaDePacientes extends Panel {

	private JLabel nombre;
	private JLabel apellido;
	private JLabel foto;
	private JButton btnVerHistorial;
	private static PanelListaDePacientes instancia;
	
	public static PanelListaDePacientes getInstancia(){
		if(instancia==null){
			instancia=new PanelListaDePacientes();
		}
		return instancia;
	}

	private PanelListaDePacientes() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Lista de pacientes", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		setBackground(Color.WHITE);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		scrollPane.setBounds(60, 210, 818, 362);
		add(scrollPane);

		getTablaPorDefecto().setDataVector(new Object[][] {}, new String[] { "Id",
				"Nombre", "Apellido", "Cedula","Foto" });

		ocultaColumnas(getTabla(), new int[]{0,4});
		
		scrollPane.setViewportView(getTabla());
		
		getTabla().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				idPaciente.setText(getTablaPorDefecto().getValueAt(
						getTabla().getSelectedRow(), 0).toString());
				nombre.setText(getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 1).toString());
				apellido.setText(getTablaPorDefecto().getValueAt(
						getTabla().getSelectedRow(), 2).toString());
				new LectorDeArchivos(getInstancia()).cargar(foto, getTablaPorDefecto().getValueAt(
						getTabla().getSelectedRow(),4 ).toString());
			}
		});

		foto = new JLabel("");
		foto.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		foto.setBounds(253, 40, 127, 134);
		add(foto);

		btnVerHistorial = new JButton("Ver historial");
		btnVerHistorial.setIcon(new ImageIcon(PanelListaDePacientes.class
				.getResource("/Imagenes/icons/History-Folder-Ash-icon.png")));
		btnVerHistorial.setBounds(498, 150, 109, 23);
		add(btnVerHistorial);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(418, 58, 85, 23);
		add(lblNewLabel);

		nombre = new JLabel("");
		nombre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		nombre.setBounds(481, 58, 203, 23);
		add(nombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setInheritsPopupMenu(false);
		lblapellido.setBounds(418, 104, 85, 23);
		add(lblapellido);

		apellido = new JLabel("");
		apellido.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		apellido.setBounds(481, 104, 203, 23);
		add(apellido);
		
		idPaciente = new JLabel("");
		idPaciente.setVisible(false);
		idPaciente.setBounds(60, 93, 46, 14);
		add(idPaciente);
	}

	
	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}

	public JLabel getFoto() {
		return foto;
	}

	public void setFoto(JLabel foto) {
		this.foto = foto;
	}

	public JButton getBtnVerHistorial() {
		return btnVerHistorial;
	}

	public void setBtnVerHistorial(JButton btnVerHistorial) {
		this.btnVerHistorial = btnVerHistorial;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel idPaciente;
}
