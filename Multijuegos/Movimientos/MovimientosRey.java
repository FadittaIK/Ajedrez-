package Movimientos;

import model.Casilla;
import piezas.Pieza;

public class MovimientosRey implements Movimeintos{
    private final int MAX_MOVIMENTS_HORITZONTAL = 1;
    private final int MAX_MOVIMENTS_VERTICALS = 1;
    public  boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo){

        boolean validHoritzontal = Math.abs(y - tipo.getPosicionYActual()) <= tipo.maximoMovimentos();
        boolean validVertical = Math.abs(x - tipo.getPosicionXActual()) <= tipo.maximoMovimentos();
        boolean valid = validVertical && validHoritzontal;

        return valid;
    }

}
