package GatosYRaton;

import Movimientos.Movimeintos;
import Movimientos.MovimientosGatos;
import model.Casilla;
import model.Jugador;
import piezas.Pieza;

import model.Color;

public class Gato extends Pieza {
   private Movimeintos movimientosGatos = new MovimientosGatos();
    public boolean esUnGato(){
        return true;
    }
    public Gato(int posicionXInicial, int posicionYInicial, Jugador turno, Color color) {
        super(posicionXInicial, posicionYInicial, turno, color);

    }


    @Override
    public int maximoMovimentos() {
        return 1;
    }

    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {
        return movimientosGatos.movimientosPosibles(x,y,casillas,this);
    }
}
