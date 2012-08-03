package org.proyectofinal.gestorpacientes.controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.proyectofinal.gestorpacientes.modelo.Manejador;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloHistorial;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.ModeloUsuario;
import org.proyectofinal.gestorpacientes.modelo.entidades.Administrador;
import org.proyectofinal.gestorpacientes.modelo.entidades.Asistentes;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Perfiles;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Panel;
import org.proyectofinal.gestorpacientes.vista.PanelPaciente;
import org.proyectofinal.gestorpacientes.vista.PanelUsuario;

public class ControladorUsuario extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelUsuario vista;
	private ModeloUsuario modelo;
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefonoCasa;
	private String direccion;
	private String telefonoCelular;
	private String usuario;
	private String clave;
	private ModeloHistorial model;
	private String rango;
	private int idPersona;
	private Usuario usuarioM;

	public ControladorUsuario(Panel vista, Modelo modelo) {
		super();
		this.vista = (PanelUsuario) vista;
		this.modelo = (ModeloUsuario) modelo;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub

		model = ModeloHistorial.getInstancia(Manejador.getInstancia(false,
				false));
		llenarTabla();
		vista.getNuevo().setActionCommand("Nuevo");
		vista.getGuardar().setActionCommand("Guardar");
		vista.getEliminar().setActionCommand("Eliminar");
		vista.getEditar().setActionCommand("Editar");
		vista.getEditar().addActionListener(this);
		vista.getGuardar().addActionListener(this);
		vista.getEliminar().addActionListener(this);
		vista.getNuevo().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		/*
		 * Administrador admin = null; Asistentes asistente = null; Medico
		 * medico = null;
		 * 
		 * Usuario usuario = model.getUsuario("benja", "yo");
		 * 
		 * if(usuario.getRango().equals("medico")){ medico =
		 * model.getMedico(usuario.getIdUsuario());
		 * System.out.println(medico.getApellido()); } else
		 * if(usuario.getRango().equals("asistente")){ asistente =
		 * model.getAsistente(usuario.getIdUsuario());
		 * System.out.println(asistente.getApellido()); } else
		 * if(usuario.getRango().equals("administrador")){ admin =
		 * model.getAdministrador(usuario.getIdUsuario());
		 * System.out.println(admin.getApellido()); }
		 */

		nombre = vista.getNombre().getText();
		apellido = vista.getApellido().getText();
		cedula = vista.getCedula().getText();
		telefonoCasa = vista.getTelefono().getText();
		telefonoCelular = vista.getCelular().getText();
		direccion = vista.getDireccion().getText();
		usuario = vista.getUsuario().getText();
		clave = vista.getClave().getText();
		rango = vista.getPerfil().getSelectedItem().toString();
		if(!vista.getIdPersona().getText().equals(""))
			idPersona=Integer.valueOf(vista.getIdPersona().getText());
		try{
			usuarioM = model.getUsuario(usuario, clave);
		}catch(Exception ex){
//			System.out.println("guarda");?
		}

		if (comando.equals("Guardar")) {
			if (vista.getPerfil().getSelectedItem().equals(Perfiles.Asistente))
				model.crearAsistente(nombre, apellido, telefonoCasa,
						telefonoCelular, direccion, cedula, new Usuario(
								usuario, clave, rango));
			else if (vista.getPerfil().getSelectedItem()
					.equals(Perfiles.Administrador))
				model.crearAdministrador(nombre, apellido, telefonoCasa,
						telefonoCelular, direccion, cedula, new Usuario(
								usuario, clave, rango));
			llenarTabla();
		}

		if (comando.equals("Eliminar")) {

			int confirmacion = JOptionPane.showConfirmDialog(null,
					"¿Esta seguro de que desea eliminar este usuario?");
			if (confirmacion == 0) {
				modelo.eliminar(Integer.valueOf(vista.getTablaPorDefecto()
						.getValueAt(vista.getTabla().getSelectedRow(), 0)
						.toString()));
				llenarTabla();

			}
		}
		if (comando.equals("Editar")) {
			
			if (vista.getTablaPorDefecto()
					.getValueAt(vista.getTabla().getSelectedRow(), 9)
					.toString().equals("administrador")) {
				model.updateAdmin(nombre, apellido, telefonoCasa,
						telefonoCelular, direccion, cedula, usuarioM, idPersona);
			}
			if (vista.getTablaPorDefecto()
					.getValueAt(vista.getTabla().getSelectedRow(), 9)
					.toString().equals("asistente")) {
				model.updateAsistente(nombre, apellido, telefonoCasa,
						telefonoCelular, direccion, cedula, usuarioM, idPersona);
			}
			if (vista.getTablaPorDefecto()
					.getValueAt(vista.getTabla().getSelectedRow(), 9)
					.toString().equals("medico")) {
				model.updateAsistente(nombre, apellido, telefonoCasa,
						telefonoCelular, direccion, cedula, usuarioM, idPersona);
			}

			llenarTabla();
		}

		if (comando.equals("Nuevo")) {
			vista.getApellido().setText("");
			vista.getCedula().setText("");
			vista.getDireccion().setText("");
			vista.getNombre().setText("");
			vista.getTelefono().setText("");
			vista.getCelular().setText("");

		}

	}

	public void llenarTabla() {
		vista.getTablaPorDefecto().setNumRows(0);
		for (Usuario usuario : modelo.getListado()) {
			if (usuario.getRango().equalsIgnoreCase("asistente")) {
				Asistentes asistente = model.getAsistente(usuario
						.getIdUsuario());
				nombre = asistente.getNombre();
				apellido = asistente.getApellido();
				telefonoCasa = asistente.getTelefonoCasa();
				telefonoCelular = asistente.getTelefonoCelular();
				direccion = asistente.getDireccion();
				cedula = asistente.getCedula();
				idPersona=asistente.getId();
			} else if (usuario.getRango().equalsIgnoreCase("administrador")) {
				Administrador admin = model.getAdministrador(usuario
						.getIdUsuario());
				nombre = admin.getNombre();
				apellido = admin.getApellido();
				telefonoCasa = admin.getTelefonoCasa();
				telefonoCelular = admin.getTelefonoCelular();
				direccion = admin.getDireccion();
				cedula = admin.getCedula();
				idPersona=admin.getId();
			}
			else if (usuario.getRango().equalsIgnoreCase("medico")) {
				Medico medico = model.getMedico(usuario
						.getIdUsuario());
				nombre = medico.getNombre();
				apellido = medico.getApellido();
				telefonoCasa = medico.getTelefonoCasa();
				telefonoCelular = medico.getTelefonoCelular();
				direccion = medico.getDireccion();
				cedula = medico.getCedula();
				idPersona=medico.getId();
			}
			vista.getTablaPorDefecto().addRow(
					(new Object[] { usuario.getIdUsuario(),
							usuario.getUsuario(), usuario.getClave(), nombre,
							apellido, telefonoCasa, telefonoCelular, direccion,
							cedula, usuario.getRango(),idPersona}));
		}
	}
}
