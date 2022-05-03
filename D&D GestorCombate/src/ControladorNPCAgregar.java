import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class ControladorNPCAgregar  implements Initializable {

    @FXML
    public ListView listaNPC;
    @FXML
    ImageView imageView;

    ControladorListaPersonajes controlador;
    @FXML
    Label myLabel;
    @FXML
    ImageView imaSiguente;


    String[] personajes = {"Animated Broom","Awakened Tree" ,"Daniel Moreno",
            "Drow Arachnomancer","Dryad","Dwarven Noble","Erinyes-Summoned",
            "Gibbering Mouther","Gladiator","Guard-Village","Hill Giant","Intellect Devourer","Phase Spider"
            ,"Planetar","Spy","Young Red Dragon"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaNPC.getItems().addAll(personajes);
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

        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();
                if(personajeSelected>=0){
                    if(personajeSelected==0){
                        displayImage(animatedBroom);
                    }
                    if(personajeSelected==1){
                        displayImage(awakenedTree);
                    }
                    if(personajeSelected==2){
                        displayImage(danielMoreno);
                    }
                    if(personajeSelected==3){
                        displayImage(drowArachnomancer);
                    }
                    if(personajeSelected==4) {
                        displayImage(dryad);
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



    public void displayImage(Image i){
        imageView.setImage(i);
    }
}
