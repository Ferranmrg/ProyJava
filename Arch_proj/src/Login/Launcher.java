package Login;

public class Launcher {

	public static void main(String[] args) {
		VistaLogin vista = new VistaLogImpl();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();
        VistaSign vistasign = new VistaSignImpl();
        VistaWelcome vistaW = new VistaWelcomeImpl();
        
		modelo.setVista(vista);
		modelo.setVistaSign(vistasign);
		
		vista.setControlador(controlador);
		vista.setModelo(modelo);
		
		vistasign.setControlador(controlador);
		vistasign.setModelo(modelo);
		
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		controlador.setVistaSign(vistasign);
		controlador.setVistaW(vistaW);
		
		vista.setVisible();
		
	}
}
