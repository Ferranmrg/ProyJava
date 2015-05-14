package Login;

public interface Modelo {
	public void setVista(VistaLogin vista);
	public void setVistaSign(VistaSign vistasign);
	public void setDatos(String user, String pwd);
	public void setDatosSign(String nick, String pass, String repetir, String email);
	public boolean login();
	public boolean comprobarSign();
}
