package Damas;

import Juegos.Logica;
import Juegos.MultiJuegos;
import model.Casilla;
import model.Color;
import model.Tablero;
import piezas.Pieza;

public class DamasLogica implements MultiJuegos {
    private Tablero tablero;

    Logica logica = new Logica(this);


    public DamasLogica() {
        this.tablero = new Tablero();
        this.logica.inicializarJuegos(inicializaCasillas());

    }



    @Override
    public Casilla[][] inicializaCasillas() {


        tablero.inicializarTablero();
        //Damas de arriba
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tablero.getCasillas().length ; j++) {
                if (tablero.getCasillas()[i][j].getColorCasilla() == Color.NEGRO) {
                    tablero.getCasillas()[i][j].setPieza(new Dama(i, j, logica.getJugadores()[0], Color.BLANCO));
                }
            }
        }
        //Damas de abajo
        for (int i = 5; i < tablero.getCasillas().length; i++) {
            for (int j = 0; j < tablero.getCasillas().length; j++) {
                if (tablero.getCasillas()[i][j].getColorCasilla()  == Color.NEGRO) {
                    tablero.getCasillas()[i][j].setPieza(new Dama(i, j, logica.getJugadores()[1], Color.NEGRO));

                }
            }
        }

        return tablero.getCasillas();
    }

    @Override
    public boolean verificarVictoria(int x, int y, Casilla[][] casillas, Pieza tipoPieza) {
        int piezasBCapturadas = 0;
        int piezasNCapturadas = 0;
        for (int i = 0; i < tipoPieza.piezasCapturdas.size();i++){
            if (tipoPieza.piezasCapturdas.get(i).getColor() == Color.BLANCO){
                piezasBCapturadas++;

            }else {
                piezasNCapturadas++;
            }
            System.out.println( "pieza capturada "+tipoPieza.piezasCapturdas.get(i).getColor());

        }

        //si no encuentra ninguna pieza blanca/negra significa que un jugador ha ganado
        return piezasBCapturadas == 0 || piezasNCapturadas == 0;
    }
}