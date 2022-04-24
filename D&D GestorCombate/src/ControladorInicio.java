import javafx.event.ActionEvent;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
    ImageView ima;


    public void initialize(){
        ima.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BorderPane b = null;
                try {
                    b = FXMLLoader.load(getClass().getResource("ControladorListaPersonajes.fxml"));
                    back.setCenter(b.getCenter());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void CambiarVentana(ActionEvent event) throws IOException {
        BorderPane b = FXMLLoader.load(getClass().getResource("ControladorListaPersonajes.fxml"));
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
