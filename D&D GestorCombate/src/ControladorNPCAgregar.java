import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logico.Combatiente.Combatiente;
import logico.Combatiente.Creadora;
import logico.Combatiente.CreadoraReal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class ControladorNPCAgregar  implements Initializable {

    VBox tabla;
    @FXML
    public ListView listaNPC;
    @FXML
    ImageView imageView, imageView2;
    @FXML
    ImageView listo;

    Image auxima;
    @FXML
    Label detallesPersonaje;

    ControladorListaPersonajes controlador;
    @FXML
    Label myLabel;
    @FXML
    ImageView imaSiguente;

    Image animatedBroom = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Animated Broom.png"));
    Image awakenedTree = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Awakened Tree.png"));
    Image danielMoreno = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Daniel Moreno.png"));
    Image drowArachnomancer = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Drow Arachnomancer.png"));
    Image dryad = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Dryad.png"));
    Image dwarvenNoble = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Dwarven Noble.png"));
    Image erinyesSummoned = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Erinyes-Summoned.png"));
    Image gibberingMouther = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Gibbering Mouther.png"));
    Image gladiator = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Gladiator.png"));
    Image guardVillage = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Guard-Village.png"));
    Image hillGiant = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Hill Giant.png"));
    Image intellectDevourer = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Intellect Devourer.png"));
    Image phaseSpider = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Phase Spider.png"));
    Image planetar = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Planetar.png"));
    Image spy = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Spy.png"));
    Image youngRedDragon = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\Young Red Dragon.png"));






    String[] personajes = {"Animated Broom","Awakened Tree" ,"Daniel Moreno",
            "Drow Arachnomancer","Dryad","Dwarven Noble","Erinyes-Summoned",
            "Gibbering Mouther","Gladiator","Guard-Village","Hill Giant","Intellect Devourer","Phase Spider"
            ,"Planetar","Spy","Young Red Dragon"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Font font =
                Font.loadFont(getClass()
                        .getResourceAsStream("\\Recursos\\Diseño\\SF Atarian System.ttf"), 38);

        detallesPersonaje.setText("");
        detallesPersonaje.setFont(font);


        listo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage Ventana = new Stage();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "Estadisticas.fxml"
                        )
                );

                BorderPane b ;
                try {
                    b = (BorderPane)loader.load();
                    Estadisticas controller = loader.<Estadisticas>getController();
                    queImagen();
                    controller.imaper.setImage(auxima);
                    tabla.getChildren().add(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });


        listaNPC.getItems().addAll(personajes);
        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                    int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();
                    String personajeAux="";

                    if(personajeSelected>=0){
                        if(personajeSelected==0){
                            displayImage(animatedBroom);
                            personajeAux="Nombre: Animated Broom\nClase: Construct\nArmadura: 4\nPuntos de Golpe: 4\nInteligencia: 5\nDestreza: 5\nBonif. Iniciativa: 4\nFuerza: 2\nConstitucion: 5\nCarisma: 2";
                        }
                        if(personajeSelected==1){
                            displayImage(awakenedTree);
                            personajeAux="Nombre: Awakened Tree\nClase: Plant\nArmadura: 3\nPuntos de Golpe: 2\nInteligencia: 5\nDestreza: 6\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 5\nCarisma: 4";

                        }
                        if(personajeSelected==2){
                            displayImage(danielMoreno);
                            personajeAux="Nombre: Daniel Moreno\nClase: Aberration\nArmadura: 10\nPuntos de Golpe: 12\nInteligencia: 8\nDestreza: 11\nBonif. Iniciativa: 10\nFuerza:9\nConstitucion: 6\nCarisma: 6";

                        }
                        if(personajeSelected==3){
                            displayImage(drowArachnomancer);
                            personajeAux="Nombre: Drow Arachnomancer\nClase: Humanoid\nArmadura: 7\nPuntos de Golpe: 11\nInteligencia: 11\nDestreza: 10\nBonif. Iniciativa: 8\nFuerza: 7\nConstitucion: 3\nCarisma: 3";

                        }
                        if(personajeSelected==4) {
                            displayImage(dryad);
                            personajeAux="Nombre: Dryad\nClase: Fey\nArmadura: 9\nPuntos de Golpe: 5\nInteligencia: 5\nDestreza: 6\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 5\nCarisma: 4";

                        }
                        if(personajeSelected==5){
                            displayImage(dwarvenNoble);
                            personajeAux="Nombre: Dwarven Noble\nClase: Fey\nArmadura: 5\nPuntos de Golpe: 7\nInteligencia: 10\nDestreza: 10\nBonif. Iniciativa: 12\nFuerza: 6\nConstitucion: 7\nCarisma: 10";

                        }
                        if(personajeSelected==6){
                            displayImage(erinyesSummoned);
                            personajeAux="Nombre: Erinyes Summoned\nClase: Celestial\nArmadura: 10\nPuntos de Golpe: 8\nInteligencia: 8\nDestreza: 9\nBonif. Iniciativa: 11\nFuerza: 9\nConstitucion: 7\nCarisma: 9";

                        }
                        if(personajeSelected==7){
                            displayImage(gibberingMouther);
                            personajeAux="Nombre: Gibbering Mouther\nClase: Aberration\nArmadura: 14\nPuntos de Golpe: 12\nInteligencia: 9\nDestreza: 6\nBonif. Iniciativa: 6\nFuerza: 10\nConstitucion: 5\nCarisma: 1";

                        }
                        if(personajeSelected==8){
                            displayImage(gladiator);
                            personajeAux="Nombre: Gladiator\nClase: Fiend\nArmadura: 12\nPuntos de Golpe: 9\nInteligencia: 8\nDestreza: 6\nBonif. Iniciativa: 11\nFuerza: 8\nConstitucion: 4\nCarisma: 10";

                        }
                        if(personajeSelected==9){
                            displayImage(guardVillage);
                            personajeAux="Nombre: Guard Village\nClase: Fiend\nArmadura: 8\nPuntos de Golpe: 8\nInteligencia: 9\nDestreza: 9\nBonif. Iniciativa: 7\nFuerza: 8\nConstitucion: 5\nCarisma: 5";

                        }
                        if(personajeSelected==10){
                            displayImage(hillGiant);
                            personajeAux="Nombre: Hill Giant\nClase: Giant\nArmadura: 13\nPuntos de Golpe: 12\nInteligencia: 2\nDestreza: 3\nBonif. Iniciativa: 6\nFuerza: 13\nConstitucion: 5\nCarisma: 1";

                        }
                        if(personajeSelected==11){
                            displayImage(intellectDevourer);
                            personajeAux="Nombre: Intellect Devourer\nClase: Aberration\nArmadura: 10\nPuntos de Golpe: 8\nInteligencia: 15\nDestreza: 15\nBonif. Iniciativa: 10\nFuerza: 9\nConstitucion: 6\nCarisma: 10";

                        }
                        if(personajeSelected==12){
                            displayImage(phaseSpider);
                            personajeAux="Nombre: Phase Spider\nClase: Oozes\nArmadura: 9\nPuntos de Golpe: 9\nInteligencia: 5\nDestreza: 5\nBonif. Iniciativa: 7\nFuerza: 8\nConstitucion: 8\nCarisma: 2";

                        }
                        if(personajeSelected==13){
                            displayImage(planetar);
                            personajeAux="Nombre: Planetar\nClase: Celestial\nArmadura: 14\nPuntos de Golpe: 12\nInteligencia: 12\nDestreza: 10\nBonif. Iniciativa: 9\nFuerza: 11\nConstitucion: 9\nCarisma: 7";

                        }
                        if(personajeSelected==14){
                            displayImage(spy);
                            personajeAux="Nombre: Spy\nClase: Fiend\nArmadura: 6\nPuntos de Golpe: 7\nInteligencia: 13\nDestreza: 12\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 7\nCarisma: 10";

                        }
                        if(personajeSelected==15){
                            displayImage(youngRedDragon);
                            personajeAux="Nombre: Young Red Dragon\nClase: Dragon\nArmadura: 10\nPuntos de Golpe: 14\nInteligencia: 7\nDestreza: 6\nBonif. Iniciativa: 8\nFuerza: 10\nConstitucion: 6\nCarisma: 9";

                        }
                        detallesPersonaje.setText(personajeAux);

                    }
                });


            }
        }, 00,100);


    }

    void initData(VBox customer) {
        tabla= customer;
    }

    public void displayImage(Image i){
        imageView.setImage(i);
    }



    public void queImagen(){
        int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();

        if(personajeSelected>=0){
            if(personajeSelected==0){
                auxima= animatedBroom;
                detallesPersonaje.setText("Nombre: Animated Broom\nClase: Construct\nArmadura: 9\nPuntos de Golpe: 5\nInteligencia: 5\nDestreza: 6\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 5\nCarisma: 4");
            }
            if(personajeSelected==1){
                auxima= awakenedTree;

            }
            if(personajeSelected==2){
                auxima= danielMoreno;
            }
            if(personajeSelected==3){

                auxima= drowArachnomancer;
            }
            if(personajeSelected==4) {
                auxima= dryad;
            }
            if(personajeSelected==5){
                auxima= dwarvenNoble;
            }
            if(personajeSelected==6){
                auxima= erinyesSummoned;
            }
            if(personajeSelected==7){
                auxima= gibberingMouther;
            }
            if(personajeSelected==8){
                auxima= gladiator;
            }
            if(personajeSelected==9){
                auxima= guardVillage;
            }
            if(personajeSelected==10){
                auxima= hillGiant;
            }
            if(personajeSelected==11){
                auxima= intellectDevourer;
            }
            if(personajeSelected==12){
                auxima= phaseSpider;
            }
            if(personajeSelected==13){
                auxima= planetar;
            }
            if(personajeSelected==14){
                auxima= spy;
            }
            if(personajeSelected==15){
                auxima= youngRedDragon;
            }
        }
    }
}
