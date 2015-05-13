package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JPasswordField;

public class VistaLogImpl implements VistaLogin {
	private Modelo modelo;
	private Controlador controlador;
	//GRAPHICS
	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField passwordField;

	public VistaLogImpl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUser = new JLabel("User: ");

		JLabel lblPassword = new JLabel("Password:");

		final JLabel lblWP = new JLabel("Wrong PWD");
		lblWP.setEnabled(false);
		lblWP.setForeground(Color.RED);

		txtUser = new JTextField();
		txtUser.setColumns(10);

		passwordField = new JPasswordField();

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.solicitadoLogin();
			}
		});

		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.solicitadoLogin();
				if(modelo.login()){
					setVisible();
					System.out.println("LOG IN");
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(36)
																										.addComponent(
																												lblUser))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(38)
																										.addComponent(
																												lblPassword)))
																		.addGap(22)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								passwordField)
																						.addComponent(
																								txtUser)
																						.addComponent(
																								lblWP)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(323)
																		.addComponent(
																				btnNewButton,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap(
																				323,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnNewButton_1)))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtUser,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblUser))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passwordField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPassword))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblWP).addGap(62)
										.addComponent(btnNewButton).addGap(18)
										.addComponent(btnNewButton_1)
										.addContainerGap(25, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
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
		return this.txtUser.getText();
	}

	@Override
	public String getPassword() {
		return new String(this.passwordField.getPassword());
	}

	@Override
	public void setVisible() {
		if (frame.isVisible())
			frame.setVisible(false);
		else
			frame.setVisible(true);
		
	}
}
