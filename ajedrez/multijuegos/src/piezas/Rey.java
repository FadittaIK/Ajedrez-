package piezas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosRey;
import model.Casilla;
import model.Jugador;

import model.Color;


public class Rey extends Pieza {
   private Movimeintos movimientosRey = new MovimientosRey();


    public Rey(int posicionInicialX, int posicionInicialy, Jugador turno, Color color){
        super(posicionInicialX,posicionInicialy,turno,color);

    }
    public boolean esRey() {
        return true;
    }


    @Override
    public int maximoMovimentos() {
        return 1;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        return movimientosRey.movimientosPosibles(x,y,casillas,this);


    }

}
