package DamasChinas;

import Juegos.Logica;
import Juegos.MultiJuegos;
import model.Casilla;
import model.Color;
import model.Tablero;
import piezas.Pieza;

public class DamasChLogica  implements MultiJuegos {

    private Tablero tablero;

    Logica logica;


    public DamasChLogica() {
        this.tablero = new Tablero();
        this.logica  = new Logica(this);
        this.logica.inicializarJuegos(inicializaCasillas());
    }

    @Override
    public Casilla[][] inicializaCasillas() {
        tablero.inicializarTablero();
        for (int i = 5; i < tablero.getCasillas().length; i++) {
            for (int j = 0; j <= 2; j++) {
                tablero.getCasillas()[i][j].setPieza(new DamasChinas(i, j, logica.getJugadores()[1], Color.BLANCO));
            }
        }
        //piezas negras
        for (int i = 0; i < 3; i++) {
            for (int j = 5; j < tablero.getCasillas()[i].length; j++) {
                tablero.getCasillas()[i][j].setPieza(new DamasChinas(i, j, logica.getJugadores()[0], Color.NEGRO));
            }
        }
        return tablero.getCasillas();
    }



    @Override
    public boolean verificarVictoria(int x, int y, Casilla[][] casillas, Pieza tipoPieza) {
        boolean hayPiezasBlancas = true;
        boolean hayPiezasNegras = true;

        //piezas de abajo
        for (int i = 5; i < casillas.length; i++) {
            for (int j = 0; j < 3; j++) {
                Pieza pieza = casillas[i][j].getPieza();
                //si las piezas negras llegar abajo todas no va a entrar a ese for
                if (pieza != null && pieza.getColor() != Color.NEGRO) {

                    hayPiezasBlancas = false;
                }
            }
        }

        // Piezas negras
        for (int i = 0; i < 3; i++) {
            for (int j = 5; j < casillas.length; j++) {
                Pieza pieza = casillas[i][j].getPieza();
                if (pieza != null && pieza.getColor() != Color.BLANCO) {
                    hayPiezasNegras = false;
                }
            }
        }

        return hayPiezasBlancas || hayPiezasNegras;
    }
}


