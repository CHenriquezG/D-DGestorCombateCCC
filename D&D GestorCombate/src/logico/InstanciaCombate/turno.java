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


    public void EfectuarTurno(){
        for(int i=0;i<reac.size();i++){
            reac.get(i).EfectuarEstrategia();
        }
        acc.EfectuarEstrategia();
    }



    public Estrategia SolicitarAccion(String accion){
        return acc.getEst();
    }
    public Estrategia Solicitarreaccion(String reaccion,int indice){

        return reac.get(indice).getEst();
    }


    public void ConstruirAccion(IteradorCombatiente aturno,IteradorCombatiente aaccion,String clave,int dado){
        acc = new accion(aturno,aaccion,clave,dado);

    }
    public void ConstruirReacciones(IteradorCombatiente iniReac,String clave,int dado){
        reac.add(new reaccion(iniReac,acc.getTu(),clave,dado));
    }
}
