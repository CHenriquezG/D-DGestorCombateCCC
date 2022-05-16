package logico.Lista;

import logico.Combatiente.CombatienteInstancia;

public class IteradorCombatiente implements Iterador {
    CombatienteInstancia combatiente ;
    IteradorCombatiente siguiente;
    IteradorCombatiente Atras;

    public IteradorCombatiente(CombatienteInstancia c){
        this.combatiente = c;

    }

    @Override
    public IteradorCombatiente getSiguiente() {
        return siguiente;
    }

    @Override
    public boolean ExisteSiguiente() {
        return getSiguiente() != null;
    }

    @Override
    public void InsertarDerecha(IteradorCombatiente c) {
        IteradorCombatiente aux = Atras;



        if(siguiente != null){

            c.setSiguiente(siguiente);
            siguiente.setAtras(c);

        }

        this.siguiente = c;
        //System.out.println(getSiguiente().combatiente.getCar());
        c.setAtras(this);


    }

    @Override
    public void InsertarIzquierda(IteradorCombatiente c) {
        if(Atras != null){
            Atras.setSiguiente(c);
            c.setAtras(Atras);
        }
        this.Atras = c;
        //System.out.println(getSiguiente().combatiente.getCar());
        c.setSiguiente(this);

    }

    public IteradorCombatiente(){
        this.combatiente =  new CombatienteInstancia("","","","","",0,0,0,0,0,0,0,0,0,0);

    }

    public CombatienteInstancia getCombatiente() {
        return combatiente;
    }

    public void setCombatiente(CombatienteInstancia combatiente) {
        this.combatiente = combatiente;
    }

    public void setSiguiente(IteradorCombatiente siguiente) {
        this.siguiente = siguiente;
    }

    public IteradorCombatiente getAtras() {
        return Atras;
    }

    public void setAtras(IteradorCombatiente atras) {
        Atras = atras;
    }
}
