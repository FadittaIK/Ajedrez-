package Movimientos;

import model.Casilla;
import piezas.Pieza;

public class MovimientosAlfil implements Movimeintos{



    //Alfil posibles movimientos
    public boolean movimientosPosibles(int x, int y, Casilla[][] casillas, Pieza tipo){


        if (casillas[x][y].getPieza() != null){
            return true;


            //si estan en la diagonalSegundaria se suman 2+2 = 4+0
        }else if (tipo.getPosicionXActual() + tipo.getPosicionYActual() == x + y){
            return verificarDiagonalSegundaria(x,y,casillas,tipo);
        }
        //si estan en la diagonalPrincipal la resta siempore es 0 4-4 = 2-2
        else if (tipo.getPosicionXActual() - tipo.getPosicionYActual() ==  x - y){
            return verficarDiagonalPrincipal(x,y,casillas,tipo);
        }

        return false;
    }

    //torre
    private boolean verficarDiagonalPrincipal(int x, int y, Casilla[][] casillas,Pieza tipo) {

        int direccionXY = tipo.getPosicionXActual() < x ? 1 : -1;//calculamos la distancia si se va incrementar o descrementar
        //como que la x y 'y' se incrementan a la vez solo he puesto una variable
        if (direccionXY == -1){// si la casilla esta arriba va a restar -1
            while ( direccionXY > x){// la posicion xy esta arriba a la izquierda
                //posicion inicial 22 destinacion 00 direccion -1 2-1 2-1 --> 11
                if (casillas[tipo.getPosicionXActual()+direccionXY][tipo.getPosicionYActual()+direccionXY].getPieza() != null){
                    return  false;
                }
                direccionXY--;

            }return true;
        }else {
            while ( direccionXY < x ){//la posicion xy esta abajo a la derecho
                //posicion inicial 22 destinacion 44 dierccionXY = 1 2+1 2+1 -> la casilla intermedia es 33
                if (casillas[tipo.getPosicionXActual()+direccionXY][tipo.getPosicionYActual()+direccionXY].getPieza() != null){
                    return  false;
                }
                direccionXY++;
            }return true;
        }
    }

    public boolean verificarDiagonalSegundaria(int x, int y, Casilla[][] casillas, Pieza tipo) {
        //arriba a la derecha  04
        int casillaX = (x < y) ? -1 : 1;
        int casillaY = (x < y) ? 1: -1;
        // 22 2-1 2+1


        int posX = tipo.getPosicionXActual() + casillaX;
        int posY = tipo.getPosicionYActual() + casillaY;

        if (casillaX == -1) {// la casilla esta arriba a la derecha 04 0 < 4 casillaX = -1
            while (posY < y && posX < x) {
                if (casillas[posX][posY].getPieza() != null) {
                    return false;
                }
                posY++;
                posX--;
            }
        } else {
            //esta abajo a la izquierda
            while (posY > y && posX > x) {
                if (casillas[posX][posY].getPieza() != null) {
                    return false;
                }
                posY--;
                posX++;
            }
        }
        return true;
    }

}



