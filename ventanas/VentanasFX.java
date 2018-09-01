package ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class VentanasFX {

    //Patron Singleton
    private static VentanasFX ourInstance = null;
    private static Stage stage = null;

    private static Ventana ventanaActual = null;

    public static VentanasFX start(Stage stage) {
        if (ourInstance == null) {
            ourInstance = new VentanasFX(stage);
        }
        return ourInstance;
    }

    private VentanasFX(Stage stageAsignado) {
        ventanas = new HashMap<>();
        stage = stageAsignado;
    }

    //Atributos de la clase VentanasFX
    private static HashMap<String, Ventana> ventanas;


    //Metodos estaticos para acceder a multiples objetos
    public static boolean add(String id,String rute) throws IOException
    {
        return add(id, rute,null,null,null);
    }

    public static boolean add(String id, String rute, String title) throws IOException
    {
        return add(id, rute, title, null, null);
    }

    public static boolean add(String id, String rute, String title, Double width) throws  IOException
    {
        return add(id, rute, title, width, null);
    }

    public static boolean add(String id, String rute, String title, Double width,Double height) throws IOException
    {
        if(validacionDatos(id,rute))
        {
            FXMLLoader loader = new FXMLLoader(VentanasFX.class.getResource(rute));
            Parent root = loader.load(); //Excepcion

            Object controlador = loader.getController();
            Scene scene = new Scene(root);

            //Id,ruta,scenario,controlador
            Ventana nuevaVentana = new Ventana(id,rute,scene,controlador);

            //Parametros opcionales
            nuevaVentana.setTituloVentana(title);
            nuevaVentana.setAnchoVentana(width);
            nuevaVentana.setAltoVentana(height);

            if(id.equals(nuevaVentana.getId())) //Verificacion extra
            {
                ventanas.put(id,nuevaVentana);
                return true;
            }
        }
        return false;
    }

    public static boolean goTo(String id)
    {
        Ventana ventanaObtenida = ventanas.get(id);
        if(ventanaObtenida!=null)
        {

            stage.setTitle(ventanaObtenida.getTituloVentana()!=null ? ventanaObtenida.getTituloVentana(): "Sin titulo" );
            stage.setWidth(ventanaObtenida.getAnchoVentana()!=null ? ventanaObtenida.getAnchoVentana() : 800);
            stage.setHeight(ventanaObtenida.getAltoVentana()!=null ? ventanaObtenida.getAltoVentana() : 600);

            ventanaActual=ventanaObtenida;
            stage.setScene(ventanaActual.getScene());
            stage.show();
            //API DE ANIMACION JUSTO DESPUES DE MOSTRAR

            return true;
        }
        return false;
    }

    public static Object getController(String id)
    {
        Ventana ventanaObtenida = ventanas.get(id);
        if(ventanaObtenida!=null)
        {
            Object controlador = ventanaObtenida.getControlador();
            return controlador;
        }
        return null;
    }

    private static boolean validacionDatos(String id, String rute)
    {
        if(ventanas.get(id)==null) //Validar id
        {
            if(rute.contains(".fxml")) //Validar ruta
            {
                if(VentanasFX.class.getResource(rute)!=null) //Existencia del fichero
                {
                    return true;
                }
            }
        }
        return false;
    }
}
