package Movimientos;

import model.Casilla;
import piezas.Pieza;

public class MovimientosGatos implements Movimeintos{
    public boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo){
        boolean direccionX = (tipo.getPosicionXActual() - x ) ==  -tipo.maximoMovimentos(); //00 --> 10 -1 0 siempre x es negative
        boolean direccionY = tipo.getPosicionYActual() -y  == 0; // que sea la misma columna

        return  direccionX  && direccionY;
    }
}
