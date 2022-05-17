package logico.Estrategia;

import logico.Combatiente.CombatienteInstancia;
import logico.Lista.IteradorCombatiente;

public class ayudar implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
    }

    public boolean TieneOpcionAyudar() {
        return true;
    }

    @Override
    public boolean TieneOpcionOtraAccion() {
        return false;
    }

    @Override
    public void EfectuarEstrategia(IteradorCombatiente CombTurn, IteradorCombatiente Implicado,int dado) {
        CombatienteInstancia afectado = Implicado.getCombatiente();
        afectado.setEstado("consciente");
        afectado.setPG(1);

    }

    @Override
    public boolean TieneOpcionReaccion() {
        return false;
    }
}
