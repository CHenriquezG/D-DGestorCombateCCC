package logico.InstanciaCombate;

import logico.Estrategia.Estrategia;
import logico.Estrategia.contexto;
import logico.Lista.IteradorCombatiente;

import java.util.ArrayList;

public class turno {

    accion acc ;
    ArrayList<reaccion> reac = new ArrayList<>();
    contexto contex = new contexto();

    public turno(){

    }




    public Estrategia SolicitarAccion(String accion){
        return acc.getEst();
    }
    public Estrategia solicitarreaccion(String reaccion,int indice){

        return reac.get(indice).getEst();
    }


    public void ConstruirAccion(IteradorCombatiente aturno,IteradorCombatiente aaccion,String clave){
        acc = new accion(aturno,aaccion,clave);

    }
    public void ConstruirReacciones(IteradorCombatiente iniReac,String clave){
        reac.add(new reaccion(iniReac,acc.getTu(),clave));
    }
}
