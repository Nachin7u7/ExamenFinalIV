import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static final String BD = "spotify"; //nombre de la base de datos
	
	public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/"+BD;
	public static final String USUARIO = "root";
	public static final String CLAVE = "Secreta123";

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {

			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexion: OK");
		} catch (SQLException e) {
			System.out.println("error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}


// @NachinV
