package org.proyectofinal.gestorpacientes.modelo.entidades;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Login extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	public Login() {
		setTitle("Autenticacion");
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(446, 306);
		setLocationRelativeTo(null);
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar clave");
		chckbxNewCheckBox.setBounds(114, 185, 208, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(117, 151, 36, 14);
		getContentPane().add(lblClave);
		
		textField = new JTextField();
		textField.setBounds(173, 106, 152, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(117, 109, 46, 14);
		getContentPane().add(lblNombre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 149, 152, 20);
		getContentPane().add(passwordField);
		
		JButton btnAceptar = new JButton("Ok");
		btnAceptar.setBounds(245, 223, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 223, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/login.png")));
		lblNewLabel.setBounds(0, 0, 442, 83);
		getContentPane().add(lblNewLabel);
	}
}
