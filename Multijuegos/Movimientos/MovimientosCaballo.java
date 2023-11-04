package Movimientos;

import model.Casilla;
import piezas.Pieza;

public class MovimientosCaballo implements Movimeintos{
    private final int MINIMO = 1;
    private int maximoMovimientos = 2;
    public boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo){

        int distanciaX = Math.abs(tipo.getPosicionXActual() - x);
        int distanciaY = Math.abs(tipo.getPosicionYActual() - y);


        /*
         * 11  0  13
         * 0   0  0
         * 0  32  0
         * 0  0  0
         * 51 0  53
         *
         * Math.abs(3 - 1) = 2   Math.abs(3 - 5) = 2 && Math.abs(2 -1 ) = 1 Math.abs(2 -3 ) = 1
         * */
        boolean movimientoArribaOAbajo = distanciaX == maximoMovimientos && distanciaY == MINIMO;

        /*
         * 0  0   0  0  0
         * 20 0   0  0  24
         * 0  0  32  0  0
         * 40 0   0  0  44
         * 0  0   0  0  0
         *
         * Math.abs(3 - 2) = 1   Math.abs(3 - 4) = 1 && Math.abs(2 - 0 ) = 2 Math.abs(2 - 4) = 2
         * */
        boolean movimientoIzquierdaODerecha = distanciaY == maximoMovimientos && distanciaX == MINIMO;


        return (movimientoArribaOAbajo || movimientoIzquierdaODerecha);

    }
}
