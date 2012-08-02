package org.proyectofinal.gestorpacientes.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelReceta extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedorTabla;
	private JScrollPane scrollTabla;
	private JPanel editarGuardar;
	private JPanel nuevoEliminar;
	private JTextField paciente;
	private JTextField padecimiento;
	private JTextArea medicamento;
	private JLabel idReceta;
	private JLabel idPaciente;
	private JLabel idPadecimiento;
	private JButton imprimir;
	private static PanelReceta instancia;

	public static PanelReceta getInstancia() {
		if (instancia == null) {
			instancia = new PanelReceta();
		}
		return instancia;

	}

	private PanelReceta() {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Receta"));

		JLabel lblPaciente = new JLabel("Paciente:");

		JLabel lblPadecimiento = new JLabel("Padecimiento:");

		JLabel lblMedicamento = new JLabel("Medicamentos:");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		// paciente = new JTextField();
		// getPaciente.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(55)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblPaciente,
																								GroupLayout.PREFERRED_SIZE,
																								46,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								getPaciente(),
																								GroupLayout.PREFERRED_SIZE,
																								186,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(24)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblPadecimiento,
																								GroupLayout.PREFERRED_SIZE,
																								75,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								getpadecimiento(),
																								GroupLayout.PREFERRED_SIZE,
																								186,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(23)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												scrollPane,
																												GroupLayout.PREFERRED_SIZE,
																												188,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												getEditarGuardar(),
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								lblMedicamento,
																								GroupLayout.PREFERRED_SIZE,
																								90,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.TRAILING)
																		.addGroup(
																				Alignment.LEADING,
																				groupLayout
																						.createSequentialGroup()
																						.addComponent(
																								getIdReceta(),
																								GroupLayout.PREFERRED_SIZE,
																								60,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(
																								getIdPaciente(),
																								GroupLayout.PREFERRED_SIZE,
																								56,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(41)
																						.addComponent(
																								getIdPadecimiento(),
																								GroupLayout.PREFERRED_SIZE,
																								74,
																								GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				getScrollTabla(),
																				Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE,
																				832,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				groupLayout
																						.createSequentialGroup()
																						.addComponent(
																								panel,
																								GroupLayout.PREFERRED_SIZE,
																								110,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								getNuevoEliminar(),
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(30, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				getIdPaciente(),
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				getIdReceta(),
																				GroupLayout.DEFAULT_SIZE,
																				16,
																				Short.MAX_VALUE))
														.addComponent(
																getIdPadecimiento(),
																GroupLayout.PREFERRED_SIZE,
																18,
																GroupLayout.PREFERRED_SIZE))
										.addGap(16)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblMedicamento)
																		.addComponent(
																				lblPadecimiento))
														.addComponent(
																lblPaciente))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				getEditarGuardar(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																39,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				getPaciente(),
																				GroupLayout.PREFERRED_SIZE,
																				21,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				getpadecimiento(),
																				GroupLayout.PREFERRED_SIZE,
																				21,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(26)
										.addComponent(getScrollTabla(),
												GroupLayout.PREFERRED_SIZE,
												373, GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				getNuevoEliminar(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(24))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				panel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
		panel.add(getImprimir());
		scrollPane.setViewportView(getMedicamento());
		setLayout(groupLayout);

		getTabla().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				getIdReceta().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 0).toString());
				getIdPadecimiento().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 1).toString());
				getIdPaciente().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 2).toString());
				getPaciente().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 3).toString());
				getpadecimiento().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 4).toString());
				getMedicamento().setText(
						getTablaPorDefecto().getValueAt(
								getTabla().getSelectedRow(), 5).toString());
			}
		});
	}

	public void setIdPaciente(JLabel idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void setIdPadecimiento(JLabel idPadecimiento) {
		this.idPadecimiento = idPadecimiento;
	}

	/*****************************************
	 * JTextFiel paciente
	 *****************************************/

	public JTextField getPaciente() {
		if (paciente == null) {
			paciente = new JTextField(10);
			paciente.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					VentanaPaciente vp = new VentanaPaciente(getPadre(), true);
					vp.setLocationRelativeTo(null);
					vp.setVisible(true);
					paciente.setText(vp.getNombre() + " " + vp.getApellido());
					idPaciente.setText(Integer.toString(vp.getId()));
				}
			});
			paciente.setColumns(10);
		}
		return paciente;
	}

	/*****************************************
	 * JTextFiel padecimiento
	 *****************************************/
	public JTextField getpadecimiento() {
		if (padecimiento == null) {
			padecimiento = new JTextField();
			padecimiento.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					VentanaPadecimiento vpd = new VentanaPadecimiento(
							getPadre(), true);
					vpd.setLocationRelativeTo(null);
					vpd.setVisible(true);
					padecimiento.setText(vpd.getNombre());
					idPadecimiento.setText(vpd.getCodigo().getText());
				}
			});
			padecimiento.setColumns(10);
		}
		return padecimiento;
	}

	/*****************************************
	 * JTextFiel medicamento
	 *****************************************/
	public JTextArea getMedicamento() {
		if (medicamento == null) {
			medicamento = new JTextArea();
		}
		return medicamento;
	}

	/******************************************************
	 * JScrollPanel para el JTextArea de Causa
	 *****************************************************/
	public JScrollPane getScrollTabla() {
		if (scrollTabla == null) {
			scrollTabla = new JScrollPane(getPanelContenedorTable());
		}
		return scrollTabla;
	}

	/*****************************************
	 * Panel contendor del Scroll para la tabla
	 *****************************************/

	public JPanel getPanelContenedorTable() {
		if (panelContenedorTabla == null) {
			panelContenedorTabla = new JPanel();
			panelContenedorTabla.setBounds(49, 215, 857, 322);
			panelContenedorTabla.setLayout(new BorderLayout(0, 0));
			getTablaPorDefecto().setDataVector(
					null,
					new String[] { "idReceta", "idPadecimiento", "idPaciente",
							"Paciente", "Padecimiento", "Medicamentos" });
			ocultaColumnas(getTabla(), new int[] { 0, 1, 2 });
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
	 * Panel e los botones Nuevo y Eliminar
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

	public JLabel getIdReceta() {
		if (idReceta == null) {
			idReceta = new JLabel("");
			idReceta.setVisible(false);
		}
		return idReceta;
	}

	public JLabel getIdPaciente() {
		if (idPaciente == null) {
			idPaciente = new JLabel("");
			idPaciente.setVisible(false);
		}
		return idPaciente;
	}

	public JLabel getIdPadecimiento() {
		if (idPadecimiento == null) {
			idPadecimiento = new JLabel("");
			idPadecimiento.setVisible(false);
		}
		return idPadecimiento;
	}

	public JButton getImprimir() {
		if (imprimir == null) {
			imprimir = new JButton("Imprimir");
			imprimir.setIcon(new ImageIcon(PanelReceta.class
					.getResource("/Imagenes/icons/printer-blue-icon.png")));
		}
		return imprimir;
	}
}
