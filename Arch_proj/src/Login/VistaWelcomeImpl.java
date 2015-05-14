package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class VistaWelcomeImpl {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaWelcomeImpl window = new VistaWelcomeImpl();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JTable table = new JTable();
		table.setBounds(95, 97, 181, 115);
		frame.getContentPane().add(table);
		table.setModel(new DefaultTableModel(
				new Object[][]{
						
						
				},
				new String[] {
						"Nick","Nombre","Apellido"
				}
				
				));
		

		
				
		
		
	}

}
