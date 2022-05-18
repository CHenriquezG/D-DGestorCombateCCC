package logico.Estrategia;

import logico.Lista.IteradorCombatiente;

public class moverse implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
    }

    @Override
    public boolean TieneOpcionReaccion() {
        return true;
    }

    @Override
    public boolean TieneOpcionAyudar() {
        return false;
    }

    @Override
    public boolean TieneOpcionOtraAccion() {
        return true;
    }

    @Override
    public void EfectuarEstrategia(IteradorCombatiente CombTurn, IteradorCombatiente Implicado,int dado) {

    }
}
