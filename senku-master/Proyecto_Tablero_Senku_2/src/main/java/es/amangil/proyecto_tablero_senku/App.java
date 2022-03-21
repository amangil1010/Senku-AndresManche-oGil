package es.amangil.proyecto_tablero_senku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    BorderPane paneRoot;

    @Override
    public void start(Stage stage) {
        
        short tamXPantalla = 640;
        short tamYPantalla = 480;
        
        paneRoot = new BorderPane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        
        //
        Senku senku = new Senku();
        senku.mostrarTableroConsola();
        senku.mostrarTableroConsola();
        Tablero tablero = new Tablero(senku);
        MensajeVictoria mensajevictoria = new MensajeVictoria();
        
        paneRoot.setCenter(tablero);
        paneRoot.setBottom(mensajevictoria);
//        senku.ganarPartida();
        
        HBox paneScores = new HBox();
        Reset reset = new Reset();
        paneScores.getChildren().add(reset.boton);
        reset.crearBoton();
        paneRoot.getChildren().add(paneScores);
        reset.codigoBoton();
    }

    public static void main(String[] args) {
        launch();
    }

}