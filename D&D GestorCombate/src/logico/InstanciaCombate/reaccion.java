package logico.InstanciaCombate;

import logico.Estrategia.Estrategia;
import logico.Estrategia.contexto;
import logico.Lista.IteradorCombatiente;

public class reaccion {
    String clavecontexto;
    Estrategia est;
    IteradorCombatiente tu;
    IteradorCombatiente implicado;

    public reaccion( IteradorCombatiente tu, IteradorCombatiente implicado,String clavecontexto) {
        this.clavecontexto = clavecontexto;
        this.tu = tu;
        this.implicado = implicado;
        contexto cont = new contexto();
        est = cont.ObtenerEstrategia(clavecontexto);
    }

    public String getClavecontexto() {
        return clavecontexto;
    }

    public void setClavecontexto(String clavecontexto) {
        this.clavecontexto = clavecontexto;
    }

    public Estrategia getEst() {
        return est;
    }

    public void setEst(Estrategia est) {
        this.est = est;
    }

    public IteradorCombatiente getTu() {
        return tu;
    }

    public void setTu(IteradorCombatiente tu) {
        this.tu = tu;
    }

    public IteradorCombatiente getImplicado() {
        return implicado;
    }

    public void setImplicado(IteradorCombatiente implicado) {
        this.implicado = implicado;
    }
}
