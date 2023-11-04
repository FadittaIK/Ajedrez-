package SoldadosdelRey;

import Juegos.Logica;
import Juegos.MultiJuegos;
import Juegos.Victoriacomun;
import model.Casilla;
import model.Color;
import model.Tablero;
import piezas.Peon;
import piezas.Pieza;
import piezas.Rey;

public class SoldadosdelReyLogica implements MultiJuegos , Victoriacomun {
    private Tablero tablero;

    Logica logica = new Logica(this);


    public SoldadosdelReyLogica() {
        this.tablero = new Tablero();
        this.logica.inicializarJuegos(inicializaCasillas());
    }



    @Override
    public Casilla[][] inicializaCasillas() {
        tablero.inicializarTablero();


        //piezas blancas
        tablero.getCasillas()[0][4].setPieza(new Rey(0, 4, logica.getJugadores()[0], Color.BLANCO));

        for (int i = 0; i < tablero.getCasillas().length; i++) {
            tablero.getCasillas()[1][i].setPieza(new Peon(1, i, logica.getJugadores()[0],Color.BLANCO));

            tablero.getCasillas()[6][i].setPieza(new Peon(6, i, logica.getJugadores()[1], Color.NEGRO));

        }

        // piezas negras
        tablero.getCasillas()[7][4].setPieza(new Rey(7, 4, logica.getJugadores()[1], Color.NEGRO));

        return tablero.getCasillas();
    }

    @Override
    public boolean verificarVictoria(int x, int y, Casilla[][] casillas, Pieza tipo) {

        return Victoriacomun.verificarVictoriacomun(x, y, casillas, tipo);
    }

}


