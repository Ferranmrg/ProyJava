package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.sun.glass.events.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

public class VistaWelcomeImpl implements VistaWelcome {

	private JFrame frmWelcome;
	private Modelo modelo;
	private Controlador controlador;
	private JTextField txtUsr;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel defTable;
	private int row = -1;

	/**
	 * � Create the application.
	 */
	public VistaWelcomeImpl() {
		initialize();
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		controlador.cargaTabla();

	}

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;

	}

	@Override
	public void setVisible() {
		if (frmWelcome.isVisible()) {
			frmWelcome.setVisible(false);
		} else {
			frmWelcome.setVisible(true);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 450, 333);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);

		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (row > -1) {
						controlador.tablaDelete((String) defTable.getValueAt(
								row, 0));
						defTable.removeRow(row);
						row = -1;
					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBaja.setBounds(173, 215, 97, 25);
		frmWelcome.getContentPane().add(btnBaja);

		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (row > -1) {
					String aux = (String) defTable.getValueAt(row, 0);
					Object[] fila = new Object[3];
					fila[0] = txtUsr.getText();
					fila[1] = txtPassword.getText();
					fila[2] = txtEmail.getText();
					controlador.tablaUpdate(aux, txtUsr.getText(),
							txtPassword.getText(),txtEmail.getText());
					defTable.setValueAt(fila[0], row, 0);
					defTable.setValueAt(fila[1], row, 1);
					defTable.setValueAt(fila[2], row, 2);
					row = -1;
				}
			}
		});
		btnModificacion.setBounds(323, 215, 97, 25);
		frmWelcome.getContentPane().add(btnModificacion);

		txtUsr = new JTextField();
		txtUsr.setBounds(33, 177, 91, 25);
		frmWelcome.getContentPane().add(txtUsr);
		txtUsr.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(173, 177, 97, 25);
		frmWelcome.getContentPane().add(txtPassword);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(323, 177, 91, 25);
		frmWelcome.getContentPane().add(txtEmail);

		JLabel lblNick = new JLabel("Usuario");
		lblNick.setBounds(37, 136, 93, 43);
		frmWelcome.getContentPane().add(lblNick);

		JLabel lblNombre = new JLabel("Password");
		lblNombre.setBounds(177, 136, 93, 43);
		frmWelcome.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Email");
		lblApellido.setBounds(327, 136, 93, 43);
		frmWelcome.getContentPane().add(lblApellido);

		String cabecera[] = { "Usuario", "Password", "Email" };
		String Datos[][] = {};
		defTable = new DefaultTableModel(Datos, cabecera);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Object[] fila = new Object[3];
					fila[0] = txtUsr.getText();
					fila[1] = txtPassword.getText();
					fila[2] = txtEmail.getText();
					if (!fila[0].equals("") && !fila[1].equals("")) {
						defTable.addRow(fila);
						controlador.TablaInsercion();
						limpiar();
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		});
		btnAlta.setBounds(33, 215, 97, 25);
		frmWelcome.getContentPane().add(btnAlta);

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent arg0) {
				row = table.getSelectedRow();
				if (row > -1) {
					txtUsr.setText((String) defTable.getValueAt(row, 0));
					txtPassword.setText((String) defTable.getValueAt(row, 1));
					txtEmail.setText((String) defTable.getValueAt(row, 2));
				}
			}
		});
		scrollPane.setViewportView(table);
		scrollPane.setBounds(33, 13, 364, 140);
		frmWelcome.getContentPane().add(scrollPane);
		table.setModel(defTable);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(33, 263, 97, 29);
		frmWelcome.getContentPane().add(btnSalir);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controlador.cambioVentanasLogWelcome();

			}
		});
		btnLogOut.setBounds(173, 263, 97, 29);
		frmWelcome.getContentPane().add(btnLogOut);
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambioVentanasInitWelcome();
			}
		});
		btnConfiguracion.setBounds(323, 265, 97, 25);
		frmWelcome.getContentPane().add(btnConfiguracion);

	}

	public void limpiar() {
		txtPassword.setText("");
		txtEmail.setText("");
		txtUsr.setText("");
	}

	public void cargarTabla(Object[] fila) {
		defTable.addRow(fila);
	}

	public String getUser() {
		return txtUsr.getText();
	}

	public String getPwd() {
		return txtPassword.getText();
	}
	public String getEmail() {
		return txtEmail.getText();
	}
}
