package Login;

public interface Modelo {
	public void setVista(VistaLogin vista);
	public void setDatos(String user, String pwd);
	public boolean login();
}
