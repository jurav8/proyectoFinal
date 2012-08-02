package org.proyectofinal.gestorpacientes;

import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.proyectofinal.gestorpacientes.modelo.ModeloMedico;
import org.proyectofinal.gestorpacientes.modelo.ModeloUsuario;
import org.proyectofinal.gestorpacientes.modelo.entidades.Login;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Administrador;
import org.proyectofinal.gestorpacientes.vista.Splash;

import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;

public class Sistema {

	/**
	 * @param args
	 */
	private static Splash sp;

	public static void main(String[] args) {

		// Controller con = Controller.getEnlace(false,false);

		// Padecimientos pa = con.consultarPadecimiento(2);
		// con.eliminar(pa);

		/*
		 * ModeloMedico mdm=ModeloMedico.getInstancia(false, false);
		 * ModeloUsuario mdu=ModeloUsuario.getInstancia(false, false); Medico
		 * medico=new Medico(); medico.setApellido("hernandez");
		 * medico.setCedula("001-8288292-3");
		 * medico.setDireccion("sabana perdida"); medico.setNombre("juan");
		 * medico.setTelefonoCasa("809-883-3232"); Usuario usuario=new
		 * Usuario("doctorh","1234"); mdu.crear(usuario);
		 * medico.setUsuario(usuario); mdm.crear(medico);
		 */

		System.gc();
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		sp = new Splash();
		sp.getBarra().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (sp.getBarra().getValue() == 100) {
					sp.dispose();
					try {
						UIManager
								.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
						new Login().setVisible(true);
						new Administrador().setVisible(true);
					} catch (UnsupportedLookAndFeelException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
	}

}
