package logico.InstanciaCombate;

import logico.Combatiente.CombatienteInstancia;
import logico.Lista.IteradorCombatiente;

import java.util.ArrayList;

public class asalto {
    private ArrayList<turno> coleccion = new ArrayList<>();
    private turno actual;

    // aca contendra el turno del combatiente con los subturnos de los reaccionarios
    ArrayList<turno> contexto = new ArrayList<>();



    public turno CrearTurno(){
        turno nuevo = new turno();
        actual = nuevo;
        coleccion.add(nuevo);
        return  nuevo;
    }
    public void ConstruirAccionesCombatiente(IteradorCombatiente aturno,IteradorCombatiente aaccion,String clave,int dado){
        actual.ConstruirAccion(aturno,aaccion,clave, dado);
    }
    public void ConstruirReaccionesCombatiente(IteradorCombatiente reaccionario,String clave,int dado){
        actual.ConstruirReacciones(reaccionario,clave,dado);
    }

    public void ReiniciarAsalto(){
        coleccion = new ArrayList<>();
        CrearTurno();
    }


    public void EfectuarTurno(){


    }

    public turno getActual() {
        return actual;
    }

    public void setActual(turno actual) {
        this.actual = actual;
    }


}
