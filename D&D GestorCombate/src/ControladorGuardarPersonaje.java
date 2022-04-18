import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

public class ControladorGuardarPersonaje {
    @FXML
    AnchorPane rig,lef,cen;
    @FXML
    HBox bot,botlef,botrig,toprig,toplef,up;
    @FXML
    BorderPane back;
    @FXML
    VBox tabla;
    public void initialize(){


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
        ima.setFitHeight(128);
        ima.setFitWidth(128);
        Button bu =new Button();
        bu.setMinHeight(128);
        bu.setMinWidth(128);
        bu.setText("tetetete");
        b.getChildren().add(ima);
        b.getChildren().add(bu);
        tabla.getChildren().add(b);


    }
}
