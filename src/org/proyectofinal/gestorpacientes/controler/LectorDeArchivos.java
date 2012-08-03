package org.proyectofinal.gestorpacientes.controler;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import org.proyectofinal.gestorpacientes.vista.Panel;


public class LectorDeArchivos extends MouseAdapter {

	private JFileChooser selector = new JFileChooser();
	private Panel panel;

	public LectorDeArchivos(Panel panel) {
		super();
		this.panel = (Panel) panel;
	}

	public void mousePressed(MouseEvent ae) {
		File archivo;
		selector.setMultiSelectionEnabled(false);
		selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int seleccion = selector.showOpenDialog(panel);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			archivo = selector.getSelectedFile();
			if (archivo != null) {
				panel.setRuta(archivo.getAbsolutePath());
				cargar(panel.getFoto(), archivo.getAbsolutePath());
			}

		}
	}

	public void cargar(JLabel jLabel, String imagenUrl) {
		ImageIcon fot = new ImageIcon(imagenUrl);
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(
				130,150, Image.SCALE_SMOOTH));
		jLabel.setIcon(icono);
		jLabel.setSize(130,150);

	}
}
