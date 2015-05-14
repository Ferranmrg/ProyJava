package Login;

class ControladorImpl implements Controlador {
	private Modelo modelo;
	private VistaLogin vista;
	private VistaSign vistasign;
	private VistaWelcome vistaw;
	private String user, pwd, nicksign,emailsign,passsign,repetirsign;

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
		
		this.nicksign = vistasign.getNick();
		this.emailsign = vistasign.getCorreo();
		this.passsign = vistasign.getPass();
		this.repetirsign = vistasign.getRepetir();
		
		
		
		
          
	}

	@Override
	public void setVistaSign(VistaSign vistasign) {
		// TODO Auto-generated method stub
		this.vistasign = vistasign;
		

	}
	
	@Override
	public void setVistaw(VistaWelcome vistaw) {
		// TODO Auto-generated method stub
		this.vistaw = vistaw;

	}

	@Override
	public void cambioVentanasLogSign() {
		vistasign.setVisible();
		vista.setVisible();
		
	}

	@Override
	public void cambioVentanasLogWelcome() {
		// TODO Auto-generated method stub
		
		
	}

	
	

}