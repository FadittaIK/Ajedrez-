package GatosYRaton;

import Juegos.Logica;
import Juegos.MultiJuegos;
import model.Casilla;
import model.Color;
import model.Tablero;
import piezas.Pieza;

public class GatosYRatonLogica  implements MultiJuegos{
    private Tablero tablero;
    Logica logica = new Logica(this);


    public GatosYRatonLogica() {
        this.tablero = new Tablero();
        this.logica.inicializarJuegos(inicializaCasillas());

    }

    @Override
    public Casilla[][] inicializaCasillas() {
        tablero.inicializarTablero();

        //los gatos
        for (int i = 0 ; i < tablero.getCasillas().length;i++){
            if (tablero.getCasillas()[0][i].getColorCasilla() == Color.NEGRO)
                tablero.getCasillas()[0][i].setPieza(new Gato(0, i, logica.getJugadores()[1], Color.NEGRO));
        }


        //el raton
        tablero.getCasillas()[7][4].setPieza(new Raton(7, 4, logica.getJugadores()[0],Color.BLANCO));


        return tablero.getCasillas();
    }

    @Override
    public boolean verificarVictoria(int destinacioX, int destinacioY, Casilla[][] casillas, Pieza pieza) {
        boolean destinoEsUnRaton = false;

        //el raton gana si llega a la fila 0
        boolean esUnRaton = tablero.getCasillas()[pieza.getPosicionXActual()][pieza.getPosicionYActual()].getPieza().esUnRaton();
        boolean esUnGato = tablero.getCasillas()[pieza.getPosicionXActual()][pieza.getPosicionYActual()].getPieza().esUnGato();

        if (tablero.getCasillas()[destinacioX][destinacioY].getPieza() != null){
            destinoEsUnRaton = tablero.getCasillas()[destinacioX][destinacioY].getPieza().esUnRaton();
        }
        int alUltimaPiezaCapturada = pieza.piezasCapturdas.size()-1;
        if ( pieza.piezasCapturdas.size() != 0){
            if ( pieza.piezasCapturdas.get(alUltimaPiezaCapturada) instanceof Raton)
                return true;
        }


        //los gatos ganan si capturan al raton

        boolean casillaDestinoEsLaPrimeraFila = destinacioX == 0;

        boolean victoriaRaton = esUnRaton && casillaDestinoEsLaPrimeraFila;
        boolean victoriaGatos = esUnGato && destinoEsUnRaton;

        return victoriaRaton /*|| victoriaGatos*/;
    }
}
