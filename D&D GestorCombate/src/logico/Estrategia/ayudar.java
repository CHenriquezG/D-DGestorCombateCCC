package logico.Estrategia;

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
    public void EfectuarEstrategia(IteradorCombatiente CombTurn, IteradorCombatiente Implicado) {

    }

    @Override
    public boolean TieneOpcionReaccion() {
        return false;
    }
}
