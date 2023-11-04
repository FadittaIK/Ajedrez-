package piezas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosCaballo;
import model.Casilla;
import model.Jugador;

import model.Color;

public class Caballo extends Pieza {
   private Movimeintos movimientosCaballo =new MovimientosCaballo();


    public Caballo(int posicionInicialX, int posicionInicialy, Jugador turno, Color color) {
        super(posicionInicialX, posicionInicialy, turno, color);

    }

    public void setTipoDePieza(Pieza tipoDePieza) {
        this.setTipoDePieza(tipoDePieza);
    }



    @Override
    public int maximoMovimentos() {
        return 2;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        return  movimientosCaballo.movimientosPosibles(x,y,casillas,this);
    }

}
