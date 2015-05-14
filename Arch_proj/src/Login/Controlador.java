package Login;

public interface Controlador {
	public void setModelo(Modelo modelo);
	public void setVista(VistaLogin vista);
    public void setVistaSign(VistaSign vistasign);
	public boolean solicitadoLogin();
	public void solicitadoRegistro();
	public void cambioVentanasLogSign();
}
