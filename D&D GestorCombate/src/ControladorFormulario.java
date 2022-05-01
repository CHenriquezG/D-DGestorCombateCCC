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
import javafx.scene.layout.VBox;
import logico.Combatiente.Combatiente;
import logico.Combatiente.Creadora;
import logico.Combatiente.CreadoraReal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ControladorFormulario {
    VBox tabla;
    @FXML
    ImageView listo;
    @FXML
    TextField nombre,nombreJugador,armadura,BIniciativa,PGolpe,Fuerza,Inteligencia,constitucion,destreza,carisma;
    @FXML
    ChoiceBox clase;
    public void initialize(){
        listo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(ComprobarDatos()){
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
                    b.getChildren().add(bu);
                    tabla.getChildren().add(b);
                    // aca se crean el combatiente
                    int ar = Integer.parseInt(armadura.getText()),pg =Integer.parseInt(PGolpe.getText())
                            ,bi=Integer.parseInt(BIniciativa.getText()) ,fue=Integer.parseInt(Fuerza.getText())
                            ,in=Integer.parseInt(Inteligencia.getText()),des=Integer.parseInt(destreza.getText())
                            ,con=Integer.parseInt(constitucion.getText()),car=Integer.parseInt(carisma.getText());
                    Creadora c = new CreadoraReal();
                    Combatiente nuevo = c.CrearCombatiente(nombre.getText(),nombreJugador.getText(),clase.getAccessibleText(),bi,pg,ar,fue,in,des,con,car);

                }





            }
        });
    }
    void initData(VBox customer) {
        tabla= customer;
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
            if(nombre.getText().equals("") || (nombreJugador.getText().equals(""))){
                return false;
            }
            System.out.println(clase.getItems());

            return true;
        }catch (NumberFormatException e){
            return false;
        }




    }

}
