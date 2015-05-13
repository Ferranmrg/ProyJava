package Login;

public interface VistaLogin {
	public void setControlador(Controlador controlador);
	public void setModelo(Modelo modelo);
	public String getUser();
	public String getPassword();
	
	// si esta false true, y si es true false
	public void setVisible();
}
