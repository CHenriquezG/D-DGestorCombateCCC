package logico.Configuracion;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CombatienteReal;
import logico.Combatiente.CreadoraEnCombate;
import logico.Lista.IteradorCombatiente;

import java.util.ArrayList;
import java.util.Random;

public class iniciativa {
    public IteradorCombatiente c,d = null;
    boolean fs;


    private void GenerarIniciativa(CombatienteInstancia c){
        Random r = new Random();
        c.setIniciativa(r.nextInt(20)+1+c.getBini());

    }

    public IteradorCombatiente GenerarOrdenCombatiente(ArrayList<CombatienteReal> combatientes){
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "Configuracion.fxml"
                    )
            );

            configuracion controller = loader.<configuracion>getController();

        CreadoraEnCombate f = new CreadoraEnCombate();

        IteradorCombatiente aux;
        CombatienteInstancia y;
        Random r = new Random();
        for (int i = 0; i < combatientes.size(); i++) {
            // aca se generan las instancias de combatientes en base a los combatientes reales
            y = (CombatienteInstancia) f.CrearCombatiente(combatientes.get(i).getNombre(), combatientes.get(i).getNombreJugador(), combatientes.get(i).getClase(), combatientes.get(i).getImagen(), combatientes.get(i).getBini(), combatientes.get(i).getPG(), combatientes.get(i).getArm(), combatientes.get(i).getFue(), combatientes.get(i).getInte(), combatientes.get(i).getDes(), combatientes.get(i).getCons(),combatientes.get(i).getCar(),combatientes.get(i).getSab(),combatientes.get(i).getId());
            y.setGrafico(combatientes.get(i).getGrafico());
            System.out.println(combatientes.get(i).getGrafico());
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
                System.out.println("a :"+combatientes.get(i).getNombre());
            }
            System.out.println();
        }
        return d;

    }



}
