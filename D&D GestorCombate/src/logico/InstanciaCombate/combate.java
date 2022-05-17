package logico.InstanciaCombate;

import javafx.fxml.FXMLLoader;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;
import logico.Lista.IteradorCombatiente;

import java.util.ArrayList;

public class combate {
     ArrayList<IteradorCombatiente> Reaccionarios = new ArrayList<>();
     asalto actual = new asalto();
    ArrayList<CombatienteReal> combatientes;
    configuracion c;
    public combate(){
        InicializarAsalto();
    }

    public void CrearAsalto(){
        actual = new asalto();

    }

    public void InicializarAsalto(){
        actual.CrearTurno();
    }

    public void ReiniciarAsalto(){
        actual.ReiniciarAsalto();

    }
    public void EfectuarTurno(){
        actual.EfectuarTurno();
    }

    public void ConstruirAccionEnAsalto(IteradorCombatiente aturno,IteradorCombatiente aaccion,String clave,int dado){
        actual.ConstruirAccionesCombatiente(aturno,aaccion,clave,dado); // valoreas int de prueba
    }
    public void ConstruirReacccionEnAsalto(IteradorCombatiente reaccionario,String clave,int dado){
        actual.ConstruirReaccionesCombatiente(reaccionario,clave,dado); // valores int a prueba
    }

    public void crearListaPersonajes(){
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "VentanaFormulario.fxml"
                )
        );

        //ControladorFormulario controller = loader.<ControladorFormulario>getController();
        //combatientes= new ArrayList<CombatienteReal>();

       // combatientes=c.combatientes;
    }

    public ArrayList<IteradorCombatiente> getReaccionarios() {
        return Reaccionarios;
    }

    public void setReaccionarios(ArrayList<IteradorCombatiente> reaccionarios) {
        Reaccionarios = reaccionarios;
    }



    public IteradorCombatiente CrearIteradores(ArrayList <CombatienteInstancia> reaccionarios){
        IteradorCombatiente inicio = new IteradorCombatiente(reaccionarios.get(0)),aux;
        for(int i=1;i<reaccionarios.size();i++){
            aux = new IteradorCombatiente(reaccionarios.get(i));
            inicio.InsertarDerecha(aux);
        }
        return inicio;

    }


}
