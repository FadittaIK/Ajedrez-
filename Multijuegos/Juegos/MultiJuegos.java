package Juegos;

import model.Casilla;
import piezas.Pieza;

public  interface  MultiJuegos {//lo que tiene todos los juegos en comun
    Casilla[][] inicializaCasillas();
    boolean  verificarVictoria(int x, int y, Casilla[][] casillas, Pieza tipo);


}
