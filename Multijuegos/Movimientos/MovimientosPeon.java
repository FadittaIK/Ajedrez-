package Movimientos;

import model.Casilla;
import model.Color;
import piezas.Pieza;

public class MovimientosPeon implements Movimeintos{
    private boolean esPrimerMovimiento = false;
    private final int MAXIMO_MOVIMIENTOS_AL_PRINCIPIO = 2;

    public boolean puedeCapturar(int x, int y,int direccionMovimiento,Pieza tipo){

        int direccionCapturar =  (tipo.getColor() == Color.BLANCO) ? tipo.maximoMovimentos() : -tipo.maximoMovimentos();
        int distanciaXDiagonal = tipo.getPosicionXActual() - x;
        int distanciaYDiagonal = tipo.getPosicionYActual() - y;

        //si esta en su diagonal segundaria 11 - 20 -1 1
        boolean validDiagonalX = distanciaXDiagonal == direccionMovimiento ;
        boolean validDiagonalY = distanciaYDiagonal == direccionCapturar;


        //si la pieza esta se su diagonal 11 - 22 -1 -1
        boolean validDiagonalPrincipal = distanciaXDiagonal == direccionMovimiento && distanciaYDiagonal == direccionMovimiento;
        return   validDiagonalY && validDiagonalX || validDiagonalPrincipal;
    }

    @Override
    public boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo) {
        //si es el turno del jugador 1 'blanco'  la resta de su maximoMovimiento seria -1 (10-20)
        int direccionMovimiento = (tipo.getColor() == Color.BLANCO) ? -tipo.maximoMovimentos() : tipo.maximoMovimentos();
        boolean posicionVacia = casillas[x][y].getPieza() == null;
        if (puedeCapturar(x,y,direccionMovimiento,tipo) && !posicionVacia)
            return true;


        //si es el turno del jugador 1 y quiere avanzar dos casillas en su primer movimiento seria -2 [13-33]
        int maxMovimientosAlPrincipio = (tipo.getColor() == Color.BLANCO) ? -MAXIMO_MOVIMIENTOS_AL_PRINCIPIO : MAXIMO_MOVIMIENTOS_AL_PRINCIPIO;


        boolean esSuprimerMoviYCasillaEsNull = esPrimerMovimiento && casillas[x][y].getPieza() == null;
        boolean siSuPrimerMoviLlegaAlMoximo = tipo.getPosicionXActual() - x == maxMovimientosAlPrincipio;
        boolean casillaEsNull = casillas[x][y].getPieza() == null;

        if (!esPrimerMovimiento && casillaEsNull) {//para evitar mover el Peon a una casilla que tiene otra pieza
            if (siSuPrimerMoviLlegaAlMoximo && tipo.getPosicionYActual() == y) {
                esPrimerMovimiento = true;
                return true;
            }
        }
        if (casillaEsNull) {
            //si su primer movimiento ha sido solo un paso cambiamos el valor de la variable 'esPrimerMovimiento' para que no se pueda mover 2 casillas despues
            esPrimerMovimiento = true;
            return ((tipo.getPosicionXActual() - x) == direccionMovimiento && tipo.getPosicionYActual() == y);
        }
        return false;
    }

}

