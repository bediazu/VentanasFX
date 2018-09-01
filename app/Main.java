package app;

import javafx.application.Application;
import javafx.stage.Stage;
import ventanas.VentanasFX;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        VentanasFX.start(primaryStage); //Framework start

        VentanasFX.add("Home", "/fxml/sample.fxml","mi Titulo 1");
        VentanasFX.add("Home2", "/fxml/sample2.fxml","mi Titulo 2");


        VentanasFX.goTo("Home");

        System.out.println("Aplicacion finalizada con exito!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
