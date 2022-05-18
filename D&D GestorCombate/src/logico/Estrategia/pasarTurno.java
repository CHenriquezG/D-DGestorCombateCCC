package logico.Estrategia;

import logico.Lista.IteradorCombatiente;

public class pasarTurno implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
    }

    @Override
    public boolean TieneOpcionReaccion() {
        return false;
    }

    @Override
    public boolean TieneOpcionAyudar() {
        return false;
    }

    @Override
    public boolean TieneOpcionOtraAccion() {
        return false;
    }

    @Override
    public void EfectuarEstrategia(IteradorCombatiente CombTurn, IteradorCombatiente Implicado,int dado) {

    }
}
