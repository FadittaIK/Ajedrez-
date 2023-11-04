package Movimientos;

import model.Casilla;
import piezas.Pieza;

public class MovimientosTorre implements Movimeintos{

    //Torre movimientos
    public boolean movimientosPosibles(int x, int y , Casilla[][] casillas, Pieza tipo){

        int distanciaVertical = Math.abs(tipo.getPosicionYActual() - y);
        int distanciaHorizontal = Math.abs(tipo.getPosicionXActual() - x);

        // verificar si el movimiento es vertical o horizontal 22 25 2-2 = 0
        if (distanciaVertical == 0 && distanciaHorizontal > 0 ) {
            return verficarCasillasIntermediasVertical(casillas,x,tipo);
            //verificar si esta en horizontal 11 13
        }else if(distanciaVertical > 0 && distanciaHorizontal == 0) {
            return verficarCasillasIntermdediasHorizontal(casillas,y,tipo);
        }
        return false;
    }

    public boolean verficarCasillasIntermediasVertical(Casilla casillas[][],int posicionXDestino,Pieza tipo){
        if (tipo.getPosicionXActual() < posicionXDestino) {//arriba --> abajo
            //recorre todas las casillas que estan en el medio
            for (int i = tipo.getPosicionXActual() + 1; i < posicionXDestino; i++) {
                if (casillas[i][tipo.getPosicionYActual()].getPieza() != null) {//existe una pieza en una casilla intermedia
                    return false;
                }
            }
        } else if (tipo.getPosicionXActual() > posicionXDestino) {//abajo --> arriba
            for (int i = tipo.getPosicionXActual() - 1; i > posicionXDestino; i--) {
                if (casillas[i][tipo.getPosicionYActual()].getPieza() != null) {//existe una pieza en una casilla intermedia
                    return false;
                }
            }
        }return true;
    }
    public boolean verficarCasillasIntermdediasHorizontal(Casilla casillas[][] ,int posicionYDestino,Pieza tipo){
        //izquierda --> derecha
        if (tipo.getPosicionYActual() < posicionYDestino) {
            for (int i = tipo.getPosicionYActual() + 1; i < posicionYDestino; i++) {
                if (casillas[tipo.getPosicionXActual()][i].getPieza() != null) {//existe una pieza en una casilla intermedia
                    return false;
                }
            }
            //derecha --> izquierda
        } else if (tipo.getPosicionYActual() > posicionYDestino) {
            for (int i = tipo.getPosicionYActual() - 1; i > posicionYDestino; i--) {
                if (casillas[tipo.getPosicionXActual()][i].getPieza() != null) {//existe una pieza en una casilla intermedia
                    return false;
                }
            }
        }return true;//todas las casillas entre las dos posiciones tienen el valor null
    }
}
