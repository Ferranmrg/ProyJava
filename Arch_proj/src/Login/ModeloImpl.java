package Login;

class ModeloImpl implements Modelo {
	private VistaLogin vista;
	private VistaSign vistasign;
	private String user, pwd, nickSign, passSign, repetirSign, emailSign;

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

	@Override
	public void setVistaSign(VistaSign vistasign) {
		// TODO Auto-generated method stub
		this.vistasign = vistasign;
		
	}

	@Override
	public void setDatosSign(String nick, String pass, String repetir,
			String email) {
		nickSign =nick;
		passSign=pass;
		repetirSign=repetir;
		emailSign=email;
		
	}

	@Override
	public boolean comprobarSign() {
		//if()
		return false;
	}
	
	

}