import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logico.Configuracion.iniciativa;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ControladorInicio.fxml"
                )
        );

        BorderPane b = null;
        try {
            b = (BorderPane)loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControladorInicio controller = loader.<ControladorInicio>getController();


        controller.initData(primaryStage);
        Scene s = new Scene(b);
        s.getStylesheets().add(getClass().getResource("aplicacion.css").toExternalForm());
        primaryStage.setScene(s);
        primaryStage.getIcons().add(new Image("/iconoDYD.png"));
        primaryStage.setTitle("DYD SIMULATOR");

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
