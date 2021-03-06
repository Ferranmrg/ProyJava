package Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

class ControladorImpl implements Controlador {
	private Modelo modelo;
	private VistaLogin vista;
	private VistaSign vistasign;
	private VistaInit vistaint;
	private VistaWelcome vistaw;
	private String user, pwd, nicksign,emailsign,passsign,repetirsign;
	private Object[] fila;
	private Querys query;
	private Connection con;

	public void setQuery(Querys query){
		this.query = query;
	}
	
	@Override
	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		this.modelo = modelo;
	}

	@Override
	public void setVista(VistaLogin vista) {
		// TODO Auto-generated method stub
		this.vista = vista;
	}

	@Override
	public boolean solicitadoLogin() {
		this.user = vista.getUser();
		this.pwd = vista.getPassword();
		modelo.setDatos(user, pwd);
		return modelo.login();
	}

	@Override
	public void solicitadoRegistro() {
		
		this.nicksign = vistasign.getNick();
		this.emailsign = vistasign.getCorreo();
		this.passsign = vistasign.getPass();
		this.repetirsign = vistasign.getRepetir();
		
		modelo.setDatosSign(nicksign, passsign, repetirsign, emailsign);
		
		if(modelo.comprobarSign())
			this.cambioVentanasLogSign();
		
		
		
          
	}

	@Override
	public void setVistaSign(VistaSign vistasign) {
		// TODO Auto-generated method stub
		this.vistasign = vistasign;
		

	}
	
	@Override
	public void setVistaW(VistaWelcome vistaw) {
		// TODO Auto-generated method stub
		this.vistaw = vistaw;

	}

	@Override
	public void cambioVentanasLogSign() {
		vistasign.setVisible();
		vista.setVisible();
		
	}

	@Override
	public void cambioVentanasLogWelcome() {
		vistaw.setVisible();
		vista.setVisible();
		
		
	}

	@Override
	public void cargaTabla() {
		query.DatosTabla();
	}

	@Override
	public void setDB(Connection con) {
		this.con = con;
	}

	@Override
	public void TablaInsercion() {
		this.user = vistaw.getUser();
		this.pwd = vistaw.getPwd();
		this.emailsign = vistaw.getEmail();
		query.insertarDatos(user, pwd,emailsign);
		
	}

	@Override
	public void tablaDelete(String usu) {
		// TODO Auto-generated method stub
		query.borrarDatos(usu);
	}

	@Override
	public void tablaUpdate(String usu, String nick, String pwd, String email) {
		query.modificarDatos(usu,nick,pwd,email);
		
	}

	@Override
	public void setVistaInt(VistaInit vistaint) {
		try {
			modelo.muestraContenido();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vistaint = vistaint;
		
	}

	@Override
	public void insertarInit() {
		modelo.EscribirInit();
		
	}

	@Override
	public void cambioVentanasInitWelcome() {
		vistaw.setVisible();
		vistaint.setVisible();
		
	}

	
	

}