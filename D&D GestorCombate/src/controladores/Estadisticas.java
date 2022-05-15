package controladores;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;

public class Estadisticas {
    @FXML
    ImageView imaper;
    @FXML
    Label jugador,nombre,pts;
    @FXML
    BorderPane tablero;

    configuracion conf;
    int combR;
    public void initialize(){
        jugador.setText("fsdfdsfdsf");


        tablero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                conf.getCombatientes();
            }
        });




    }
    public void initData(int customer, configuracion conf) {
        combR= customer;
        this.conf = conf;
    }


    public void SeleccionarEstadistica(){

    }

    public ImageView getImaper() {
        return imaper;
    }

    public void setImaper(ImageView imaper) {
        this.imaper = imaper;
    }

    public Label getJugador() {
        return jugador;
    }

    public void setJugador(Label jugador) {
        this.jugador = jugador;
    }

    public Label getNombre() {
        return nombre;
    }

    public void setNombre(Label nombre) {
        this.nombre = nombre;
    }

    public Label getPts() {
        return pts;
    }

    public void setPts(Label pts) {
        this.pts = pts;
    }

    public BorderPane getTablero() {
        return tablero;
    }

    public void setTablero(BorderPane tablero) {
        this.tablero = tablero;
    }

    public configuracion getConf() {
        return conf;
    }

    public void setConf(configuracion conf) {
        this.conf = conf;
    }

    public int getCombR() {
        return combR;
    }

    public void setCombR(int combR) {
        this.combR = combR;
    }
}
