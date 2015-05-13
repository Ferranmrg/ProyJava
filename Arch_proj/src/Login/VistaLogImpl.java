package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JPasswordField;

public class VistaLogImpl implements VistaLogin {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private Modelo modelo;
	private Controlador controlador;
	private JLabel lblLogError;

	/**
	 * Create the application.
	 */
	public VistaLogImpl() {
		initialize();
	}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
		
	}

	@Override
	public String getUser() {
		return txtUser.getText();
		
	}

	@Override
	public String getPassword() {
		return new String(txtPassword.getPassword());
	}

	@Override
	public void setVisible() {
		if(frame.isVisible() == true ){
			frame.setVisible(false);
		}else{
			frame.setVisible(true);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUser.setBounds(79, 43, 61, 16);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassword.setBounds(42, 87, 116, 16);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(152, 38, 134, 28);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		lblLogError = new JLabel("User and/or password incorrect");
		lblLogError.setForeground(Color.RED);
		lblLogError.setBounds(28, 243, 225, 16);
		lblLogError.setVisible(false);
		frame.getContentPane().add(lblLogError);
		
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlador.solicitadoLogin()){
					setVisible();
				}else{
					frame.setBounds(100, 100, 385, 322);
					lblLogError.setVisible(true);
				}
				
				
			}
		});
		btnLogIn.setBounds(42, 140, 127, 29);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSignIn.setBounds(219, 140, 127, 29);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnLogOut.setBounds(136, 181, 117, 29);
		frame.getContentPane().add(btnLogOut);
		

		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(152, 82, 134, 28);
		frame.getContentPane().add(txtPassword);
	}
}