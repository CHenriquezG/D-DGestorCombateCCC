package logico.Datos;
import java.sql.*;
import java.util.Date;

public class estructuraDeDatos {
// CREAR BD, abrir conexion , ejecutar insert comando, cerrar conexion con la BVD

	public void insertarDatosCombate(String titulo, String fecha){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
		// 3. Construir comandos SQL
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/test";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "insert into Combate (titulo,fecha) values('"+titulo +"','"+fecha+"');";
			System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			System.out.println(rs);

			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
			e.printStackTrace();
		}
	}

	/*public void insertarDatosCombatiente(String nombre,String nombreJugador, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int sab ,int id){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
		// 3. Construir comandos SQL
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/test";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "insert into Combatiente (titulo,fecha) values('"+titulo +"','"+fecha+"');";
			System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			System.out.println(rs);

			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
			e.printStackTrace();
		}
	}*/
	/*public void insertarDatosInstanciaCombatiente(String nombre,String nombreJugador, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int sab ,int id){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
		// 3. Construir comandos SQL
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/test";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "insert into Combatiente (titulo,fecha) values('"+titulo +"','"+fecha+"');";
			System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			System.out.println(rs);

			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
			e.printStackTrace();
		}
	}*/
	public  void extraerInformacion() {

		//  Cargue el controlador de acceso a datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/test";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "SELECT * FROM combate";


			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				String titulo  = rs.getString("Titulo");
				Date fecha = rs.getDate("Fecha");

				// print the results
				System.out.format("%s,%s \n", titulo,fecha);
			}
			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
		}
	}
	// acceder y guardar en BD
    // combatiente real

}
