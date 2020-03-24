import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {

	public static void main(String[] args) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM spotify.songs WHERE title LIKE '%f%';"); //CONSULTA 

			while (rs.next()) {
				int id = rs.getInt(1);

				System.out.println(id + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4)
						+ " - " + rs.getString(5)+ " - " + rs.getString(6)+ " - " + rs.getString(7)+ " - " + rs.getString(8)+ " - " + rs.getString(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
//@NachinV
