import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logico.Combatiente.CombatienteInstancia;
import logico.InstanciaCombate.combate;
import logico.Lista.IteradorCombatiente;

public class MiniEstadistica {
    combate c;
    IteradorCombatiente tuLog;
    public VBox tabla,cen,tu;
    @FXML
    Button x;

    @FXML
    ImageView ima;
    @FXML
    Label nombre;

    public void initData(VBox tabla, VBox tu, IteradorCombatiente tuLog, combate c){
        this.c = c;
        this.tabla = tabla;
        this.tu = tu;
        this.tuLog = tuLog;
        System.out.println(tuLog.getCombatiente().getImagen());
        ima.setImage(new Image(getClass().getResourceAsStream(tuLog.getCombatiente().getImagen())));
        nombre.setText(tuLog.getCombatiente().getNombre());


    }

    public void Eliminar(){

        c.getReaccionarios().remove(tuLog);
        tabla.getChildren().remove(tu);
    }






}
