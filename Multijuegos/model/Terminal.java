package model;

import Damas.Dama;
import DamasChinas.DamasChinas;
import GatosYRaton.Gato;
import GatosYRaton.Raton;
import piezas.*;

import java.util.Scanner;

public class Terminal {


    private Pieza pieza;
    Scanner sc = new Scanner(System.in);
    private char valorVacio = ' ';
    public void  pintarTablero(Casilla[][] casillas){

        System.out.print(" ");
        for (char letra = 'a'; letra < 'i'; letra++) {
            System.out.print("  "+letra + "");
        }
        System.out.println();
        for (int i = 0; i < casillas.length;i++){
            System.out.print(i+"  ");
            for (int j = 0; j < casillas.length;j++){
                //para diferenciar las piezas negras/blancas
                Pieza pieza1 = casillas[i][j].getPieza();
                if (pieza1 != null){
                    asignarNombresAPiezas(pieza1);

                    if (pieza1.getColor() == Color.BLANCO) {
                        System.out.print("[" + casillas[i][j].getPieza().getNombre() + "]");
                    }else{
                        System.out.print("[" + pieza1.getNombre() + "]");
                    }
                }else if (pieza1 == null){
                    System.out.print("[" + casillas[i][j].getValorVacio() + "]");

                }

            }
            System.out.println();

        }
        System.out.print("  ");
        for (char letra = 'a'; letra < 'i'; letra++) {
            System.out.print("  "+letra + "");
        }
        System.out.println();
    }
    public char getValorVacio() {
        return valorVacio;
    }



    public void bienvenida(){
        System.out.println("Bienvenido a MultiJuegos ");
        System.out.println("Elige un Juego:");
        System.out.println("   1- Ajedrez");
        System.out.println("   2- Damas");
        System.out.println("   3- Soldados del Rey");
        System.out.println("   4- Gatos y Raton");
        System.out.println("   5- Damas Chinas");
    }
    public void asignarNombresAPiezas(Pieza pieza){

        String colorPieza = pieza.getTurno().getColor() == Color.BLANCO ? "\u001B[35m": "\u001B[34m";
        String cerrarElColor =  "\u001B[0m";

        if (pieza instanceof Torre){
            pieza.setNombre(colorPieza+"T"+cerrarElColor);
        }else
        if (pieza instanceof Alfil){
            pieza.setNombre(colorPieza+"A"+cerrarElColor);
        }else
        if (pieza instanceof Rey){
            pieza.setNombre(colorPieza+"R"+cerrarElColor);
        }else
        if (pieza instanceof Reina){
            pieza.setNombre(colorPieza+"Q"+cerrarElColor);
        }else
        if (pieza instanceof  Peon){
            pieza.setNombre(colorPieza+"P"+cerrarElColor);
        }else
        if (pieza instanceof Caballo ){
            pieza.setNombre(colorPieza+"C"+cerrarElColor);
        }else
        if (pieza instanceof Dama){
            pieza.setNombre(colorPieza+"D"+cerrarElColor);
        }else
        if (pieza instanceof DamasChinas){
            pieza.setNombre(colorPieza+"C"+cerrarElColor);
        }else
        if (pieza instanceof Gato){
            pieza.setNombre(colorPieza+"G"+cerrarElColor);
        }else
        if (pieza instanceof Raton){
            pieza.setNombre(colorPieza+"R"+cerrarElColor);
        }
    }

    public int seleccionaUnJuego(){
        return sc.nextInt();
    }
    public void invalidValor(){
        System.out.println("El valor introducido no es valido");
    }


    public void turnoDeJugador(Jugador numeroJugador){
        System.out.println("El Jugador "+ numeroJugador.getColor());
    }

    public void introducirCoordenadas(){
        System.out.println("Introduce una posicion Entero[0-7] char[a-h] por ejemplo 1e");
    }

    public int[] pedirCoordenadas() {
        int columna = 0;
        int filaEntero = 0;
        int[] coordenadas = new int[2];
        boolean posicionValida = false;
        while (!posicionValida) {
            try {
                String entrada = sc.next();
                filaEntero = (int) entrada.charAt(0) - '0' ;// para obtener el valor int de la fila  '2'- -'0'  [50-48] =  2
                columna = entrada.charAt(1) - 'a';//para obtener el valor int de la letra introducida  por ejemplo 'c' -'a' (99-97) = 2

                posicionValida = true;

            } catch (Exception e) {
                System.out.println("el valor introducido debe ser un Entero[0-7] char[a-h] ");
                System.out.println("    --------------------");
                System.out.println("Introduce otro valor:");
                sc.next();//para extraer los valores introducidos invalidos  hasta que se encuentra un salto de linea [y limpiar la linea]
            }
        }
        coordenadas[0] = filaEntero;
        coordenadas[1] = columna;
        return coordenadas;
    }

    public void moverPiezaInvalida(Jugador color){
        System.out.println("Debes mover las piezas de color "+color);
    }
    public void invalidPosicion(){
        System.out.println("no se puede mover la pieza a esta posicion");
        System.out.println("  --------------------");
    }

    public void invalidPiezaParaCapturar() {
        System.out.println("  ------------------");
        System.out.println("No puedes Capturar tus piezas");
    }

    public void victoria(Jugador jugador){
        System.out.println("Ha ganado el jugador "+ jugador.getColor());
    }
}
