package logico.Datos;
import logico.InstanciaCombate.combate;
import logico.Combatiente.CombatienteInstancia;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class estructuraDeDatos {

	// CREAR BD, abrir conexion , ejecutar insert comando, cerrar conexion con la BVD
/*estructuraDeDatos e = new estructuraDeDatos();
        e.extraerInformacion();
        System.out.println("-------------------------");
        e.insertarDatosCombate("Combate prueba 1", "2022-05-11");
        System.out.println("-------------------------");
        e.extraerInformacion(); */


	/*
	// insertar combate en BD
	estructuraDeDatos e = new estructuraDeDatos();
        System.out.println("-------------------------");
        e.insertarDatosCombate(combateinstancia);
        System.out.println("-------------------------");
	// insertar instancias de combatientes
        e.extraerInformacion(); */


	public void insertarDatosCombate(combate c){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
		// 3. Construir comandos SQL
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "insert into combate (titulo,fecha) values('"+c.getTitulo() +"','"+c.getFecha()+"');";
			//System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			//System.out.println(rs);

			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
			e.printStackTrace();
		}
	}

	public void insertarDatosCombatiente(String nombre,String nombreJugador, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int sab ,int id){ // sirve para eliminar , modificacion, actualizacion dentro de una bd
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user= "root";
			String passwd= "";
			Connection conn= DriverManager.getConnection(url,user,passwd);

			String query = "insert into combatiente (id,nombre,bIniciativa,clase,armadura,carisma,destreza" +
					",constitucion,inteligencia,sabiduria,fuerza,puntosDeGolpe," +
					"nombreJugador) values('"+id +"','"+nombre+"','"+bini+"','"+clase+"','"+arm+"','"+car+"','"+des+"','"+cons+"','"+inte+"','"+sab+"','"+fue+"','"+PG+"','"+nombreJugador+"');";

			//System.out.println(query);

			// create the java st	atement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();
			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			//System.out.println(rs);

			st.close(); // importante

		}catch(ClassNotFoundException | SQLException e ){
			e.printStackTrace();
		}
	}
	public void insertarDatosInstanciaCombatiente(CombatienteInstancia combatiente, combate combateInstancia) { // sirve para eliminar , modificacion, actualizacion dentro de una bd

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			String query = "insert into instanciacombatiente(refCombatiente,estado,tiradaSalvacionF,tiradaSalvacionE,armaduraMod," +
					"puntosGolpesMod,refCombate) values('"+ combatiente.getId()+ "','"+combatiente.getEstado()+"','"+combatiente.getTiradaSalvacionFallido()+"', '"+combatiente.getTiradaSalvacionExitoso()+"'" +
					"+'"+ combatiente.getArm()+"', '"+combatiente.getPG()+"','"+combateInstancia.getTitulo()+"' );";

			System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			System.out.println(rs);

			st.close(); // importante

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public  void extraerInformacion() {
		//ArrayList<CombatienteInstancia> combatientesCombate = new CombatienteInstancia();
		//  Cargue el controlador de acceso a datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
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
}
