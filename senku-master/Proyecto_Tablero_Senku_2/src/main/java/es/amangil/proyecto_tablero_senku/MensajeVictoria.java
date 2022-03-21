package es.amangil.proyecto_tablero_senku;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MensajeVictoria extends StackPane{
    
    Label labelVictoria = new Label();
    
    public void mostrarVictoria() {
        //label
        labelVictoria.setText("Has Ganado");
        labelVictoria.setLayoutX(250);
        labelVictoria.setLayoutY(600);
//        labelVictoria.setVisible(false);
        this.getChildren().add(labelVictoria);
        
    }
}
