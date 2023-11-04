package Damas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosDamas;
import model.Casilla;
import model.Color;
import model.Jugador;
import piezas.Pieza;

public class Dama extends Pieza {


    private Jugador jugador;
    private int casillaX;
    private int casillaY;
    private Movimeintos movimientosDamas = new MovimientosDamas();


    public Dama(int posicionXInicial, int posicionYInicial, Jugador jugador, Color color) {
        super(posicionXInicial, posicionYInicial, jugador, color);

    }


    @Override
    public int maximoMovimentos() {
        return 1;
    }


    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {

        return movimientosDamas.movimientosPosibles(x, y, casillas, this);
    }


}
