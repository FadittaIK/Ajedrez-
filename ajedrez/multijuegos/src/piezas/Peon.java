package piezas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosPeon;
import model.Casilla;
import model.Jugador;

import model.Color;

public class Peon extends Pieza {


    private Movimeintos movimientosPeon = new MovimientosPeon();


    public Peon(int posicionInicialX, int posicionInicialY, Jugador turno, Color color){
        super(posicionInicialX,posicionInicialY,turno,color);


    }

    @Override
    public int maximoMovimentos() {
        return 1;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {

    return movimientosPeon.movimientosPosibles(x,y,casillas,this);

    }

}
