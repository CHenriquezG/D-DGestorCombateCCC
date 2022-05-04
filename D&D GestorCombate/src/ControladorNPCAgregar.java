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

    Image animatedBroomData = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\animatedBroomData.png"));
    Image awakenedTreeData = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\awakenedTreeData.png"));
    Image danielMorenoData = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\danielMorenoData.png"));
    Image drowArachnomancerData = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\drowArachnomancerData.png"));
    Image dryadData = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\dryadData.png"));


    String[] personajes = {"Animated Broom","Awakened Tree" ,"Daniel Moreno",
            "Drow Arachnomancer","Dryad","Dwarven Noble","Erinyes-Summoned",
            "Gibbering Mouther","Gladiator","Guard-Village","Hill Giant","Intellect Devourer","Phase Spider"
            ,"Planetar","Spy","Young Red Dragon"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
                int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();
                if(personajeSelected>=0){
                    if(personajeSelected==0){
                        displayImage(animatedBroom);
                        displayImage2(animatedBroomData);
                    }
                    if(personajeSelected==1){
                        displayImage(awakenedTree);
                        displayImage2(awakenedTreeData);
                    }
                    if(personajeSelected==2){
                        displayImage(danielMoreno);
                        displayImage2(danielMorenoData);
                    }
                    if(personajeSelected==3){
                        displayImage(drowArachnomancer);
                        displayImage2(drowArachnomancerData);
                    }
                    if(personajeSelected==4) {
                        displayImage(dryad);
                        displayImage2(dryadData);
                    }
                    if(personajeSelected==5){
                        displayImage(dwarvenNoble);
                    }
                    if(personajeSelected==6){
                        displayImage(erinyesSummoned);
                    }
                    if(personajeSelected==7){
                        displayImage(gibberingMouther);
                    }
                    if(personajeSelected==8){
                        displayImage(gladiator);
                    }
                    if(personajeSelected==9){
                        displayImage(guardVillage);
                    }
                    if(personajeSelected==10){
                        displayImage(hillGiant);
                    }
                    if(personajeSelected==11){
                        displayImage(intellectDevourer);
                    }
                    if(personajeSelected==12){
                        displayImage(phaseSpider);
                    }
                    if(personajeSelected==13){
                        displayImage(planetar);
                    }
                    if(personajeSelected==14){
                        displayImage(spy);
                    }
                    if(personajeSelected==15){
                        displayImage(youngRedDragon);
                    }
                }

            }
        }, 0,100);


    }

    void initData(VBox customer) {
        tabla= customer;
    }

    public void displayImage(Image i){
        imageView.setImage(i);
    }

    public void displayImage2(Image i){
        imageView2.setImage(i);
    }

    public void queImagen(){
        int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();
        if(personajeSelected>=0){
            if(personajeSelected==0){
                auxima= animatedBroom;
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
