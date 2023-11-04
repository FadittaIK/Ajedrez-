package GatosYRaton;

import Movimientos.Movimeintos;
import Movimientos.MovimientosAlfil;
import model.Casilla;
import model.Jugador;
import piezas.Pieza;

import model.Color;

public class Raton extends Pieza {
   private Movimeintos movimientosAlfil = new MovimientosAlfil();



    public Raton(int posicionXInicial, int posicionYInicial, Jugador turno, Color color) {
        super(posicionXInicial, posicionYInicial, turno, color);


    }

    public boolean esUnRaton(){
        return true;
    }


    @Override
    public int maximoMovimentos() {
        return 1;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        boolean posicionVacia = casillas[x][y].getPieza() == null;
        return movimientosAlfil.movimientosPosibles(x,y,casillas,this)  && posicionVacia;
    }
}
