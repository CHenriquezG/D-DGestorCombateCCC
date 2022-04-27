import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ControladorInicio.fxml"));
        Scene s = new Scene(root);
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
