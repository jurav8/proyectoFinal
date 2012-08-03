package org.proyectofinal.gestorpacientes.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import org.proyectofinal.gestorpacientes.controler.ControladorLogin;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;
import org.proyectofinal.gestorpacientes.modelo.ModeloUsuario;

public class Login extends JFrame{
	private JTextField usuario;
	private JPasswordField clave;
	private JButton btnAceptar;
	private JButton btnCancelar;
	public JTextField getUsuario() {
		return usuario;
	}
	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}
	public JPasswordField getClave() {
		return clave;
	}
	public void setClave(JPasswordField clave) {
		this.clave = clave;
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
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
		
		usuario = new JTextField();
		usuario.setBounds(173, 106, 152, 20);
		getContentPane().add(usuario);
		usuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(117, 109, 46, 14);
		getContentPane().add(lblNombre);
		
		clave = new JPasswordField();
		clave.setBounds(173, 149, 152, 20);
		getContentPane().add(clave);
		
	    btnAceptar = new JButton("Ok");
		btnAceptar.setBounds(245, 223, 89, 23);
		getContentPane().add(btnAceptar);
		
	    btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 223, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/login.png")));
		lblNewLabel.setBounds(0, 0, 442, 83);
		getContentPane().add(lblNewLabel);
		
		new ControladorLogin(this,ModeloUsuario.getInstancia(false, false));
	}
}
