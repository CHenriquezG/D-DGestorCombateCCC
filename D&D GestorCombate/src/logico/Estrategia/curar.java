package logico.Estrategia;

import logico.Combatiente.CombatienteInstancia;
import logico.Lista.IteradorCombatiente;

public class curar  implements Estrategia{
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
        return true;
    }

    @Override
    public void EfectuarEstrategia(IteradorCombatiente CombTurn, IteradorCombatiente Implicado,int dado) {
        CombatienteInstancia afectado = Implicado.getCombatiente();
        afectado.setPG(afectado.getPG() + dado);
        afectado.getPGG().setText(String.valueOf(afectado.getPG()));
        VerificarEstado(Implicado);
    }
}
