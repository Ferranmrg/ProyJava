package Login;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {

	public static void main(String[] args) {
		VistaLogin vista = new VistaLogImpl();
		VistaSign vistasign = new VistaSignImpl();
        VistaWelcome vistaW = new VistaWelcomeImpl();
        VistaInit vistaint = new VistaInitImp();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();
		ConDB con = new ConDB();
		Querys consulta = new Querys();
        con.FicheroINI();
		consulta.setVista(vistaW);
        
		modelo.setVista(vista);
		modelo.setVistaSign(vistasign);
		modelo.setVistaInit(vistaint);
		modelo.setDB(con.getCon());
		modelo.setQuery(consulta);
		
		vista.setControlador(controlador);
		vista.setModelo(modelo);
		
		vistasign.setControlador(controlador);
		vistasign.setModelo(modelo);
		
		
		
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		controlador.setVistaSign(vistasign);
		controlador.setVistaInt(vistaint);
		controlador.setVistaW(vistaW);
		controlador.setQuery(consulta);
		controlador.setDB(con.getCon());
		
		consulta.setCon(con.getCon());
		
		vistaW.setControlador(controlador);
		vistaW.setModelo(modelo);
		
		vistaint.setModelo(modelo);
		vistaint.setControlador(controlador);
		
		vista.setVisible();
		
	}
}
