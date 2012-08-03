package org.proyectofinal.gestorpacientes.controler;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloHistorial;
import org.proyectofinal.gestorpacientes.modelo.ModeloUsuario;
import org.proyectofinal.gestorpacientes.modelo.entidades.Administrador;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Login;

@SuppressWarnings("serial")
public class ControladorLogin extends AbstractAction {

	private Login vista;
	private ModeloUsuario modelo;
	private Usuario usuario;

	public ControladorLogin(Frame vista, Modelo modelo) {
		super();
		this.vista = (Login) vista;
		this.modelo = (ModeloUsuario) modelo;
		init();
	}

	public void init() {
		vista.getBtnAceptar().setActionCommand("Aceptar");
		vista.getBtnCancelar().setActionCommand("Cancelar");
		vista.getBtnAceptar().addActionListener(this);
		vista.getBtnCancelar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Aceptar")) {
			if (vista.getUsuario().getText().isEmpty()
					&& vista.getClave().getText().isEmpty()
					|| vista.getUsuario().getText().isEmpty()
					|| vista.getClave().getText().isEmpty()) {
				JOptionPane.showMessageDialog(vista,
						"No puede dejar campos vacios", null,
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					usuario = modelo.getUsuario(vista.getUsuario().getText(),
							vista.getClave().getText());
					if (usuario != null) {
						if (usuario.getRango()
								.equalsIgnoreCase("administrador")) {
							JOptionPane.showMessageDialog(vista,
									"Bienvenidos (falto poner el nombre del usuario q se loguea)");
							new org.proyectofinal.gestorpacientes.vista.Administrador()
									.setVisible(true);
						} else if (usuario.getRango().equalsIgnoreCase(
								"asistente")) {
							JOptionPane.showMessageDialog(vista,
									"Bienvenidos (falto poner el nombre del usuario q se loguea)");
							new org.proyectofinal.gestorpacientes.vista.Asistente()
									.setVisible(true);
						} else if (usuario.getRango()
								.equalsIgnoreCase("medico")) {
							JOptionPane.showMessageDialog(vista,
									"Bienvenidos (falto poner el nombre del usuario q se loguea)");
							new org.proyectofinal.gestorpacientes.vista.Administrador()
									.setVisible(true);
						}
						vista.dispose();
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(vista,
							"Clave y/o usuario incorrecto", null,
							JOptionPane.ERROR_MESSAGE);

				}
			}

		}
		if (comando.equals("Cancelar")) {
			vista.dispose();
		}

	}
}
