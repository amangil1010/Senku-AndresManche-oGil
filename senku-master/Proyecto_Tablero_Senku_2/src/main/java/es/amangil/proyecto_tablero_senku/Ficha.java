package es.amangil.proyecto_tablero_senku;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ficha extends Group {
    static final double TAM_FICHA = 50;
    double posX;
    double posY;
    
    public Ficha (){
        //Creo la ficha exterior
        Circle fichaExterior = new Circle();
        fichaExterior.setRadius(TAM_FICHA / 2);
        fichaExterior.setCenterX(0);
        fichaExterior.setCenterY(0);
        fichaExterior.setFill(Color.DARKORANGE);
        fichaExterior.setStroke(Color.DARKGRAY);
        
        //Creo la ficha interior
        Circle fichaInterior = new Circle();
        fichaInterior.setRadius(TAM_FICHA / 2 - 5);
        fichaInterior.setCenterX(0);
        fichaInterior.setCenterY(0);
        fichaInterior.setFill(Color.ORANGE);
        fichaInterior.setStroke(Color.LIGHTGRAY);
        
        this.getChildren().addAll(fichaExterior, fichaInterior);
    }
    
    
    public void movimientoPosX(double posX) {
       this.posX = posX;
       this.setLayoutX(this.posX);
    }
    
    public void movimientoPosY(double posY) {
       this.posY = posY;
       this.setLayoutY(this.posY);
    }
}
