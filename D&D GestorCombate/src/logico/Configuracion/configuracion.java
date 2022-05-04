package logico.Configuracion;
import logico.Combatiente.CombatienteReal;
import logico.Combatiente.Jugador;

import java.util.ArrayList;

public class configuracion { // prepara el combate

    // Arraylist de combatientes reales
	ArrayList<CombatienteReal> combatientes = new ArrayList<CombatienteReal>(); // lista de combatientes



	public configuracion() {

	}

	// Agregar combatiente a la lista combatientes
	public void setCombatiente(String nombre,String nombreJugador,String imagen, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car)) {  // crear personaje
			CombatienteReal aux = new CombatienteReal(nombre, nombreJugador, imagen,  clase,  bini,  PG,  arm,  fue,  inte,  des,  cons,  car);
			combatientes.add(aux);
		}

	public void getCombatientes() { // obtiene todos los combatientes
		for(i=0; i< combatientes.size(); i++) {
			System.out.println(combatientes.get(i));
		}
	}

	public void borrarListadeCombatientes(){
		combatientes.removeAll(combatientes);
	}
	public void borrarCombatienteenEspecifico(int indice){ // recibir indice
		combatientes.remove(indice);
	}

	public void borrarCombatienteenEspecifico(CombatienteReal aux){ //  combatiente
		for(i=0; i < combatientes.size();i++){
			if( combatientes.get(i).getId() = aux.getId()) {
				combatientes.remove(aux);
			}
		}
	}
}
