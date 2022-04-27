import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControladorJuego {
    @FXML
    VBox fcontent;
    @FXML
    ImageView paisaje;
    @FXML
    BorderPane back;
    public void initialize(){/**
        paisaje.fitWidthProperty().bind(fcontent.widthProperty());
        paisaje.fitHeightProperty().bind(fcontent.heightProperty());**/


    }
    void initData(BorderPane customer) {
        back = customer;
    }

}
