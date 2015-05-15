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

public class VistaWelcomeImpl implements VistaWelcome {

	private JFrame frame;
	private Modelo modelo;
	private Controlador controlador;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTable table;
	private DefaultTableModel defTable;
	private int row;

	/**
	 * Create the application.
	 */
	public VistaWelcomeImpl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defTable.removeRow(table.getSelectedRow());
			}
		});
		btnBaja.setBounds(173, 215, 97, 25);
		frame.getContentPane().add(btnBaja);

		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] fila = new Object[3];
				fila[0] = txtNick.getText();
				fila[1] = txtNombre.getText();
				fila[2] = txtApellido.getText();
				defTable.setValueAt(fila[0], row, 0);
				defTable.setValueAt(fila[1], row, 1);
				defTable.setValueAt(fila[2], row, 2);
			}
		});
		btnModificacion.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(btnModificacion);

		txtNick = new JTextField();
		txtNick.setBounds(33, 177, 91, 25);
		frame.getContentPane().add(txtNick);
		txtNick.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(173, 177, 97, 25);
		frame.getContentPane().add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(323, 177, 91, 25);
		frame.getContentPane().add(txtApellido);

		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(37, 136, 93, 43);
		frame.getContentPane().add(lblNick);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(177, 136, 93, 43);
		frame.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(327, 136, 93, 43);
		frame.getContentPane().add(lblApellido);
		
		
		String cabecera[] = {"Nombre","Apellido","Nick"};
		String Datos[][] = {};
		defTable = new DefaultTableModel(Datos , cabecera);
		
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] fila = new Object[3];
				fila[0] = txtNick.getText();
				fila[1] = txtNombre.getText();
				fila[2] = txtApellido.getText();
				defTable.addRow(fila);
				limpiar();
			}
		});
		btnAlta.setBounds(33, 215, 97, 25);
		frame.getContentPane().add(btnAlta);
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent arg0) {
				row = table.getSelectedRow();
				if (row > -1) {
					txtNick.setText((String) defTable.getValueAt(row, 0));
					txtNombre.setText((String) defTable.getValueAt(row, 1));
					txtApellido.setText((String) defTable.getValueAt(row, 2));
				}
			}
		});
		scrollPane.setViewportView(table);
		scrollPane.setBounds(33, 13, 364, 140);
		frame.getContentPane().add(scrollPane);
		table.setModel(defTable);

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
	public void setVisible() {
		if (frame.isVisible()) {
			frame.setVisible(false);
		} else {
			frame.setVisible(true);
		}

	}
	
	public void limpiar(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtNick.setText("");
	}
}
