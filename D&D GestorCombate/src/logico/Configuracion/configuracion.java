package logico.Configuracion;
import logico.Combatiente.CombatienteReal;
import logico.Combatiente.Jugador;

import java.util.ArrayList;

public class configuracion { // prepara el combate

    // Arraylist de combatientes reales
	ArrayList<CombatienteReal> combatientes = new ArrayList<CombatienteReal>();

	// Eliminar combatiente en especifico

	public configuracion() {

	}

	public ArrayList<CombatienteReal> getCombatientes() {
		return combatientes;
	}

	public void setCombatientes(ArrayList<CombatienteReal> combatientes) {
		this.combatientes = combatientes;
	}
}
