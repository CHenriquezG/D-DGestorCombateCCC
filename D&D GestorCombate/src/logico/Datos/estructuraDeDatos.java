package logico.Datos;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;
import logico.InstanciaCombate.combate;
import logico.Combatiente.CombatienteInstancia;
import java.sql.*;
import java.util.ArrayList;

public class estructuraDeDatos {
	ArrayList < combate > combatesBD;
	ArrayList < CombatienteInstancia > combatienteInstanciaBD;
	ArrayList < CombatienteReal > combatienteRealBD;

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





	/*estructuraDeDatos e = new estructuraDeDatos();
        System.out.println("-------------------------");
	configuracion c = new configuracion();
        c.setCombatiente("claudio","serllet","1","guerrero",4,6,6,8,5,9,8,9,2,rnd.nextInt(94)+33);

        e.guardarCombateBD(combateinstancia,c);

        e.extraerCombate();
        System.out.println("***************************************************************");
        e.extraerCombatientes();*/


	public void insertarDatosCombate(combate c) { // sirve para eliminar , modificacion, actualizacion dentro de una bd
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			String query = "insert into combate (titulo,fecha) values('" + c.getTitulo() + "','" + c.getFecha() + "');";
			//System.out.println(query);
			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			//System.out.println(rs);

			st.close(); // importante

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertarDatosCombatiente(CombatienteReal combatiente) { // sirve para eliminar , modificacion, actualizacion dentro de una bd
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			String query = "insert into combatiente (id,nombre,bIniciativa,clase,armadura,carisma,destreza" +
					",constitucion,inteligencia,sabiduria,fuerza,puntosDeGolpe," +
					"nombreJugador) values('" + combatiente.getId() + "','" + combatiente.getNombre() + "'," +
					"'" + combatiente.getBini() + "','" + combatiente.getClase() + "','" + combatiente.getArm() + "'," +
					"'" + combatiente.getCar() + "','" + combatiente.getDes() + "','" + combatiente.getCons() + "'" +
					",'" + combatiente.getInte() + "','" + combatiente.getSab() + "','" + combatiente.getFue() + "'," +
					"'" + combatiente.getPG() + "','" + combatiente.getNombreJugador() + "');";

			//System.out.println(query);

			// create the java st	atement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();
			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			int rs = st.executeUpdate(query);
			//System.out.println(rs);

			st.close(); // importante
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	/*public void insertarDatosInstanciaCombatiente(CombatienteInstancia combatiente, combate combateInstancia) { // sirve para eliminar , modificacion, actualizacion dentro de una bd
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			String query = "insert into instanciacombatiente(refCombatiente,estado,tiradaSalvacionF,tiradaSalvacionE,armaduraMod," +
					"puntosGolpesMod,refCombate) values('" + combatiente.getId() + "','" + combatiente.getEstado() + "','" + combatiente.getTiradaSalvacionFallido() + "', '" + combatiente.getTiradaSalvacionExitoso() + "'" +
					"+'" + combatiente.getArm() + "', '" + combatiente.getPG() + "','" + combateInstancia.getTitulo() + "' );";

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
	} */
	public void extraerCombate() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			//------- Extraer combates

			String query = "SELECT * FROM combate";

			// create the java statement: crea obj en java de la sentencia como tal
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset:	 lista de todos los objetos de la consulta anterior
			ResultSet rs = st.executeQuery(query);
			System.out.println("**********************");
			System.out.println("Combates: ");
			// iterate through the java resultset
			while (rs.next()) {
				String titulo = rs.getString("Titulo");
				String fecha = rs.getString("Fecha");

				combate combateAux = new combate(titulo, fecha);

				//combatesBD.add(combateAux);

				// print the results
				System.out.format("%s,%s \n", titulo, fecha);
			}
			System.out.println("**********************");
			st.close(); // importante
		} catch (ClassNotFoundException | SQLException e) {}
	}

	public void extraerCombatientes() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			// ---------- Extraer combatientes

