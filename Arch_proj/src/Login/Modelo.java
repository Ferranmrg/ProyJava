package Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

public interface Modelo {
	public void setVista(VistaLogin vista);
	public void setVistaSign(VistaSign vistasign);
	public void setVistaInit(VistaInit vistainit);
	public void setDatos(String user, String pwd);
	public void setDatosSign(String nick, String pass, String repetir, String email);
	public boolean login();
	public boolean comprobarSign();
	public void setDB(Connection con);
	public void setQuery(Querys consulta);
	public void muestraContenido() throws FileNotFoundException, IOException;
	public void EscribirInit();
}
