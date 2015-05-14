package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.sun.glass.events.MouseEvent;

public class VistaWelcomeImpl implements VistaWelcome{

	private JFrame frame;
	private Modelo modelo;
	private Controlador controlador;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;

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
		
		
		final JTable table = new JTable();
		final DefaultTableModel defTable = (DefaultTableModel)table.getModel();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				 int fila = table.rowAtPoint(arg0.getPoint());
		         int columna = table.columnAtPoint(arg0.getPoint());
		         if ((fila > -1) && (columna > -1))
		           txtNick.setText((String) defTable.getValueAt(fila,columna));
		
			}
		});
		table.setBounds(60, 24, 307, 115);
		frame.getContentPane().add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NICK", "NOMBRE", "APELLIDO"},
			},
			new String[] {
				"Nick", "Nombre", "Apellido"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(33, 215, 97, 25);
		frame.getContentPane().add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(173, 215, 97, 25);
		frame.getContentPane().add(btnBaja);
		
		JButton btnModificacion = new JButton("Modificacion");
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
		if(frame.isVisible() == true ){
			frame.setVisible(false);
		}else{
			frame.setVisible(true);
		}
		
	}
	
}
