package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class VistaSignImpl implements VistaSign {

	private JFrame frmRegistro;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtRepetir;
	private Controlador controlador;
	private Modelo modelo;
	private JLabel lblRegistroNoValido;


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
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 524, 300);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("*Nick:");
		lblNick.setBounds(20, 30, 61, 16);
		frmRegistro.getContentPane().add(lblNick);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 93, 54, 16);
		frmRegistro.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 160, 61, 16);
		frmRegistro.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("*Email:");
		lblEmail.setBounds(277, 30, 48, 16);
		frmRegistro.getContentPane().add(lblEmail);
		
		JLabel lblContrasea = new JLabel("*Password:");
		lblContrasea.setBounds(251, 93, 93, 16);
		frmRegistro.getContentPane().add(lblContrasea);
		
		JLabel lblRepetir = new JLabel("Repetir:");
		lblRepetir.setBounds(275, 160, 61, 16);
		frmRegistro.getContentPane().add(lblRepetir);
		
		txtNick = new JTextField();
		txtNick.setBounds(86, 24, 134, 28);
		frmRegistro.getContentPane().add(txtNick);
		txtNick.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(86, 87, 134, 28);
		frmRegistro.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(86, 154, 134, 28);
		frmRegistro.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(337, 24, 134, 28);
		frmRegistro.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(337, 87, 134, 28);
		frmRegistro.getContentPane().add(txtPassword);
		
		txtRepetir = new JPasswordField();
		txtRepetir.setBounds(337, 154, 134, 28);
		frmRegistro.getContentPane().add(txtRepetir);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.solicitadoRegistro();
			}
		});
		btnRegister.setBounds(123, 213, 117, 29);
		frmRegistro.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.cambioVentanasLogSign();
				
				
			}
		});
		btnCancel.setBounds(277, 213, 117, 29);
		frmRegistro.getContentPane().add(btnCancel);
		
		lblRegistroNoValido = new JLabel("Registro no valido");
		lblRegistroNoValido.setForeground(Color.RED);
		lblRegistroNoValido.setBounds(20, 244, 220, 28);
		frmRegistro.getContentPane().add(lblRegistroNoValido);
		lblRegistroNoValido.setVisible(false);
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
		if(frmRegistro.isVisible() == true ){
			frmRegistro.setVisible(false);
		}else{
			frmRegistro.setVisible(true);
		}
				
	}

	@Override
	public void setError(String stg) {
		
		lblRegistroNoValido.setText(stg);
		lblRegistroNoValido.setVisible(true);
	}

}
