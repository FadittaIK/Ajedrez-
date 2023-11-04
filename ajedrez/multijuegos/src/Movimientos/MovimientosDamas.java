package Movimientos;

import Damas.Dama;
import DamasChinas.DamasChinas;
import model.Casilla;
import model.Color;
import piezas.Pieza;

public class MovimientosDamas implements Movimeintos{
    private int casillaX;
    private int casillaY;
    private final int MAX_DISTANCIA_CAPTURAR = 2;

    private  boolean piezaIntermedia;


    private int[] coordenadasPiezaIntermedia = new int[2];

    public boolean puedeMoverDama(int x, int y, int direccionMovimiento,Pieza tipo,Casilla[][] casillas) {
        if (casillas[x][y].getPieza() == null) {

            int distanciaXDiagonal = tipo.getPosicionXActual() - x;
            int distanciaYDiagonal = Math.abs(tipo.getPosicionYActual() - y);

            //salta 2 casillas
            // Si es una dama normal, solo puede moverse hacia adelante
            if (tipo instanceof Dama) {

                // si esta en su diagonal secundaria 11 - 20 -1 1
                boolean validDiagonalX = distanciaXDiagonal == direccionMovimiento;

                //igualamos la y para no tener problemas si esta en su diagonal segundaria o principal
                boolean validDiagonalY = distanciaYDiagonal == tipo.maximoMovimentos();


                return validDiagonalY && validDiagonalX;
            }
            //y si es una dama china se  puede mover hacia adelante y hacia atrás
            else if (tipo instanceof DamasChinas) {

                 distanciaXDiagonal = Math.abs(tipo.getPosicionXActual() - x);
                 distanciaYDiagonal = Math.abs(tipo.getPosicionYActual() - y);
                // Si esta en su diagonal secundaria o principal
                boolean validDiagonalX = distanciaXDiagonal == tipo.maximoMovimentos();
                boolean validDiagonalY = distanciaYDiagonal == tipo.maximoMovimentos();

                return validDiagonalY && validDiagonalX;
            }

        } return  false;

    }



    public boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo) {


        boolean posicionVacia = casillas[x][y].getPieza() == null;
        int direccionCapturar = (tipo.getColor() == Color.BLANCO) ? -2 : 2;
        int direccionMovimiento = (tipo.getColor() == Color.BLANCO) ? -tipo.maximoMovimentos() : tipo.maximoMovimentos();

        if (puedeMoverDama(x, y, direccionMovimiento,tipo,casillas))
            return true;

        boolean validColumna = tipo.getPosicionXActual() - x == direccionCapturar;
        // la y si esta en la diagonal segundaria da -1 y si esta en la diagonal principal da 1
        boolean validFila = Math.abs(tipo.getPosicionYActual() - y) ==  MAX_DISTANCIA_CAPTURAR;

        boolean validPosicion = validFila && validColumna;

        int direccionX = (x - tipo.getPosicionXActual()) / 2; // direccion de movimineto en X [posicion actual 22 pos destino 40 4-2 /2 0-2 /2
        int direccionY = (y - tipo.getPosicionYActual()) / 2; //direccion de movimiento en Y
        casillaX = tipo.getPosicionXActual() + direccionX;
        casillaY = tipo.getPosicionYActual() + direccionY;
        this.piezaIntermedia = casillas[casillaX][casillaY].getPieza() != null;

        if (tipo instanceof Dama && piezaIntermedia){
            tipo.piezasCapturdas.add(casillas[casillaX][casillaY].getPieza());

            borrarPieza(casillas,casillaX,casillaY);
            return posicionVacia && piezaIntermedia && validPosicion;
        }
        return posicionVacia  && validPosicion;
    }
    public void borrarPieza(Casilla[][] casillas,int casillaX,int casillaY) {
        casillas[casillaX][casillaY].setPieza(null);
    }

}
