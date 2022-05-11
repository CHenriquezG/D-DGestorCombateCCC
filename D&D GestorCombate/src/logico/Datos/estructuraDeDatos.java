package logico.Datos;
// import java.sql.*;

public class estructuraDeDatos {   // NO TOCAR

	/*estructuraDeDatos e = new estructuraDeDatos();
        e.extraerInformacion();
        System.out.println("-------------------------");
        e.insertarDatos("Combate chiquito 4", "2022-05-12");
        System.out.println("-------------------------");
        e.extraerInformacion();

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
	public void insertarDatos(String titulo, String fecha){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
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

	// acceder y guardar en BD

	// CREAR BD, abrir conexion , ejecutar insert comando, cerrar conexion con la BVD

     // JSON serializable
    // combatiente real

    /*  String fichero = "";

	try (BufferedReader br = new BufferedReader(new FileReader("datos.json"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            fichero += linea;
        }

    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
   */
}
