import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logico.Combatiente.Combatiente;
import logico.Combatiente.Creadora;
import logico.Combatiente.CreadoraReal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ControladorFormulario {
    String[] personajes = {"Animated Broom","Awakened Tree" ,"Daniel Moreno",
            "Drow Arachnomancer","Dryad","Dwarven Noble","Erinyes-Summoned",
            "Gibbering Mouther","Gladiator","Guard-Village","Hill Giant","Intellect Devourer","Phase Spider"
            ,"Planetar","Spy","Young Red Dragon"};
    Random rnd = new Random();

    VBox tabla;
    @FXML
    ImageView listo,ima;
    @FXML
    TextField nombre,nombreJugador,armadura,BIniciativa,PGolpe,Fuerza,Inteligencia,constitucion,destreza,carisma;
    @FXML
    ChoiceBox clase,tipoimagen;

    Image auxima;

    public void initialize(){
        tipoimagen.getItems().addAll(personajes);
        tipoimagen.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
                auxima = new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\"+tipoimagen.getItems().get((Integer) newValue)+".png"));
                ima.setImage(auxima);

            }
        });
        listo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(ComprobarDatos()){/*
                    ArrayList<String> s = new ArrayList<>();
                    s.add("Guard-Village");
                    s.add("Spy");
                    s.add("Gladiator");
                    s.add("Drow Arachnomancer");
                    HBox b=new HBox();
                    b.getStyleClass().add("hbox");
                    Random r = new Random();
                    int i = r.nextInt(s.size());
                    System.out.println(i+" "+s.get(i));
                    ImageView ima = new ImageView(new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\"+s.get(i)+".png")));
                    ima.setFitHeight(130);
                    ima.setFitWidth(120);
                    Button bu =new Button();
                    bu.setMinHeight(130);
                    bu.setMinWidth(120);
                    bu.setText("tetetete");
                    b.getChildren().add(ima);
                    b.getChildren().add(bu);*/
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "Estadisticas.fxml"
                            )
                    );

                    BorderPane b ;
                    try {
                        b = (BorderPane)loader.load();
                        Estadisticas controller = loader.<Estadisticas>getController();
                        controller.imaper.setImage(auxima);
                        controller.nombre.setText("Nombre Personaje: "+nombre.getText());
                        controller.jugador.setText("Nombre Jugador: "+nombreJugador.getText());
                        controller.pts.setText("PG:"+PGolpe.getText());
                        tabla.getChildren().add(b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // aca se crean el combatiente
                    int ar = Integer.parseInt(armadura.getText()),pg =Integer.parseInt(PGolpe.getText())
                            ,bi=Integer.parseInt(BIniciativa.getText()) ,fue=Integer.parseInt(Fuerza.getText())
                            ,in=Integer.parseInt(Inteligencia.getText()),des=Integer.parseInt(destreza.getText())
                            ,con=Integer.parseInt(constitucion.getText()),car=Integer.parseInt(carisma.getText());
                    // crear ID random
                    int id = (char) (rnd.nextInt(94)+33); // actualizar método de obtener una ID;
                    Creadora c = new CreadoraReal();
                    Combatiente nuevo = c.CrearCombatiente(nombre.getText(),nombreJugador.getText(),clase.getAccessibleText(),tipoimagen.getAccessibleText(),bi,pg,ar,fue,in,des,con,car, sab,id);

                }
            }
        });
    }
    void initData(VBox customer) {
        tabla= customer;
    }


    public void CambiarIma(){
        System.out.println("cambio");
    }
    public boolean ComprobarDatos( ){

        try{
            System.out.println(Integer.parseInt(armadura.getText()));
            System.out.println(Integer.parseInt(PGolpe.getText()));
            System.out.println(Integer.parseInt(BIniciativa.getText()));
            System.out.println(Integer.parseInt(Fuerza.getText()));
            System.out.println(Integer.parseInt(Inteligencia.getText()));
            System.out.println(Integer.parseInt(destreza.getText()));
            System.out.println(Integer.parseInt(constitucion.getText()));
            System.out.println(Integer.parseInt(carisma.getText()));

            System.out.println(nombre.getText());
            System.out.println(tipoimagen.getValue());
            if(nombre.getText().equals("") || (nombreJugador.getText().equals(""))|| (tipoimagen.getValue() == null)){
                return false;
            }
            System.out.println(clase.getItems());

            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
