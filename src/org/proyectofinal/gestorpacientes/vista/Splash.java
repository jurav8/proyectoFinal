package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.proyectofinal.gestorpacientes.controler.HiloBarra;

public class Splash extends JFrame{

	private static final long serialVersionUID = 1L;
    private HiloBarra hilo;
	private JProgressBar barra;
 

	public Splash(){
		setUndecorated(true);
		splashScreen();
		hilo=new HiloBarra(barra);
		hilo.start();
		this.setLocation(350,250);
		hilo=null;
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		getContentPane().setBackground(new Color(255, 255, 255));
			
	}

	public JProgressBar getBarra() {
		return barra;
	}

	public void splashScreen(){
		
		setTitle("Soluciones m\u00E9dicas");
		setSize(522,267);
		setVisible(true);
		setLocation(300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(450, 300);
		getContentPane().setLayout(null);
		
		barra = new JProgressBar();
		barra.setIndeterminate(true);
		barra.setStringPainted(true);
		barra.setBounds(98, 154, 334, 21);
		getContentPane().add(barra);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A9 Todos los derechos reservados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(363, 249, 159, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/Imagenes/splash.png")));
		lblNewLabel.setBounds(0, 0, 522, 266);
		getContentPane().add(lblNewLabel);
		
	}
}
