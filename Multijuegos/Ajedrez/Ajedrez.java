package Ajedrez;

import Juegos.Logica;
import Juegos.MultiJuegos;
import Juegos.Victoriacomun;
import model.Casilla;
import model.Color;
import model.Tablero;
import piezas.*;


public class Ajedrez  implements MultiJuegos,Victoriacomun{//la logica del juego
    private Tablero tablero;


    Logica logica ;


    public Ajedrez() {
        this.tablero = new Tablero();
        this.logica = new Logica(this);
        this.logica.inicializarJuegos(inicializaCasillas());
    }


    @Override
    public Casilla[][] inicializaCasillas() {
      //  tablero.inicializarTablero();


        for (int fila = 0; fila < tablero.getCasillas().length; fila++) {

            //si las piezas esta en la fila 0 tendran el color blanco
            Color colorFila = (fila == 0) ? Color.BLANCO : Color.NEGRO;

            for (int columna = 0; columna < tablero.getCasillas()[fila].length; columna++) {

                switch (fila) {
                    // las piezas se colocan en la fila 0 y 7 y la fila 1 y 6 son peones
                    case 0:
                    case 7:
                        switch (columna) {
                            //asignamos  dos casillas a la vez
                            case 0, 7 ->
                                    tablero.getCasillas()[fila][columna].setPieza(new Torre(fila, columna, logica.getJugadores()[0], colorFila));
                            case 1, 6 ->
                                    tablero.getCasillas()[fila][columna].setPieza(new Caballo(fila, columna, logica.getJugadores()[0], colorFila));
                            case 2, 5 ->
                                    tablero.getCasillas()[fila][columna].setPieza(new Alfil(fila, columna, logica.getJugadores()[0], colorFila));
                            case 3 ->
                                    tablero.getCasillas()[fila][columna].setPieza(new Reina(fila, columna, logica.getJugadores()[0], colorFila));
                            case 4 ->
                                    tablero.getCasillas()[fila][columna].setPieza(new Rey(fila, columna, logica.getJugadores()[0], colorFila));
                        }
                        break;
                    case 1:
                        //8  peones blancos
                        tablero.getCasillas()[fila][columna].setPieza(new Peon(fila, columna, logica.getJugadores()[0], Color.BLANCO));
                        break;
                    case 6:
                        tablero.getCasillas()[fila][columna].setPieza(new Peon(fila, columna, logica.getJugadores()[1], Color.NEGRO));
                        break;
                }
            }
        }

        return tablero.getCasillas();
    }


    public boolean verificarVictoria(int x, int y, Casilla[][] casillas, Pieza pieza){
        return Victoriacomun.verificarVictoriacomun(x, y, casillas, pieza);
    }

}
