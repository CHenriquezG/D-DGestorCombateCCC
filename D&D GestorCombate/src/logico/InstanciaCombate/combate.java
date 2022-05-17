package logico.InstanciaCombate;

import javafx.fxml.FXMLLoader;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;

import java.util.ArrayList;

public class combate {
     ArrayList<CombatienteInstancia> Reaccionarios = new ArrayList<>();
     asalto actual;
    ArrayList<CombatienteReal> combatientes;
    configuracion c;

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

    public ArrayList<CombatienteInstancia> getReaccionarios() {
        return Reaccionarios;
    }

    public void setReaccionarios(ArrayList<CombatienteInstancia> reaccionarios) {
        Reaccionarios = reaccionarios;
    }




}
