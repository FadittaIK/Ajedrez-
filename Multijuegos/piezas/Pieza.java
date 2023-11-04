package piezas;

import model.Casilla;
import model.Color;
import model.Jugador;
import model.Terminal;

import java.util.ArrayList;
import java.util.List;

public abstract  class Pieza {

    Terminal terminal ;

    private Color color;
    private int posicionXActual;
    private int posicionYActual;

    private Jugador turno;
    private  String nombre;
    public List<Pieza> piezasCapturdas;

    public Pieza(int posicionXInicial, int posicionYInicial, Jugador turno, Color color) {
        this.posicionXActual = posicionXInicial;
        this.posicionYActual = posicionYInicial;
        this.turno = turno;
        this.color = color;
        this.terminal = new Terminal();
        this.piezasCapturdas = new ArrayList<>();
    }

    public Jugador getTurno() {
        return turno;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Color getColor() {
        return color;
    }

    public int getPosicionXActual() {
        return posicionXActual;
    }

    public void setPosicionXActual(int posicionXActual) {
        this.posicionXActual = posicionXActual;
    }

    public int getPosicionYActual() {
        return posicionYActual;
    }

    public void setPosicionYActual(int posicionYActual) {
        this.posicionYActual = posicionYActual;
    }


    public void realizarMovimiento(Casilla[][] casillas, int horizontal, int vertical, Jugador jugador, List<Pieza> piezasCapturdas){


            boolean esUnaPosicionVacia = casillas[horizontal][vertical].getPieza() == null;
            boolean esUnaPiezaDelRival =   !esUnaPosicionVacia && casillas[horizontal][vertical].getPieza().getColor() != jugador.getColor();
            if (esUnaPosicionVacia || esUnaPiezaDelRival) {
                if (esUnaPiezaDelRival){
                    this.piezasCapturdas.add(casillas[horizontal][vertical].getPieza());
                }
                //borrar la pieza de su posicion actual
                casillas[getPosicionXActual()][getPosicionYActual()].setPieza(null);
                //cambiar las coordenadas
                setPosicionXActual(horizontal);
                setPosicionYActual(vertical);
                //mover la misma  pieza a la posicion nueva
                casillas[horizontal][vertical].setPieza(this);
            }else {
                terminal.invalidPiezaParaCapturar();
            }
    }



    public boolean esRey() {
        return false;
    }

    public boolean esUnGato(){
        return false;
    }

    public boolean esUnRaton(){
        return false;
    }

    public boolean isHayUnGanador() {
        return false;
    }
    public void borrarPieza(int x,int y , Casilla[][] casillas){
        casillas[x][y].setPieza(null);
    }

    public abstract int maximoMovimentos();
   public abstract boolean sePuedeMover(int x, int y, Casilla[][] casillas);


}
