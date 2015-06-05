package Login;

import java.sql.Connection;
import java.io.*;

class ModeloImpl implements Modelo {
	private VistaLogin vista;
	private VistaSign vistasign;
	private VistaInit vistaInt;
	private String user, pwd, nickSign, passSign, repetirSign, emailSign;
	private Connection con;
	private Querys query;

	public void muestraContenido() throws FileNotFoundException, IOException {
		String texto = "";
		String cadena;
		FileReader f = new FileReader("src/Configuracion.ini");
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			texto += cadena + "\n";
		}
		vistaInt.setTxtContent(texto);
		b.close();
	}

	public void EscribirInit() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("src/configuracion.ini");
			pw = new PrintWriter(fichero);

			fichero.write(vistaInt.getTxtContent());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void setVista(VistaLogin vista) {
		this.vista = vista;
	}

	@Override
	public void setDatos(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;

	}

	@Override
	public boolean login() {
		if (query.ConsultaLogin(this.user).equals(this.pwd)
				&& !this.pwd.isEmpty()) {
			return true;
		} else
			return false;
	}

	@Override
	public void setVistaSign(VistaSign vistasign) {
		// TODO Auto-generated method stub
		this.vistasign = vistasign;

	}

	@Override
	public void setDatosSign(String nick, String pass, String repetir,
			String email) {
		nickSign = nick;
		passSign = pass;
		repetirSign = repetir;
		emailSign = email;

	}

	@Override
	public boolean comprobarSign() {

		boolean comprobar = false;
		boolean cuela = true;

		if (this.passSign.isEmpty() || this.nickSign.isEmpty()
				|| this.emailSign.isEmpty()) {
			vistasign.setError("Campos requeridos vacios");
			cuela = false;
		} else if (this.passSign.equals(this.repetirSign)
				&& !query.ExisteUsuario(nickSign) && cuela
				&& emailSign.contains("@") && emailSign.contains(".")) {
			query.CrearUsuario(nickSign, passSign, emailSign);
			comprobar = true;
		}

		return comprobar;
	}

	@Override
	public void setDB(Connection con) {
		this.con = con;

	}

	@Override
	public void setQuery(Querys consulta) {
		this.query = consulta;

	}

	@Override
	public void setVistaInit(VistaInit vistainit) {
		this.vistaInt = vistainit;

	}

}