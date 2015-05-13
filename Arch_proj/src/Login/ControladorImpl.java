package Login;

public class ControladorImpl implements Controlador{

	private Modelo modelo;
	private VistaLogin vistaLogin;
	
	public ControladorImpl(){
		super();
	}
	public void setModelo(Modelo modelo){
		this.modelo = modelo;
	}
	public void setVista(VistaLogin vista){
		this.vistaLogin = vista;
	}
	
	public boolean solicitadoLogin(){
		String user = vistaLogin.getUser();
		String pwd = vistaLogin.getPassword();
		modelo.setDatos(user, pwd);
		return modelo.login();
	}

}
