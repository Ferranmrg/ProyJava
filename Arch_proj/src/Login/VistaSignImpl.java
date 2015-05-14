package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaSignImpl implements VistaSign {

	private JFrame frame;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtRepetir;
	private Controlador controlador;
	private Modelo modelo;


	/**
	 * Create the application.
	 */
	public VistaSignImpl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(42, 30, 61, 16);
		frame.getContentPane().add(lblNick);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 93, 54, 16);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 160, 61, 16);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(287, 30, 38, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(250, 93, 75, 16);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblRepetir = new JLabel("Repetir:");
		lblRepetir.setBounds(277, 160, 48, 16);
		frame.getContentPane().add(lblRepetir);
		
		txtNick = new JTextField();
		txtNick.setBounds(86, 24, 134, 28);
		frame.getContentPane().add(txtNick);
		txtNick.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(86, 87, 134, 28);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(86, 154, 134, 28);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(337, 24, 134, 28);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(337, 87, 134, 28);
		frame.getContentPane().add(txtPassword);
		
		txtRepetir = new JPasswordField();
		txtRepetir.setBounds(337, 154, 134, 28);
		frame.getContentPane().add(txtRepetir);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(123, 213, 117, 29);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.cambioVentanasLogSign();
				
				
			}
		});
		btnCancel.setBounds(277, 213, 117, 29);
		frame.getContentPane().add(btnCancel);
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
	public String getNick() {
		
		return txtNick.getText();
	}

	@Override
	public String getPass() {
		// TODO Auto-generated method stub
		return new String(txtPassword.getPassword());
	}

	@Override
	public String getRepetir() {
		// TODO Auto-generated method stub
		return new String(txtRepetir.getPassword());
	}

	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return txtEmail.getText();
	}

	@Override
	public void setVisible() {
		if(frame.isVisible() == true ){
			frame.setVisible(false);
		}else{
			frame.setVisible(true);
		}
				
	}
}
