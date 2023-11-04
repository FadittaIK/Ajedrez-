package piezas;


import Movimientos.Movimeintos;
import Movimientos.MovimientosAlfil;
import model.Casilla;
import model.Jugador;

import model.Color;

public class Alfil extends Pieza {
   private Movimeintos movimientosAlfil = new  MovimientosAlfil();


    public Alfil(int posicionInicialX, int posicionInicialy, Jugador turno, Color color){
        super(posicionInicialX,posicionInicialy,turno,color);

    }


    @Override
    public int maximoMovimentos() {
        return 7;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        return movimientosAlfil.movimientosPosibles(x,y,casillas,this);
    }

}
