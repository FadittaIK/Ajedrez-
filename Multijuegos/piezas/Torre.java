package piezas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosTorre;
import model.Casilla;
import model.Jugador;

import model.Color;

public class Torre extends Pieza {
    private Movimeintos movimientosTorre = new MovimientosTorre();


    public Torre(int posicionInicialX, int posicionInicialy, Jugador turno, Color color){
        super(posicionInicialX,posicionInicialy,turno,color);

    }


    @Override
    public int maximoMovimentos() {
        return 7;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
       return movimientosTorre.movimientosPosibles(x,y,casillas,this);
    }

}
