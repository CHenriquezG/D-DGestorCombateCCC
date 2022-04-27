import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class ControladorGuardarPersonaje {
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
    ImageView imaAgregarNPC, imaSiguente, imaAgregarCombatiente;

    public void initialize(){

        imaAgregarNPC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("agregar npc");
                //a.crear();
            }
        });

    }

    public void AñadirCombatiente() throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("NuevoEvento.fxml"));
        //NuevoEvento eve = new NuevoEvento();
        Stage Ventana = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("VentanaFormulario.fxml"));
        Ventana.setScene(new Scene(root));
        //eve.MostrarMapamundi();

        Ventana.show();
    }

    public void CambiarVent(ActionEvent event) throws IOException {
        BorderPane b = FXMLLoader.load(getClass().getResource("ControladorInicio.fxml"));

        back.setCenter(b.getCenter());
        //back.setCenter(root);


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
