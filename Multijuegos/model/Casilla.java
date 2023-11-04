package model;

import piezas.Pieza;

public class Casilla {

    private Pieza pieza;
    private Terminal terminal;
    private Color colorCasilla;
    public Casilla(){
        this.pieza = null;//las casillas que no tiene pieza son null
        this.terminal = new Terminal();
    }


    public Color getColorCasilla() {
        return colorCasilla;
    }

    public void setColorCasilla(Color colorCasilla) {
        this.colorCasilla = colorCasilla;
    }


    public boolean tienePiezaRey() {
        //si la casilla tiene la pieza Rey
        Pieza pieza = getPieza();
        return pieza != null && pieza.esRey();
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {

        this.pieza = pieza;//para llamar a la referencia del objeto otra vez y nos permite acceder a los metodos de la Clase pieza
    }
    public char getValorVacio() {
        return terminal.getValorVacio();
    }


}
