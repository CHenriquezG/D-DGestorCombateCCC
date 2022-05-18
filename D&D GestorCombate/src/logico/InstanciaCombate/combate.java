package logico.InstanciaCombate;
import logico.Datos.estructuraDeDatos;
import javafx.fxml.FXMLLoader;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;
import logico.Lista.IteradorCombatiente;

import java.util.ArrayList;
import java.util.Date;

public class combate {
    String titulo, fecha;
    ArrayList<IteradorCombatiente> Reaccionarios = new ArrayList<>();
        asalto actual = new asalto();
    ArrayList<CombatienteReal> combatientes;
    configuracion c;


    public combate(String titulo, String fecha){
        this.titulo = titulo;
        this.fecha = fecha;
        InicializarAsalto();
    }

    public void CrearAsalto(){
        actual = new asalto();

    }

    public void InicializarAsalto(){
        actual.CrearTurno();
    }


    public void EfectuarTurno(){
        actual.EfectuarTurno();
        actual.ReiniciarAsalto();
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

    public ArrayList<CombatienteReal> getCombatientes(){
        combatientes = c.combatientes;
        return combatientes;
    }
}
