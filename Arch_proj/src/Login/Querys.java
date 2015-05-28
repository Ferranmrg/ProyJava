package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Querys {
	private Connection con;
	private VistaWelcome VW;
	
	public void setVista(VistaWelcome VW){
		this.VW = VW;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String ConsultaLogin(String user) {
		String query = "SELECT PASSWORD FROM PLSQL.USERS WHERE USERS=?";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				return resul.getString(1);
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return "";
	}
	
	public void CrearUsuario(String user,String pwd) {
		String query = "INSERT INTO PLSQL.USERS VALUES (?,?)";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2,pwd);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				System.out.println("Correcto");
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		System.out.println("?");
	}
	
	public boolean ExisteUsuario(String user) {
		String query = "SELECT USERS FROM PLSQL.USERS WHERE USERS = ?";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				return true;
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return false;
	}
	
	public void DatosTabla() {
		String query = "SELECT * FROM PLSQL.USERS";
		try {
			Object[] fila = new Object[3];
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet resul = pstmt.executeQuery();
			while (resul.next()){
				fila[0] = resul.getString(1);
				fila[1] = resul.getString(2);
				fila[2] = "NULL";
				VW.cargarTabla(fila);
			}
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void insertarDatos(String user, String pwd) {
		String query = "INSERT INTO PLSQL.USERS VALUES (?,?)";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2,pwd);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				System.out.println("Correcto");
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		System.out.println("?");
	}
	
	public void borrarDatos(String user) {
		String query = "DELETE FROM PLSQL.USERS WHERE USERS = ?";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			ResultSet resul = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void modificarDatos(String usu, String c1, String c2) {
		String query = "UPDATE PLSQL.USERS SET USERS = ? , PASSWORD = ?  WHERE USERS = ?";
		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, c1);
			pstmt.setString(2, c2);
			pstmt.setString(3, usu);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				System.out.println("Correcto");
			resul.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
