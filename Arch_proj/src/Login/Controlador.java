package Login;

public interface Controlador {
	public void setModelo(Modelo modelo);
	public void setVista(VistaLogin vista);
    public void setVistaSign(VistaSign vistasign);
    public void setVistaW(VistaWelcome vistaW);
	public boolean solicitadoLogin();
	public void solicitadoRegistro();
	public void cambioVentanasLogSign();
	public void cambioVentanasLogWelcome();
}
