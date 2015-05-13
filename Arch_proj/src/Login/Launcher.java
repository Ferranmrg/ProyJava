package Login;

public class Launcher {

	public static void main(String[] args) {
		VistaLogin vista = new VistaLogImpl();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();
		modelo.setVista(vista);
		vista.setControlador(controlador);
		vista.setModelo(modelo);
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		
		vista.setVisible();
		
	}
}
