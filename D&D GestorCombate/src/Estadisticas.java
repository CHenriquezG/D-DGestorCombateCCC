import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logico.Combatiente.CombatienteReal;
import logico.Configuracion.configuracion;

public class Estadisticas {
    @FXML
    ImageView imaper;
    @FXML
    Label jugador,nombre,pts;
    @FXML
    BorderPane tablero;

    configuracion conf;
    int combR;
    public void initialize(){




    }
    void initData(int customer, configuracion conf) {
        combR= customer;
        this.conf = conf;
    }


    public void SeleccionarEstadistica(){

    }


}
