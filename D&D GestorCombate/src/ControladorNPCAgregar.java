import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import logico.Configuracion.configuracion;

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
    configuracion conf;

    ControladorListaPersonajes controlador;
    @FXML
    Label myLabel;
    @FXML
    ImageView imaSiguente;

    Combatiente auxCombatiente;

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
                    controller.nombre.setText(auxCombatiente.getNombre());
                    controller.jugador.setText("Nombre Jugador: "+auxCombatiente.getNombreJugador());
                    controller.pts.setText("PG:"+auxCombatiente.getPG());
                    conf.setCombatiente(auxCombatiente.getNombre(),auxCombatiente.getNombreJugador(),auxCombatiente.getImagen(),auxCombatiente.getClase(),auxCombatiente.getBini(),auxCombatiente.getPG(),auxCombatiente.getArm(),auxCombatiente.getFue(),auxCombatiente.getInte(),auxCombatiente.getDes(),auxCombatiente.getCons(),auxCombatiente.getCar(), auxCombatiente.getSab(),auxCombatiente.getId());
                    conf.combatientes.get(conf.combatientes.size()-1).setGrafico(b);
                    controller.initData(0,conf);
                    tabla.getChildren().add(b);
                    controller.imaper.setImage(auxima);
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
                            personajeAux="Animated Broom\nClase: Construct\nArmadura: 4\nPuntos de Golpe: 4\nInteligencia: 5\nDestreza: 5\nBonif. Iniciativa: 4\nFuerza: 2\nConstitucion: 5\nCarisma: 2";
                        }
                        if(personajeSelected==1){
                            displayImage(awakenedTree);
                            personajeAux="Awakened Tree\nClase: Plant\nArmadura: 3\nPuntos de Golpe: 2\nInteligencia: 5\nDestreza: 6\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 5\nCarisma: 4";

                        }
                        if(personajeSelected==2){
                            displayImage(danielMoreno);
                            personajeAux="Daniel Moreno\nClase: Aberration\nArmadura: 10\nPuntos de Golpe: 12\nInteligencia: 8\nDestreza: 11\nBonif. Iniciativa: 10\nFuerza:9\nConstitucion: 6\nCarisma: 6";

                        }
                        if(personajeSelected==3){
                            displayImage(drowArachnomancer);
                            personajeAux="Drow Arachnomancer\nClase: Humanoid\nArmadura: 7\nPuntos de Golpe: 11\nInteligencia: 11\nDestreza: 10\nBonif. Iniciativa: 8\nFuerza: 7\nConstitucion: 3\nCarisma: 3";

                        }
                        if(personajeSelected==4) {
                            displayImage(dryad);
                            personajeAux="Dryad\nClase: Fey\nArmadura: 9\nPuntos de Golpe: 5\nInteligencia: 5\nDestreza: 6\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 5\nCarisma: 4";

                        }
                        if(personajeSelected==5){
                            displayImage(dwarvenNoble);
                            personajeAux="Dwarven Noble\nClase: Fey\nArmadura: 5\nPuntos de Golpe: 7\nInteligencia: 10\nDestreza: 10\nBonif. Iniciativa: 12\nFuerza: 6\nConstitucion: 7\nCarisma: 10";

                        }
                        if(personajeSelected==6){
                            displayImage(erinyesSummoned);
                            personajeAux="Erinyes Summoned\nClase: Celestial\nArmadura: 10\nPuntos de Golpe: 8\nInteligencia: 8\nDestreza: 9\nBonif. Iniciativa: 11\nFuerza: 9\nConstitucion: 7\nCarisma: 9";

                        }
                        if(personajeSelected==7){
                            displayImage(gibberingMouther);
                            personajeAux="Gibbering Mouther\nClase: Aberration\nArmadura: 14\nPuntos de Golpe: 12\nInteligencia: 9\nDestreza: 6\nBonif. Iniciativa: 6\nFuerza: 10\nConstitucion: 5\nCarisma: 1";

                        }
                        if(personajeSelected==8){
                            displayImage(gladiator);
                            personajeAux="Gladiator\nClase: Fiend\nArmadura: 12\nPuntos de Golpe: 9\nInteligencia: 8\nDestreza: 6\nBonif. Iniciativa: 11\nFuerza: 8\nConstitucion: 4\nCarisma: 10";

                        }
                        if(personajeSelected==9){
                            displayImage(guardVillage);
                            personajeAux="Guard Village\nClase: Fiend\nArmadura: 8\nPuntos de Golpe: 8\nInteligencia: 9\nDestreza: 9\nBonif. Iniciativa: 7\nFuerza: 8\nConstitucion: 5\nCarisma: 5";

                        }
                        if(personajeSelected==10){
                            displayImage(hillGiant);
                            personajeAux="Hill Giant\nClase: Giant\nArmadura: 13\nPuntos de Golpe: 12\nInteligencia: 2\nDestreza: 3\nBonif. Iniciativa: 6\nFuerza: 13\nConstitucion: 5\nCarisma: 1";

                        }
                        if(personajeSelected==11){
                            displayImage(intellectDevourer);
                            personajeAux="Intellect Devourer\nClase: Aberration\nArmadura: 10\nPuntos de Golpe: 8\nInteligencia: 15\nDestreza: 15\nBonif. Iniciativa: 10\nFuerza: 9\nConstitucion: 6\nCarisma: 10";

                        }
                        if(personajeSelected==12){
                            displayImage(phaseSpider);
                            personajeAux="Phase Spider\nClase: Oozes\nArmadura: 9\nPuntos de Golpe: 9\nInteligencia: 5\nDestreza: 5\nBonif. Iniciativa: 7\nFuerza: 8\nConstitucion: 8\nCarisma: 2";

                        }
                        if(personajeSelected==13){
                            displayImage(planetar);
                            personajeAux="Planetar\nClase: Celestial\nArmadura: 14\nPuntos de Golpe: 12\nInteligencia: 12\nDestreza: 10\nBonif. Iniciativa: 9\nFuerza: 11\nConstitucion: 9\nCarisma: 7";

                        }
                        if(personajeSelected==14){
                            displayImage(spy);
                            personajeAux="Spy\nClase: Fiend\nArmadura: 6\nPuntos de Golpe: 7\nInteligencia: 13\nDestreza: 12\nBonif. Iniciativa: 7\nFuerza: 7\nConstitucion: 7\nCarisma: 10";

                        }
                        if(personajeSelected==15){
                            displayImage(youngRedDragon);
                            personajeAux="Young Red Dragon\nClase: Dragon\nArmadura: 10\nPuntos de Golpe: 14\nInteligencia: 7\nDestreza: 6\nBonif. Iniciativa: 8\nFuerza: 10\nConstitucion: 6\nCarisma: 9";

                        }
                        detallesPersonaje.setText(personajeAux);

                    }
                });


            }
        }, 00,100);


    }

    void initData(VBox customer,configuracion conf) {
        tabla= customer;
        this.conf = conf;
    }

    public void displayImage(Image i){
        imageView.setImage(i);
    }



    public void queImagen(){
        int personajeSelected = listaNPC.getSelectionModel().getSelectedIndex();
        if(personajeSelected>=0){
            if(personajeSelected==0){
                auxima= animatedBroom;
                auxCombatiente= new Combatiente("Animated Broom","","Construct","\\Recursos\\Foto de personajes\\Animated Broom.png",7,5,9,7,5,6,5,8,4,100001);
            }
            if(personajeSelected==1){
                auxima= awakenedTree;
                auxCombatiente= new Combatiente("Awakened Tree","","Plant","\\Recursos\\Foto de personajes\\Awakened Tree.png",7,2,3,7,5,6,5,4,3,100002);

            }
            if(personajeSelected==2){
                auxima= danielMoreno;
                auxCombatiente= new Combatiente("Daniel Moreno","","Aberration","\\Recursos\\Foto de personajes\\Daniel Moreno.png",10,12,10,9,8,11,6,6,10,100003);
            }
            if(personajeSelected==3){

                auxima= drowArachnomancer;
                auxCombatiente= new Combatiente("Drow Arachnomancer","","Humanoid","\\Recursos\\Foto de personajes\\Drow Arachnomancer.png",8,11,7,7,11,10,3,3,7,100004);
            }
            if(personajeSelected==4) {
                auxima= dryad;
                auxCombatiente= new Combatiente("Dryad","","Fey","\\Recursos\\Foto de personajes\\Dryad.png",7,5,9,7,5,6,5,4,8,100005);
            }
            if(personajeSelected==5){
                auxima= dwarvenNoble;
                auxCombatiente= new Combatiente("Dwarven Noble","","Fey","\\Recursos\\Foto de personajes\\Dwarven Noble.png",12,7,5,6,10,10,7,4,9,100006);
            }
            if(personajeSelected==6){
                auxima= erinyesSummoned;
                auxCombatiente= new Combatiente("Erinyes Summoned","","Celestial","\\Recursos\\Foto de personajes\\Erinyes-Summoned.png",11,8,10,9,8,9,7,10,7,100007);
            }
            if(personajeSelected==7){
                auxima= gibberingMouther;
                auxCombatiente= new Combatiente("Gibbering Mouther","","Aberration","\\Recursos\\Foto de personajes\\Gibbering Mouther.png",6,12,14,10,9,6,5,1,6,100008);
            }
            if(personajeSelected==8){
                auxima= gladiator;
                auxCombatiente= new Combatiente("Gladiator","","Fiend","\\Recursos\\Foto de personajes\\Gladiator.png",11,9,12,8,8,6,4,10,7,100009);
            }
            if(personajeSelected==9){
                auxima= guardVillage;
                auxCombatiente= new Combatiente("Guard Village","","Fiend","\\Recursos\\Foto de personajes\\Guard-Village.png",7,8,8,8,9,9,5,5,5,100010);
            }
            if(personajeSelected==10){
                auxima= hillGiant;
                auxCombatiente= new Combatiente("Hill Giant","","Giant","\\Recursos\\Foto de personajes\\Hill Giant.png",6,12,13,13,2,3,5,1,4,100011);
            }
            if(personajeSelected==11){
                auxima= intellectDevourer;
                auxCombatiente= new Combatiente("Intellect Devourer","","Aberration","\\Recursos\\Foto de personajes\\Intellect Devourer.png",10,8,10,9,15,15,6,10,15,100012);
            }
            if(personajeSelected==12){
                auxima= phaseSpider;
                auxCombatiente= new Combatiente("Phase Spider","","Oozes","\\Recursos\\Foto de personajes\\Phase Spider.png",7,9,9,8,5,5,8,2,4,100013);
            }
            if(personajeSelected==13){
                auxima= planetar;
                auxCombatiente= new Combatiente("Planetar","","Celestial","\\Recursos\\Foto de personajes\\Planetar.png",9,12,14,11,12,10,9,7,13,100014);
            }
            if(personajeSelected==14){
                auxima= spy;
                auxCombatiente= new Combatiente("Spy","","Fiend","\\Recursos\\Foto de personajes\\Spy.png",12,7,6,7,13,12,7,10,13,100015);
            }
            if(personajeSelected==15){
                auxima= youngRedDragon;
                auxCombatiente= new Combatiente("Young Red Dragon","","Dragon","\\Recursos\\Foto de personajes\\Young Red Dragon.png",8,14,10,10,7,6,6,9,9,100016);
            }
        }
    }
}
