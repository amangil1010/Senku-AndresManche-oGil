package es.amangil.proyecto_tablero_senku;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FichaHueco extends Group{ 
    
    static final double TAM_FICHA = 50;
    
    public FichaHueco (){
        
        //Creacion de del circulo hueco
        Circle circuloExterior = new Circle();
        circuloExterior.setRadius(TAM_FICHA / 2);
        circuloExterior.setFill(Color.BLACK);
        circuloExterior.setCenterX(0);
        circuloExterior.setCenterY(0);
        this.getChildren().addAll(circuloExterior);
    }
    
}
