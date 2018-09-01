package ventanas;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Ventana {

    private String id;
    private String rute;

    private String tituloVentana;
    private Double altoVentana;
    private Double anchoVentana;

    private Scene scene;
    private AnchorPane pane;
    private Object controlador;


    public Ventana(String id,String rute,Scene scene,Object controlador)
    {
        setRute(rute);
        setId(id);
        setScene(scene);
        setControlador(controlador);
    }

    //Metodos Getter and Setter

    //Publicos
    public String getId()
    {
        return id;
    }

    public String getTituloVentana(){ return tituloVentana;}
    public void setTituloVentana(String tituloVentana){ this.tituloVentana=tituloVentana;}

    public Double getAltoVentana(){return altoVentana;}
    public void setAltoVentana(Double altoVentana){this.altoVentana=altoVentana;}

    public Double getAnchoVentana(){return anchoVentana;}
    public void setAnchoVentana(Double anchoVentana){this.anchoVentana=anchoVentana;}

    public Scene getScene(){return scene;}

    public Object getControlador(){return controlador;}

    private void setControlador(Object controlador)
    {
        this.controlador=controlador;
    }

    private void setScene(Scene scene)
    {
        this.scene=scene;
    }

    private void setRute(String rute)
    {
        this.rute=rute;
    }

    private void setId(String id)
    {
        this.id=id;
    }

}
