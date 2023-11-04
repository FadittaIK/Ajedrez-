package DamasChinas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosDamas;
import model.Casilla;
import model.Jugador;
import piezas.Pieza;

import model.Color;

public class DamasChinas extends Pieza {

    private Movimeintos movimientosDamasChinas = new MovimientosDamas();

    public DamasChinas(int posicionXInicial, int posicionYInicial, Jugador turno, Color color) {
        super(posicionXInicial, posicionYInicial, turno, color);

    }



    @Override
    public int maximoMovimentos() {
        return 1;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        return movimientosDamasChinas.movimientosPosibles(x, y, casillas, this);
    }
}
