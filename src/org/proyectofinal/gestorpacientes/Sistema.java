package org.proyectofinal.gestorpacientes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.proyectofinal.gestorpacientes.modelo.ManejardoDeEntidades;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;
import org.proyectofinal.gestorpacientes.vista.Administrador;

import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;

public class Sistema {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Controller con = Controller.getEnlace(false,false);
		
//		Padecimientos pa = con.consultarPadecimiento(2);
//		con.eliminar(pa);
		
		
		System.gc();

			
				try {
					UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	
		new Administrador().setVisible(true);

	}

}