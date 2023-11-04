package piezas;

import Movimientos.Movimeintos;
import Movimientos.MovimientosAlfil;
import Movimientos.MovimientosTorre;
import model.Casilla;
import model.Jugador;

import model.Color;

public class Reina extends Pieza {
   private Movimeintos movimientosAlfil = new MovimientosAlfil();
    private Movimeintos movimientosTorre = new MovimientosTorre();


    public Reina(int posicionInicialX, int posicionInicialy, Jugador turno, Color color){
        super(posicionInicialX,posicionInicialy,turno,color);

    }

    @Override
    public int maximoMovimentos() {
        return 7;
    }



    @Override
    public boolean sePuedeMover(int x, int y, Casilla[][] casillas) {

        boolean verificarVerticalHozizontal = movimientosTorre.movimientosPosibles(x, y, casillas, this);
        boolean verficarDiagonales = movimientosAlfil.movimientosPosibles(x, y, casillas, this);
        //el movimiento de la reina es el movimiento de la Torre + el movimiento del Alfil
        return verificarVerticalHozizontal || verficarDiagonales;

    }

}
