package Movimientos;

import model.Casilla;
import piezas.Pieza;

public interface Movimeintos {
    boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo);
}
