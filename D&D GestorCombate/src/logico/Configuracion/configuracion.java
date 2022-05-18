package logico.Configuracion;
import logico.Combatiente.Combatiente;
import logico.Combatiente.CombatienteReal;
import java.util.ArrayList;

// variable global para aumentar máximo

public class configuracion { // prepara el combate

    // Arraylist de combatientes reales
	public ArrayList<CombatienteReal> combatientes = new ArrayList<CombatienteReal>(); // lista de combatientes

	public configuracion() {

	}

	// Agregar combatiente a la lista combatientes
	public void setCombatiente(String nombre,String nombreJugador,String imagen, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int sab ,int id) {  // crear personaje

		CombatienteReal aux = new CombatienteReal(nombre, nombreJugador, imagen, clase,  bini,  PG,  arm,  fue,  inte,  des,  cons,  car, sab,id);
			combatientes.add(aux);
		}

	public void getCombatientes() { // obtiene todos los combatientes
		for(int i=0; i< combatientes.size(); i++) {
			System.out.println(combatientes.get(i));
		}
	}

	public CombatienteReal getCombatiente(int i) {

			CombatienteReal r = combatientes.get(i);
			CombatienteReal aux = new CombatienteReal(r.getNombre(),r.getNombreJugador(),r.getImagen(),r.getClase(),r.getBini()
				,r.getPG(),r.getArm(),r.getFue(),r.getInte(),r.getDes(),r.getCons(),r.getCar(),r.getSab(),r.getId());
			return aux;
	}

	public void borrarListadeCombatientes(){
		combatientes.removeAll(combatientes);
	}
	public void borrarCombatienteenEspecifico(int indice){ // recibir indice
		combatientes.remove(indice);
	}

	 public void borrarCombatienteenEspecifico(CombatienteReal aux){ //  combatiente por ID
		for(int i=0; i < combatientes.size();i++){
			if(combatientes.get(i).getId() == aux.getId()) {
				combatientes.remove(i);
			}
		}
	}
}
