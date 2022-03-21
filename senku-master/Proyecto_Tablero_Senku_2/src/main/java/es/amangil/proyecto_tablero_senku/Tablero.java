package es.amangil.proyecto_tablero_senku;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Tablero extends GridPane{
    Senku senku;
    int contador = 0;
    int filaXOrigen;
    int columnaYOrigen;
    int filaXDestino;
    int columnaYDestino;
    
    //Aqui la ventana se calcula mediante el tamaño de la ficha por el amaño del tablero por si lo queremos ampliar en un futuro
    public Tablero(Senku senku) {
        this.senku = senku;
        this.setBackground(new Background(
            new BackgroundFill(Color.DARKSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinWidth((Ficha.TAM_FICHA + 1) * senku.tamXTablero);
        this.setMinHeight((Ficha.TAM_FICHA + 1) * senku.tamYTablero); 
        this.setMaxWidth((Ficha.TAM_FICHA + 1) * senku.tamXTablero);
        this.setMaxHeight((Ficha.TAM_FICHA + 1) * senku.tamYTablero);
        
        //Recibimos la posicion cuando clikeemos
        this.setOnMouseClicked((event) -> {
            contador += 1;
            int filaX = (int)(event.getX() / Ficha.TAM_FICHA);
            int columnaY = (int)(event.getY() / Ficha.TAM_FICHA);
            System.out.println("X " + filaX);
            System.out.println("Y " + columnaY);
            System.out.println("contador " + contador);
            if (contador ==1){
                filaXOrigen = filaX;
                columnaYOrigen = columnaY;
                
                senku.ganarPartida();
                
                System.out.println("filaXOrigen " + filaXOrigen);
                System.out.println("columnaYOrigen " + columnaYOrigen);
            }
            if (contador ==2){
                filaXDestino = filaX;
                columnaYDestino = columnaY;
                
                senku.ganarPartida();
                
                System.out.println("filaXDestino " + filaXDestino);
                System.out.println("columnaYDestino " + columnaYDestino);
                senku.movimientoFicha((short) filaXOrigen, (short) columnaYOrigen, (short) filaXDestino, (short) columnaYDestino);
                senku.mostrarTableroConsola();
                limpiarTablero();
                pintarTablero ();
                contador = 0;
                System.out.println("contador es 0? " + contador);
            }
            System.out.println("------------------------------------------------");
        });
        
        senku.mostrarTableroConsola();
        
        // COLOCAR FICHAS
        for(int x=0; x<7; x++) {
            for(int y=0; y<7; y++) {
//                System.out.println("hola");
//                senku.mostrarTableroConsola();
                if (senku.tablero[x][y] == '2' ){
//                System.out.println("HOLA");
//                senku.mostrarTableroConsola();
                Ficha ficha = new Ficha();
                this.add(ficha, x, y);
                }
                if (senku.tablero[x][y] == '1' ){
//                System.out.println("hola");
//                senku.mostrarTableroConsola();
                FichaHueco fichaHueco = new FichaHueco();
                this.add(fichaHueco, x, y);
                
                }
            }
        }
    }
        
    //Cuando llamemos a este metodo se quitara todo las fichas del tablero
    public void limpiarTablero (){
        while ( this.getChildren().size() > 0 ) {
            for (int x=0; x<this.getChildren().size(); x++){
                this.getChildren().remove(x);            

            }
        }
    }
    
    //Pintamos el tablero 
    public void pintarTablero (){
        for(int x=0; x<7; x++) {
            for(int y=0; y<7; y++) {
//                System.out.println("hola");
//                senku.mostrarTableroConsola();
                if (senku.tablero[x][y] == '2' ){
//                System.out.println("HOLA");
//                senku.mostrarTableroConsola();
                Ficha ficha = new Ficha();
                this.add(ficha, x, y);
                }
                if (senku.tablero[x][y] == '1' ){
//                System.out.println("hola");
//                senku.mostrarTableroConsola();
                FichaHueco fichaHueco = new FichaHueco();
                this.add(fichaHueco, x, y);
                
                }
            }
        }
    }
    }
        




