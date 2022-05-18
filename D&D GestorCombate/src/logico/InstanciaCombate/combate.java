package logico.InstanciaCombate;
import logico.Datos.estructuraDeDatos;
import javafx.fxml.FXMLLoader;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;

import java.util.ArrayList;
import java.util.Date;

public class combate {
    String titulo, fecha;
    configuracion c; // contiene array con combatientes

    public combate(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void guardarCombateBD(combate c, configuracion combatientes){
        estructuraDeDatos e = new estructuraDeDatos();
        e.insertarDatosCombate(c);
        for (int i=0 ;combatientes.combatientes.size()>i;i++) {
            e.insertarDatosCombatiente(combatientes.combatientes.get(i));
        }
        // FALTA GUARDAR COMBATIENTES EN EL SISTEMA

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

}
