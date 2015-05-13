package Login;

class ControladorImpl implements Controlador {
	private Modelo modelo;
	private VistaLogin vista;
	private String user, pwd;

	@Override
	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		this.modelo = modelo;
	}

	@Override
	public void setVista(VistaLogin vista) {
		// TODO Auto-generated method stub
		this.vista = vista;
	}

	@Override
	public boolean solicitadoLogin() {
		this.user = vista.getUser();
		this.pwd = vista.getPassword();
		modelo.setDatos(user, pwd);
		return modelo.login();
	}

	@Override
	public void solicitadoRegistro() {
		
	}

}