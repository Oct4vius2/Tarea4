import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Conexion extends JFrame{
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cuentas";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "A1rmando234";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	Connection conexion = null;
	public Connection conectar(){
		
		try {
			conexion = DriverManager.getConnection(URL,USUARIO, CONTRASENA);
			System.out.println("Se conecto");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		
		}
		return conexion;
	}
	
	public int ejecutarSentenciaSQL(String strSentenciaSQL) {
		try {

			java.sql.PreparedStatement pstm = conexion.prepareStatement(strSentenciaSQL);
			pstm.execute();
			return 1;
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
			
		}
		
	}
	
	public ResultSet consultarRegistros(String strSentenciaSQL) {
	try {
		java.sql.PreparedStatement pstm = conexion.prepareStatement(strSentenciaSQL);
		ResultSet respuesta = pstm.executeQuery();
		return respuesta;
		
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	
	
	}

}