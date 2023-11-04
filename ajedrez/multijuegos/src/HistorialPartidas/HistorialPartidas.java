package HistorialPartidas;

import Juegos.*;
import piezas.Pieza;

public class HistorialPartidas {
    private int posicionInicialX;
    private int posicionInicialY;
    private  int posicionFinX;

    private int posicionFinY;
    private Pieza tipoDePieza;

    private MultiJuegos tipoDeJuego;

    public HistorialPartidas(int posicionInicialX, int posicionInicialY, int posicionFinX, int posicionFinY, Pieza tipoDePieza,MultiJuegos tipoDeJuego) {
        this.posicionInicialX = posicionInicialX;
        this.posicionInicialY = posicionInicialY;
        this.posicionFinX = posicionFinX;
        this.posicionFinY = posicionFinY;
        this.tipoDePieza = tipoDePieza;
        this.tipoDeJuego = tipoDeJuego;
    }
    public int getPosicionInicialX() {
        return posicionInicialX;
    }

    public int getPosicionInicialY() {
        return posicionInicialY;
    }

    public int getPosicionFinX() {
        return posicionFinX;
    }

    public int getPosicionFinY() {
        return posicionFinY;
    }

    public Pieza getTipoDePieza() {
        return tipoDePieza;
    }
    public MultiJuegos getTipoDeJuego() {
        return tipoDeJuego;
    }
}
