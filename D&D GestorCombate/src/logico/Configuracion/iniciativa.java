package logico.Configuracion;

import javafx.scene.image.Image;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CreadoraEnCombate;
import logico.Lista.IteradorCombatiente;

import java.util.Random;

public class iniciativa {
    IteradorCombatiente c,d = null;
    boolean fs;
    public iniciativa() {
        GenerarOrdenCombatiente();



    }

    private void GenerarIniciativa(CombatienteInstancia c){
        Random r = new Random();
        c.setIniciativa(r.nextInt(20)+1+c.getBini());

    }

    public IteradorCombatiente GenerarOrdenCombatiente(){

        CreadoraEnCombate f = new CreadoraEnCombate();

        IteradorCombatiente aux;
        CombatienteInstancia y;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            // aca se generan las instancias de combatientes en base a los combatientes reales
            y = (CombatienteInstancia) f.CrearCombatiente("ew", "eret", "dsdsf", "sd", 3, 3, 3, 3, 3, 3, 3, 5);
            GenerarIniciativa(y);// aca se genera las iniciativas de cada combatiente
            aux = new IteradorCombatiente(y);
            c = d;
            fs = true;
            do {

                if (d == null){
                    d = aux;
                    fs = false;
                }else if(c.getCombatiente().getIniciativa() <= aux.getCombatiente().getIniciativa()){
                    c.InsertarIzquierda(aux);
                    fs = false;
                    if(c.equals(d)){
                        d = aux;
                    }
                }else if(!c.ExisteSiguiente()){
                    c.InsertarDerecha(aux);
                    fs = false;
                }else {
                    c = c.getSiguiente();
                }
            }while(fs);
            c = d;
            while(c != null){
                CombatienteInstancia ad = c.getCombatiente();
                System.out.print(ad.getIniciativa()+" - ");
                c = c.getSiguiente();
            }
            System.out.println();


        }


        return d;

    }



}
