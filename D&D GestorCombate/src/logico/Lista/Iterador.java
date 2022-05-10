package logico.Lista;

import logico.Combatiente.CombatienteInstancia;

public interface Iterador {



    public IteradorCombatiente getSiguiente();
    public boolean ExisteSiguiente();
    public void InsertarDerecha(IteradorCombatiente c);
    public void InsertarIzquierda(IteradorCombatiente c);
}
