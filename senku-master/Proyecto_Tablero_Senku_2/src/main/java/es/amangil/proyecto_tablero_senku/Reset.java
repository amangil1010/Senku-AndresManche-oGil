package es.amangil.proyecto_tablero_senku;

import javafx.scene.control.Button;


public class Reset {
    Senku senku = new Senku();
    Tablero tablero2 = new Tablero(senku);
    Button boton = new Button("Reset");
    static final char FICHAS = '2';
    final char VACIO = '1';
    final char TABLERO = '0';
    char[][] tablero;
    
    public void crearBoton(){
        //Crear boton
        boton.setMinWidth(100);
        boton.setMaxWidth(100);
        boton.setMinHeight(50);
        boton.setMaxHeight(50);
        boton.setTranslateY(10);
        boton.setTranslateX(270);
//        tablero = new char[7][7];    
    }
    
        public void codigoBoton(){
            //Codigo del boton cuando clikees sobre el
            boton.setOnAction(actionEvent -> {
                System.out.println("Boton");
                tablero2.limpiarTablero();
                
            });
        }

            
}
