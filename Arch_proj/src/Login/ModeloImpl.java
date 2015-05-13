package Login;

class ModeloImpl implements Modelo {
	private VistaLogin vista;
	private String user, pwd;

	@Override
	public void setVista(VistaLogin vista) {
		this.vista = vista;
	}

	@Override
	public void setDatos(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;

	}

	@Override
	public boolean login() {
		if (this.user.equals(this.pwd)) {
			return true;
		} else
			return false;
	}

}