import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logico.Combatiente.CombatienteInstancia;

public class MiniEstadistica {

    CombatienteInstancia tuLog;
    public VBox tabla,cen,tu;
    @FXML
    Button x;

    @FXML
    ImageView ima;
    @FXML
    Label nombre;

    public void initData(VBox tabla, VBox tu, CombatienteInstancia tuLog){
        this.tabla = tabla;
        this.tu = tu;
        this.tuLog = tuLog;
        System.out.println(tuLog.getImagen());
        ima.setImage(new Image(getClass().getResourceAsStream("\\Recursos\\Foto de personajes\\"+tuLog.getImagen()+".png")));
        nombre.setText(tuLog.getNombre());


    }

    public void Eliminar(){


        tabla.getChildren().remove(tu);
    }






}
