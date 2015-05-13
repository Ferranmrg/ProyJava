package Login;

public class ModeloImpl implements Modelo {
	private String pwd;
	private String user;
	private VistaLogin vista;
	private String PWD;

	@Override
	public void setVista(VistaLogin vista) {
		this.vista = vista;

	}

	@Override
	public void setDatos(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;

	}

	/**
	 * @param pWD
	 *            the pWD to set
	 */
	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public boolean login() {
		if (user == pwd) {
			return true;
		} else {
			return false;
		}
	}
}
