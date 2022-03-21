package es.amangil.proyecto_tablero_senku;


public class Senku {

    MensajeVictoria mensajevictoria2 = new MensajeVictoria();
    
    short tamXTablero;
    short tamYTablero;
    char[][] tablero;
    
    static final char FICHAS = '2';
    final char VACIO = '1';
    final char TABLERO = '0';
    
    // Método constructor //Logica del juego
    public Senku() {  
        //Creacion del tablero
        tamXTablero = 7;
        tamYTablero = 7;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                tablero[x][y] = FICHAS;
            }
        }
        for(int x=0; x<2; x++){
            for(int y=0; y<2; y++) {
                tablero[x][y] = TABLERO;
            }
        }
        for(int x=5; x<7; x++){
            for(int y=0; y<2; y++) {
                tablero[x][y] = TABLERO;
            }
        }
        for(int x=0; x<2; x++){
            for(int y=5; y<7; y++) {
                tablero[x][y] = TABLERO;
            }
        }
        for(int x=5; x<7; x++){
            for(int y=5; y<7; y++) {
                tablero[x][y] = TABLERO;
            }
        }
        for(int x=3; x<4; x++){
            for(int y=3; y<4; y++) {
                tablero[x][y] = VACIO;
            }
        }
    }
    
    //Creacion del metodo del movimiento donde se le entroducen los datos de destino y origen
    public void movimientoFicha(short movOrigenX, short movOrigenY, short movDestinoX, short movDestinoY) {
        int saltosX = movDestinoX - movOrigenX;
        int saltosY = movDestinoY - movOrigenY;
        boolean saltoDe2X = false;
        boolean saltoDe2Y = false;
        
        System.out.println("saltosX " + saltosX);
        System.out.println("saltosY " + saltosY);
        

        /////////////////////Calcular si es saltoX es igual a dos y que halla una ficha de por medio y que en el destino halla una fichahueco
        if (saltosX==2 && tablero[movDestinoX - 1][movDestinoY] == FICHAS && tablero[movDestinoX][movDestinoY] == VACIO || saltosX==-2 && tablero[movDestinoX + 1][movDestinoY] == FICHAS && tablero[movDestinoX][movDestinoY] == VACIO && saltosY==0)
        {
            saltoDe2X = true;
        } else {
            saltoDe2X = false;
        }
        
        
        ////////////////////
        if (saltosY==2 && tablero[movDestinoX][movDestinoY - 1] == FICHAS  && tablero[movDestinoX][movDestinoY] == VACIO || saltosY==-2 && tablero[movDestinoX][movDestinoY + 1] == FICHAS && tablero[movDestinoX][movDestinoY] == VACIO && saltosX==0)
        {
            saltoDe2Y = true;
        } else {
            saltoDe2Y = false;
        }
        
        //Dibujar en el destino
        if (saltoDe2X==true || saltoDe2Y==true) {
            tablero[movDestinoX][movDestinoY] = FICHAS;
            tablero[movOrigenX][movOrigenY] = VACIO;
            if (movOrigenX < movDestinoX){
                tablero[movOrigenX + 1][movOrigenY] = VACIO;
            } else if (movOrigenY < movDestinoY) {
                tablero[movOrigenX][movOrigenY + 1] = VACIO;
            } else if (movOrigenX > movDestinoX) {
                tablero[movOrigenX - 1][movOrigenY] = VACIO;
            } else if (movOrigenY > movDestinoY) {
                tablero[movOrigenX][movOrigenY - 1] = VACIO;
            }
        }
        
    }

    
    
    
//Mostrat el tablero
    public void mostrarTableroConsola() {
        for(int y=0; y<tamYTablero; y++) {
            for(int x=0; x<tamXTablero; x++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }    
        System.out.println();
    }

//codigo de ganar una partida
    public void ganarPartida() {
        int cantidad = 0;
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                if (tablero[x][y] == FICHAS) {
                    cantidad ++;
                    System.out.println("cantidad: " + cantidad);
                }
            }
        }
        if (cantidad == 1){
            System.out.println("HAS GANADO");
//            mensajevictoria2.mostrarVictoria();
//            mensajevictoria2.labelVictoria.setVisible(true);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}