package Login;

public interface VistaSign {
	public void setControlador(Controlador controlador);
	public void setModelo(Modelo modelo);
	public String getNick();
	public String getPass();
	public String getRepetir();
	public String getCorreo();
	
	public void setVisible();
}
