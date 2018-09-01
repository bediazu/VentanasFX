# VentanasFX
Framework Router para JavaFX

## Requerimientos
Ninguno

## Router
Permite el manejo de varias ventanas de forma simple

~~~
VentanasFX.start(primaryStage);
VentanasFX.add("Home","/fxml/Home.fxml");
VentanasFX.goTo("Home");
~~~
