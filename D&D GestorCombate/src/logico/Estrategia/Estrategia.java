package logico.Estrategia;

import logico.Combatiente.CombatienteInstancia;
import logico.Lista.IteradorCombatiente;

public interface Estrategia {
    public boolean TieneOpcionDaño();
    public boolean TieneOpcionReaccion();
    public boolean TieneOpcionAyudar();
    public void EfectuarEstrategia(IteradorCombatiente CombTurn,IteradorCombatiente Implicado,int dado);
    public default boolean VerificarEstado(IteradorCombatiente Implicado){
        CombatienteInstancia comb = Implicado.getCombatiente();
        if(comb.getPG() <= - 10 ) { // no es estandar
            comb.setEstado("muerto");
        }else if(comb.getPG() <= 0){
            comb.setEstado("inconsciente");

        }else{
            comb.setEstado("consciente");

        }
        return true;
    }
}
