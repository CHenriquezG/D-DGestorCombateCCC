package logico.Estrategia;

import logico.Lista.IteradorCombatiente;

public interface Estrategia {
    public boolean TieneOpcionDaño();
    public boolean TieneOpcionReaccion();
    public boolean TieneOpcionAyudar();
    public void EfectuarEstrategia(IteradorCombatiente CombTurn,IteradorCombatiente Implicado);
}
