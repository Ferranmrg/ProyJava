package Login;

import java.sql.Connection;

public interface Controlador {
	public void setModelo(Modelo modelo);
	public void setVista(VistaLogin vista);
    public void setVistaSign(VistaSign vistasign);
    public void setVistaW(VistaWelcome vistaW);
	public boolean solicitadoLogin();
	public void solicitadoRegistro();
	public void cambioVentanasLogSign();
	public void cambioVentanasLogWelcome();
	public void cargaTabla();
	public void setQuery(Querys query);
	public void setDB(Connection con);
	public void TablaInsercion();
	public void tablaDelete(String usu);
	public void tablaUpdate(String user, String usr, String pwd, String email);
}
