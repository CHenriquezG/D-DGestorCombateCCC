package logico.InstanciaCombate;

import javafx.fxml.FXMLLoader;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;

import java.util.ArrayList;

public class combate {
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

}
