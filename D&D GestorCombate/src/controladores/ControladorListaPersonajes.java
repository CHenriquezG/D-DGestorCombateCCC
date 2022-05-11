package controladores;

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
import javafx.scene.layout.*;
import javafx.stage.Stage;
import logico.Configuracion.configuracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ControladorListaPersonajes {
    @FXML
    AnchorPane rig,lef;
    @FXML
    HBox bot,botlef,botrig,toprig,toplef,up;
    @FXML
    BorderPane back;
    @FXML
    VBox cen;
    @FXML
    VBox tabla;
    @FXML
    ScrollPane tablapane;

    configuracion conf;

    @FXML
    ImageView imaAgregarNPC, imaSiguente, imaAgregarCombatiente;

    Stage scene;
    configuracion bhconf;
    public void initialize(){
        conf = new configuracion();
        imaSiguente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "ControladorJuego.fxml"
                        )
                );

                BorderPane b = null;
                try {
                    b = (BorderPane)loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControladorJuego controller = loader.<ControladorJuego>getController();

                back.setCenter(controller.back.getCenter());
                controller.initData(back,tabla,scene);



            }
        });


        imaAgregarCombatiente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Parent root = FXMLLoader.load(getClass().getResource("NuevoEvento.fxml"));
                //NuevoEvento eve = new NuevoEvento();
                Stage Ventana = new Stage();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "VentanaFormulario.fxml"
                        )
                );

                BorderPane b = null;
                try {
                    b = (BorderPane)loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControladorFormulario controller = loader.<ControladorFormulario>getController();
                controller.initData(tabla,conf);
                Ventana.setScene(new Scene(b));

                Ventana.show();
            }
        });

        imaAgregarNPC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Parent root = FXMLLoader.load(getClass().getResource("NuevoEvento.fxml"));
                //NuevoEvento eve = new NuevoEvento();
                Stage Ventana = new Stage();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "VentanaAgregarCombatienteGen.fxml"
                        )
                );

                BorderPane b = null;
                try {
                    b = (BorderPane)loader.load();
                    Parent root = new Pane();
                    ControladorNPCAgregar controller = loader.<ControladorNPCAgregar>getController();

                    //Estadisticas controller = loader.<Estadisticas>getController();

                    controller.initData(tabla,conf);
                    Ventana.setScene(new Scene(b));
                    Ventana.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void initData(BorderPane customer,Stage scene) {
        back = customer;this.scene = scene;
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


    public AnchorPane getRig() {
        return rig;
    }

    public void setRig(AnchorPane rig) {
        this.rig = rig;
    }

    public AnchorPane getLef() {
        return lef;
    }

    public void setLef(AnchorPane lef) {
        this.lef = lef;
    }

    public HBox getBot() {
        return bot;
    }

    public void setBot(HBox bot) {
        this.bot = bot;
    }

    public HBox getBotlef() {
        return botlef;
    }

    public void setBotlef(HBox botlef) {
        this.botlef = botlef;
    }

    public HBox getBotrig() {
        return botrig;
    }

    public void setBotrig(HBox botrig) {
        this.botrig = botrig;
    }

    public HBox getToprig() {
        return toprig;
    }

    public void setToprig(HBox toprig) {
        this.toprig = toprig;
    }

    public HBox getToplef() {
        return toplef;
    }

    public void setToplef(HBox toplef) {
        this.toplef = toplef;
    }

    public HBox getUp() {
        return up;
    }

    public void setUp(HBox up) {
        this.up = up;
    }

    public BorderPane getBack() {
        return back;
    }

    public void setBack(BorderPane back) {
        this.back = back;
    }

    public VBox getCen() {
        return cen;
    }

    public void setCen(VBox cen) {
        this.cen = cen;
    }

    public VBox getTabla() {
        return tabla;
    }

    public void setTabla(VBox tabla) {
        this.tabla = tabla;
    }

    public ScrollPane getTablapane() {
        return tablapane;
    }

    public void setTablapane(ScrollPane tablapane) {
        this.tablapane = tablapane;
    }

    public configuracion getConf() {
        return conf;
    }

    public void setConf(configuracion conf) {
        this.conf = conf;
    }

    public ImageView getImaAgregarNPC() {
        return imaAgregarNPC;
    }

    public void setImaAgregarNPC(ImageView imaAgregarNPC) {
        this.imaAgregarNPC = imaAgregarNPC;
    }

    public ImageView getImaSiguente() {
        return imaSiguente;
    }

    public void setImaSiguente(ImageView imaSiguente) {
        this.imaSiguente = imaSiguente;
    }

    public ImageView getImaAgregarCombatiente() {
        return imaAgregarCombatiente;
    }

    public void setImaAgregarCombatiente(ImageView imaAgregarCombatiente) {
        this.imaAgregarCombatiente = imaAgregarCombatiente;
    }

    public Stage getScene() {
        return scene;
    }

    public void setScene(Stage scene) {
        this.scene = scene;
    }

    public configuracion getBhconf() {
        return bhconf;
    }

    public void setBhconf(configuracion bhconf) {
        this.bhconf = bhconf;
    }
}
