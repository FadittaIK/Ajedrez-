package Juegos;

import HistorialPartidas.HistorialPartidas;
import model.*;
import piezas.Pieza;

import java.util.ArrayList;
import java.util.List;

public class Logica {
    private Jugador[] jugadores;
    private Tablero tablero;
    private Terminal terminal;
    private Jugador jugadorActual;
    private int turno;
    private boolean finalJuego;
    private MultiJuegos tipoDeJuego;
    private List<Pieza> piezasCapturadas;
    private ArrayList<HistorialPartidas> historialMovimientos;


    public Logica(MultiJuegos tipoDeJuego) {
        this.tablero = new Tablero();
        this.terminal = new Terminal();
        this.turno = 0;
        this.tipoDeJuego = tipoDeJuego;
        this.finalJuego = false;
        this.jugadores = new Jugador[2];
        this.jugadores[0] = new Jugador(Color.BLANCO);
        this.jugadores[1] = new Jugador(Color.NEGRO);
        this.jugadorActual = jugadores[0];
        this.historialMovimientos = new ArrayList<>();
        this.piezasCapturadas = new ArrayList<>();
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void inicializarJuegos(Casilla[][] inicializarCasillas) {
        tablero.setCasillas(inicializarCasillas);

        boolean salir = false;

        terminal.pintarTablero(tablero.getCasillas());

        while (!finalJuego) {

            jugadorActual = jugadores[turno % jugadores.length];//solo hay 2 jugadores --> % 2
            terminal.turnoDeJugador(jugadorActual);
            jugar(jugadorActual);
            turno++;

        }
    }


    private void jugar(Jugador jugador) {


        //  para verificar si el jugador ha movido una pieza válida
        boolean piezaMovida = false;


        while (!piezaMovida) {

            int[] cooredanasInicial = pedirCoordenadas();
            int fila = cooredanasInicial[0];
            int columna = cooredanasInicial[1];


            //verficar si las coordenadas existen en el tablero
            if (tablero.existeEnElTablero(fila, columna)) {
                if (esUnaPiezaValida(fila, columna)) {
                    Pieza pieza = tablero.getCasillas()[fila][columna].getPieza();

                    int[] coordenadasDestino = pedirCoordenadas();
                    int destinacionFila = coordenadasDestino[0];
                    int destinacionColumna = coordenadasDestino[1];

                    //verficiar si las coordenadas de destinacion son validas
                    if (tablero.existeEnElTablero(destinacionFila, destinacionColumna)) {

                        if (tipoDeJuego.verificarVictoria(destinacionFila, destinacionColumna, tablero.getCasillas(), pieza)) {
                            terminal.victoria(jugadorActual);//ordinal saca el indice
                            piezaMovida = true;
                            this.finalJuego = true;

                        }

                        if (!pieza.sePuedeMover(destinacionFila, destinacionColumna, tablero.getCasillas())) {
                            terminal.invalidPosicion();
                        } else {
                            //Guardar la posicion inicial y final y la pieza que hizo el movimiento y en que juego
                            HistorialPartidas movimientos = new HistorialPartidas(fila, columna, destinacionFila, destinacionColumna, pieza, tipoDeJuego);
                            agregarMovimiento(movimientos);
                            pieza.realizarMovimiento(tablero.getCasillas(), destinacionFila, destinacionColumna, jugadorActual,piezasCapturadas );
                            terminal.pintarTablero(tablero.getCasillas());
                            piezaMovida = true;
                        }
                    } else {
                        terminal.invalidPosicion();
                    }
                } else {
                    terminal.moverPiezaInvalida(jugadorActual);
                }
            }
        }
    }

    public int[] pedirCoordenadas() {
        terminal.introducirCoordenadas();
        int[] coordenadas = terminal.pedirCoordenadas();
        return coordenadas;

    }

    private boolean esUnaPiezaValida(int fila, int columna) {
        // verificamos si la casilla no es nula
        if (tablero.getCasillas()[fila][columna].getPieza() != null) {
            //verificamos si la pieza que mueve el jugador 'Blanco' es de color blanco
            Pieza pieza = tablero.getCasillas()[fila][columna].getPieza();
            return pieza.getColor() == jugadorActual.getColor();
        }
        return false;
    }
    public void agregarMovimiento(HistorialPartidas movimiento){
        this.historialMovimientos.add(movimiento);
    }

}
