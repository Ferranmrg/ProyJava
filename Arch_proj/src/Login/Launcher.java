package Login;

public class Launcher {

	public static void main(String[] args) {
		VistaLogin vista = new VistaLogImpl();
		VistaSign vistasign = new VistaSignImpl();
        VistaWelcome vistaW = new VistaWelcomeImpl();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();
		ConDB con = new ConDB();
		Querys consulta = new Querys();
        
		consulta.setVista(vistaW);
        
		modelo.setVista(vista);
		modelo.setVistaSign(vistasign);
		modelo.setDB(con.getCon());
		modelo.setQuery(consulta);
		
		vista.setControlador(controlador);
		vista.setModelo(modelo);
		
		vistasign.setControlador(controlador);
		vistasign.setModelo(modelo);
		
		
		
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		controlador.setVistaSign(vistasign);
		controlador.setVistaW(vistaW);
		controlador.setQuery(consulta);
		controlador.setDB(con.getCon());
		
		consulta.setCon(con.getCon());
		
		vistaW.setControlador(controlador);
		vistaW.setModelo(modelo);
		vista.setVisible();
		
	}
}
