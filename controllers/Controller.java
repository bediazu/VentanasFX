package controllers;

import javafx.fxml.FXML;
import ventanas.VentanasFX;

public class Controller {

    public void Saludar()
    {
        System.out.println("Acceso al controlador exitoso!");
    }

    @FXML
    public void nextScene()
    {
        VentanasFX.goTo("Home2");
    }


}
