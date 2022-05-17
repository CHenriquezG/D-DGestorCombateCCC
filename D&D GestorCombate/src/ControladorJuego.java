import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logico.Combatiente.CombatienteInstancia;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;
import logico.Configuracion.iniciativa;
import logico.Estrategia.Estrategia;
import logico.Estrategia.contexto;
import  logico.InstanciaCombate.combate;
import logico.Lista.Iterador;
import logico.Lista.IteradorCombatiente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ControladorJuego {
    @FXML
    VBox tabla,tablaAccion,tablaSeleccion,tablaReaccion,SeleccionReaccion;
    @FXML
    ImageView siguienteFase,siguienteTurno,siguienteReac,siguientePer,CurDno,imaReAc;
    @FXML
    BorderPane back;
    @FXML
    ChoiceBox contenidoAccion,contenidoReaccion;
    @FXML
    HBox golpeCurar,reaccion;
    @FXML
    CheckBox verReaccion;
    contexto contexto = new contexto();
    combate combateinstancia ;
    iniciativa i;
    IteradorCombatiente combatienteActual;
    IteradorCombatiente aux;

    @FXML
    TextField IngresoR,IngresoA;
    @FXML
    Label caracteristicas;
    int auxTimerCaracteristicas=0;
    String claveAccion,claveReaccion;
    String[] clavesAccion = {"Atacar","Moverse","PasarTurno","Curar","Ayudar"};
    String[] clavesReaccion = {"Contraatacar","PasarTurno"};
    @FXML
    ImageView imaSalir;
    @FXML
    ImageView imaPerfil;
    @FXML
    ScrollPane ContieneReacciones;

    public void initialize(){/**

        paisaje.fitWidthProperty().bind(fcontent.widthProperty());
        paisaje.fitHeightProperty().bind(fcontent.heightProperty());**/
        combateinstancia = new combate();

        Font font =
                Font.loadFont(getClass()
                        .getResourceAsStream("\\Recursos\\Diseño\\SF Atarian System.ttf"), 25);

        caracteristicas.setText("");
        caracteristicas.setFont(font);

        this.combatienteActual= new IteradorCombatiente();
        contenidoReaccion.getItems().addAll(clavesReaccion);
        contenidoAccion.getItems().addAll(clavesAccion);
        contenidoAccion.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                claveAccion = (String) contenidoAccion.getItems().get((Integer) newValue);
                Estrategia est =contexto.ObtenerEstrategia(claveAccion);
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

        contenidoReaccion.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                claveReaccion = (String) contenidoReaccion.getItems().get((Integer) newValue);
                Estrategia est =contexto.ObtenerEstrategia(claveReaccion);
                //HBox golpeCurar,reaccion;

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
                Platform.runLater(() -> {
                    if(auxTimerCaracteristicas%2==0){
                        //nombre, fuerza, nombre jugador, int, des, armadura, constsitencia, bonusIniciativa, ptsAct, ptsMax
                        caracteristicas.setText("nombre: "+combatienteActual.getCombatiente().getNombre()+"\nfuerza: "+combatienteActual.getCombatiente().getFue()+"\ninteligencia: "+combatienteActual.getCombatiente().getInte()+"\ndestreza: "+combatienteActual.getCombatiente().getDes()+"\narmadura: "+combatienteActual.getCombatiente().getArm());
                    }
                    else{
                        caracteristicas.setText("constsitencia: "+combatienteActual.getCombatiente().getCons()+"\niniciativa: "+combatienteActual.getCombatiente().getIniciativa()+"\nptsAct: \nptsMax: ");

                    }
                    auxTimerCaracteristicas=auxTimerCaracteristicas+1;

                });


            }
        }, 00,4600);

        imaPerfil.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                auxTimerCaracteristicas=auxTimerCaracteristicas+1;
                if(auxTimerCaracteristicas%2==0){
                    //nombre, fuerza, nombre jugador, int, des, armadura, constsitencia, bonusIniciativa, ptsAct, ptsMax
                    caracteristicas.setText("nombre: "+combatienteActual.getCombatiente().getNombre()+"\nfuerza: "+combatienteActual.getCombatiente().getFue()+"\ninteligencia: "+combatienteActual.getCombatiente().getInte()+"\ndestreza: "+combatienteActual.getCombatiente().getDes()+"\narmadura: "+combatienteActual.getCombatiente().getArm());
                }
                else{
                    caracteristicas.setText("constsitencia: "+combatienteActual.getCombatiente().getCons()+"\niniciativa: "+combatienteActual.getCombatiente().getIniciativa()+"\nptsAct: \nptsMax: ");

                }

            }

        });

        siguientePer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(combateinstancia.getReaccionarios().size() != 0){
                    combateinstancia.ConstruirReacccionEnAsalto(combateinstancia.getReaccionarios().get(0),claveReaccion,Integer.parseInt(IngresoR.getText()));
                    combateinstancia.getReaccionarios().remove(0);

                }

                if(combateinstancia.getReaccionarios().size() == 0){

                    combateinstancia.EfectuarTurno();
                    SeleccionReaccion.getChildren().removeAll(SeleccionReaccion.getChildren());
                    imaReAc = new ImageView(new Image(getClass().getResourceAsStream("Recursos\\Botones\\Reaccion.png")));

                    tablaAccion.setVisible(true);
                    tablaSeleccion.setVisible(false);
                    tablaReaccion.setVisible(false);
                    DefinirPerfil(combatienteActual.getCombatiente());
                }else{
                    CombatienteInstancia aux = combateinstancia.getReaccionarios().get(0).getCombatiente();
                    DefinirPerfil(aux);

                }
                // aca reseatearia todo

                System.out.println("hola");
            }
        });

        siguienteReac.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {



                if(combateinstancia.getReaccionarios().size() == 0){
                    combateinstancia.EfectuarTurno();
                    if (combatienteActual.getSiguiente()!=null) {
                        combatienteActual = combatienteActual.getSiguiente();
                    }
                    else{
                        combatienteActual = i.getD();
                    }
                    DefinirPerfil(combatienteActual.getCombatiente());

                    tablaAccion.setVisible(true);
                    tablaSeleccion.setVisible(false);
                    tablaReaccion.setVisible(false);
                }else{
                    CombatienteInstancia aux = combateinstancia.getReaccionarios().get(0).getCombatiente();
                    DefinirPerfil(aux);
                    tablaAccion.setVisible(false);
                    tablaSeleccion.setVisible(false);
                    tablaReaccion.setVisible(true);
                }

            }
        });

        siguienteTurno.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hola");

                imaReAc = new ImageView(new Image(getClass().getResourceAsStream("Recursos\\Botones\\Reaccion.png")));
                if (combatienteActual.getSiguiente()!=null) {
                    combatienteActual = combatienteActual.getSiguiente();


                }
                else{
                    combatienteActual = i.getD();
                }
                System.out.println("actual turno de: " + combatienteActual.getCombatiente().getNombre());
                caracteristicas.setText("nombre: "+combatienteActual.getCombatiente().getNombre()+"\nfuerza: "+combatienteActual.getCombatiente().getFue()+"\ninteligencia: "+combatienteActual.getCombatiente().getInte()+"\ndestreza: "+combatienteActual.getCombatiente().getDes()+"\narmadura: "+combatienteActual.getCombatiente().getArm());
                imaPerfil.setImage(new Image(getClass().getResourceAsStream(combatienteActual.getCombatiente().getImagen())));
            }
        });

        siguienteFase.setOnMouseClicked(new EventHandler<MouseEvent>() {// con este boton pasa a la subvista de reacciones o pasa de turno
            @Override
            public void handle(MouseEvent event) {
                combateinstancia.ConstruirAccionEnAsalto(combatienteActual,combatienteActual,claveAccion,Integer.parseInt(IngresoA.getText()));
                if(verReaccion.isSelected()){
                    tablaAccion.setVisible(false);
                    tablaSeleccion.setVisible(true);
                    tablaReaccion.setVisible(false);
                }else{
                    combateinstancia.EfectuarTurno();
                    imaReAc = new ImageView(new Image(getClass().getResourceAsStream("Recursos\\Botones\\Reaccion.png")));
                    if (combatienteActual.getSiguiente()!=null) {
                        combatienteActual = combatienteActual.getSiguiente();


                    }
                    else{
                        combatienteActual = i.getD();
                    }
                    System.out.println("actual turno de: " + combatienteActual.getCombatiente().getNombre());
                    caracteristicas.setText("nombre: "+combatienteActual.getCombatiente().getNombre()+"\nfuerza: "+combatienteActual.getCombatiente().getFue()+"\ninteligencia: "+combatienteActual.getCombatiente().getInte()+"\ndestreza: "+combatienteActual.getCombatiente().getDes()+"\narmadura: "+combatienteActual.getCombatiente().getArm());
                    imaPerfil.setImage(new Image(getClass().getResourceAsStream(combatienteActual.getCombatiente().getImagen())));

                }



            }
        });


    }

    public void DefinirPerfil(CombatienteInstancia combatienteActual){
        System.out.println("actual turno de: " + combatienteActual.getNombre());
        caracteristicas.setText("nombre: "+combatienteActual.getNombre()+"\nfuerza: "+combatienteActual.getFue()+"\ninteligencia: "+combatienteActual.getInte()+"\ndestreza: "+combatienteActual.getDes()+"\narmadura: "+combatienteActual.getArm());
        imaPerfil.setImage(new Image(getClass().getResourceAsStream(combatienteActual.getImagen())));

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
        IteradorCombatiente c = i.d;
        tabla.getChildren().removeAll(tabla.getChildren());
        while(c != null) {
            BorderPane BP = c.getCombatiente().getGrafico();
            System.out.println(BP);
            aux = c;
            BP.setOnMouseClicked(new EventHandler<MouseEvent>() {
                final IteradorCombatiente est = aux;
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("hola "+ est.getCombatiente().getNombreJugador());

                    if(tablaSeleccion.isVisible()){

                        if(!combateinstancia.getReaccionarios().contains(est) && !combatienteActual.equals(est)) {
                            FXMLLoader loader = new FXMLLoader(
                                    getClass().getResource(
                                            "MiniEstadistica.fxml"
                                    )
                            );

                            VBox b;
                            try {
                                b = loader.load();
                                MiniEstadistica controller = loader.<MiniEstadistica>getController();
                                SeleccionReaccion.getChildren().add(b);
                                controller.initData(SeleccionReaccion, b, est,combateinstancia);
                                combateinstancia.getReaccionarios().add(est);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                }
            });

            tabla.getChildren().add(BP);
            c = c.getSiguiente();
        }







        this.combatienteActual = i.getD();
        imaPerfil.setImage(new Image(getClass().getResourceAsStream(combatienteActual.getCombatiente().getImagen())));


        //primary.setWidth(back.getPrefWidth());
        //primary.setHeight(back.getPrefHeight());

        back = customer;



        this.tabla.getChildren().setAll(tabla.getChildren());
        //this.tabla.getChildren().setAll(tabla.getChildren());
    }

}