			String query1 = "SELECT * FROM combatiente";

			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);

			System.out.println("**********************");
			System.out.println("Combatientes BD:");
			while (rs1.next()) {
				int id = rs1.getInt("id");
				String nombre = rs1.getString("nombre");
				int bIniciativa = rs1.getInt("bIniciativa");
				String clase = rs1.getString("clase");
				int armadura = rs1.getInt("armadura");
				int carisma = rs1.getInt("carisma");
				int destreza = rs1.getInt("destreza");
				int constitucion = rs1.getInt("constitucion");
				int inteligencia = rs1.getInt("inteligencia");
				int sabiduria = rs1.getInt("sabiduria");
				int fuerza = rs1.getInt("fuerza");
				int puntosDeGolpe = rs1.getInt("puntosDeGolpe");
				String nombreJugador = rs1.getString("nombreJugador");

				CombatienteReal combatienteAux = new CombatienteReal(nombre, nombreJugador, "1", clase,
						bIniciativa, puntosDeGolpe, armadura, fuerza, inteligencia, destreza, constitucion, carisma, sabiduria, id);
				System.out.format("%s,%s \n", nombre, nombreJugador);
				//combatienteRealBD.add(combatienteAux); // combatientes guardados
			}
			System.out.println("**********************");
			st1.close(); // importante
		} catch (ClassNotFoundException | SQLException e) {}
	}

	public void extraerInstanciaCombatiente(combate c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conéctese a la "biblioteca" de datos
			String url = "jdbc:mysql://localhost:3306/dyd";
			String user = "root";
			String passwd = "";
			Connection conn = DriverManager.getConnection(url, user, passwd);

			// ---------- Extraer combatientes instancia
			String refCombate = c.getTitulo();
			String queryValidacion = "SELECT * FROM instanciacombatiente WHERE refCombate='" + refCombate + "'"; // validar qu esten en un combate
			Statement st3 = conn.createStatement();
			ResultSet rs3 = st3.executeQuery(queryValidacion);
			String queryForanea = "SELECT * FROM combatiente WHERE id= instanciacombatiente.refCombatiente"; // validar combatiente
			Statement st4 = conn.createStatement();
			ResultSet rs4 = st4.executeQuery(queryForanea);
			while (rs3.next() || rs4.next()) {
				int id = rs4.getInt("id");
				String nombre = rs4.getString("nombre");
				int bIniciativa = rs4.getInt("bIniciativa");
				String clase = rs4.getString("clase");
				int carisma = rs4.getInt("carisma");
				int destreza = rs4.getInt("destreza");
				int constitucion = rs4.getInt("constitucion");
				int inteligencia = rs4.getInt("inteligencia");
				int sabiduria = rs4.getInt("sabiduria");
				int fuerza = rs4.getInt("fuerza");
				String nombreJugador = rs4.getString("nombreJugador");
				String estado = rs3.getString("estado");
				String refCombatiente = rs3.getString("refCombatiente");
				int tiradaSalvacionF = rs3.getInt("tiradaSalvacionF");
				int tiradaSalvacionE = rs3.getInt("tiradaSalvacionE");
				int armadura = rs3.getInt("armaduraMod");
				int PG = rs3.getInt("puntosGolpesMod");
				String tituloCombate = rs3.getString("refCombate");

				CombatienteInstancia combatienteInstanciaAux = new CombatienteInstancia(nombre, nombreJugador, clase, "imagen", estado, bIniciativa, PG, armadura, fuerza, inteligencia, destreza, constitucion, carisma, sabiduria, id, tiradaSalvacionE, tiradaSalvacionF, tituloCombate);
				//combatienteInstanciaBD.add(combatienteInstanciaAux); // combatientes para de un combate en especifico
			}st3.close();
			st4.close();
		} catch (ClassNotFoundException | SQLException e) {}
	}

	public void guardarCombateBD(combate c, configuracion combatientes){
		estructuraDeDatos e = new estructuraDeDatos();
		e.insertarDatosCombate(c);
		for (int i=0 ;combatientes.combatientes.size()>i;i++) {
			e.insertarDatosCombatiente(combatientes.combatientes.get(i));
			System.out.println(combatientes.combatientes.get(i).getNombre());
			//e.insertarDatosInstanciaCombatiente(,c);
		}
		// FALTA GUARDAR COMBATIENTES EN EL SISTEMA
	}
}

