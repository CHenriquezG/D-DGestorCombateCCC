import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;
import logico.Configuracion.iniciativa;
import logico.Estrategia.Estrategia;
import logico.Estrategia.contexto;
import  logico.InstanciaCombate.combate;
import logico.Lista.IteradorCombatiente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ControladorJuego {
    @FXML
    VBox tabla;
    @FXML
    ImageView siguienteFase,siguienteTurno,CurDno;
    @FXML
    BorderPane back;
    @FXML
    ChoiceBox contenidoAccion;
    @FXML
    HBox golpeCurar,reaccion;
    contexto contexto = new contexto();
    combate combateinstancia ;
    iniciativa i;
    IteradorCombatiente combatienteActual;

    String[] clavesAccion = {"Atacar","Moverse","PasarTurno","Curar","Ayudar"};

    @FXML
    ImageView imaSalir;

    public void initialize(){/**

        paisaje.fitWidthProperty().bind(fcontent.widthProperty());
        paisaje.fitHeightProperty().bind(fcontent.heightProperty());**/
        combateinstancia = new combate();

        this.combatienteActual= new IteradorCombatiente();

        contenidoAccion.getItems().addAll(clavesAccion);
        contenidoAccion.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Estrategia est =contexto.ObtenerEstrategia((String) contenidoAccion.getItems().get((Integer) newValue));
                //HBox golpeCurar,reaccion;
/**
                if(est.TieneOpcionAyudar()){
                    System.out.println("puede ayudar");
                    siguienteFase.setVisible(true);
                    golpeCurar.setVisible(true);


                }else{
                    golpeCurar.setVisible(false);
                }
                if(est.TieneOpcionDaño()){
                    System.out.println("puede atacar");
                    siguienteFase.setVisible(true);
                    golpeCurar.setVisible(true);
                }else {
                    golpeCurar.setVisible(true);

                }
                if(est.TieneOpcionReaccion()){
                    System.out.println("puede reaccionar el enemigo");
                    siguienteFase.setVisible(true);

                }else{

                }

                if(!est.TieneOpcionReaccion() && est.TieneOpcionDaño() && est.TieneOpcionAyudar()){
                    siguienteTurno.setVisible(true);
                    siguienteFase.setVisible(false);
                }else{

                }*/
                reaccion.setVisible(est.TieneOpcionReaccion());
                golpeCurar.setVisible(est.TieneOpcionDaño() || est.TieneOpcionAyudar());
                siguienteTurno.setVisible(!est.TieneOpcionDaño() && !est.TieneOpcionReaccion() && !est.TieneOpcionAyudar());
                siguienteFase.setVisible(est.TieneOpcionDaño() || est.TieneOpcionReaccion() || est.TieneOpcionAyudar());

                System.out.println("+++++++++++++++++++++++++++++++++");
            }
        });

        //timer solo para mostrar el combatiente del turno actual
        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("actual: "+combatienteActual.getCombatiente().getNombre());
            }
        }, 00,3000);

        siguienteTurno.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (combatienteActual.getSiguiente()!=null) {
                    combatienteActual = combatienteActual.getSiguiente();
                    System.out.println("actual: " + combatienteActual.getCombatiente().getNombre());
                }
                else{
                    combatienteActual = i.getD();
                }

            }
        });

    }
    void initData(BorderPane customer, VBox tabla, Stage primary, configuracion config) {
        //customer.setPrefWidth(back.getPrefWidth());
        //customer.setPrefHeight(back.getPrefHeight());

        //Scene s = new Scene(customer);
        //primary.setScene(s);

        ArrayList<CombatienteReal> combatientes= new ArrayList<CombatienteReal>();

        combatientes=config.combatientes;

        i = new iniciativa();
        i.GenerarOrdenCombatiente(combatientes);

        this.combatienteActual = i.getD();


        primary.setWidth(back.getPrefWidth());
        primary.setHeight(back.getPrefHeight());
        back = customer;
        this.tabla.getChildren().setAll(tabla.getChildren());
    }

}
