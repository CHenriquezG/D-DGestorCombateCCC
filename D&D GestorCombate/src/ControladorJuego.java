import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorJuego {
    @FXML
    VBox tabla;
    @FXML
    ImageView paisaje;
    @FXML
    BorderPane back;
    public void initialize(){/**
        paisaje.fitWidthProperty().bind(fcontent.widthProperty());
        paisaje.fitHeightProperty().bind(fcontent.heightProperty());**/


    }
    void initData(BorderPane customer, VBox tabla, Stage primary) {
        primary.setMinWidth(back.getPrefWidth());
        primary.setMinHeight(back.getPrefHeight());
        back = customer;
        this.tabla.getChildren().setAll(tabla.getChildren());
    }

}
