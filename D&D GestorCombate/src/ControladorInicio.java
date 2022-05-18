import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import logico.InstanciaCombate.combate;
import logico.Datos.estructuraDeDatos;

public class ControladorInicio {
    @FXML
    AnchorPane rig,lef;
    @FXML
    HBox bot,botlef,botrig,toprig,toplef,up;
    @FXML
    BorderPane back;
    @FXML
    VBox tabla,cen;
    @FXML
    ScrollPane tablapane;

    @FXML
    ImageView ima, imaSalir;

    Stage scene;

    public void initialize(){
        estructuraDeDatos e = new estructuraDeDatos();
        System.out.println("-------------------------");
      //  e.insertarDatos("Combate chiquito 4", "2022-05-12");
      //  System.out.println("-------------------------");
      //  e.extraerInformacion();
        ima.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "ControladorListaPersonajes.fxml"
                        )
                );

                BorderPane b = null;
                try {
                    b = (BorderPane)loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControladorListaPersonajes controller = loader.<ControladorListaPersonajes>getController();

                back.setCenter(controller.back.getCenter());
                controller.initData(back,scene);



            }
        });

        imaSalir.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);

            }
        });

    }
    void initData(Stage customer) {
        scene = customer;
    }

    public void crear(){
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
        ImageView ima = new ImageView(new Image(getClass().getResourceAsStream(s.get(i)+".png")));
        ima.setFitHeight(130);
        ima.setFitWidth(120);
        Button bu =new Button();
        bu.setMinHeight(130);
        bu.setMinWidth(120);
        bu.setText("tetetete");
        b.getChildren().add(ima);
        b.getChildren().add(bu);
        tabla.getChildren().add(b);



    }
}
