package Login;

public interface VistaWelcome {
	public void setControlador(Controlador controlador);
	public void setModelo(Modelo modelo);
	public void setVisible();
	public void cargarTabla(Object[] fila);
	public String getUser();
	public String getPwd();
	public String getEmail();
}
