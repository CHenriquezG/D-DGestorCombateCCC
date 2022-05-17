package logico.Estrategia;

import logico.Combatiente.CombatienteInstancia;
import logico.Lista.IteradorCombatiente;

public class atacar  implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return true;
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
        System.out.println("ataco");
        CombatienteInstancia afectado = Implicado.getCombatiente();
        afectado.setPG(afectado.getPG() - dado);
        afectado.getPGG().setText(String.valueOf("PG:"+afectado.getPG()));
        VerificarEstado(Implicado);


    }


}
