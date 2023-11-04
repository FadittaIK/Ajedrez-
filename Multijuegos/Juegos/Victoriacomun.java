package Juegos;

import model.Casilla;
import piezas.Pieza;
import piezas.Rey;

public interface Victoriacomun {
// verificar victorio en ajedrez y soldados del rey es el mismo metodo
    //static para no poder acceder al metodo sin usar la instancia de la interfaz
    static boolean verificarVictoriacomun(int x, int y , Casilla[][] casillas, Pieza tipo){
        int alUltimaPiezaCapturada = tipo.piezasCapturdas.size()-1;
        if ( tipo.piezasCapturdas.size() != 0){
            return tipo.piezasCapturdas.get(alUltimaPiezaCapturada) instanceof Rey;
        }
       return false;
        /*for (int i = 0; i < tipo.piezasCapturdas.size();i++){
            if (tipo.piezasCapturdas.get(i) instanceof Rey){
                return true;
            }
        }*/
    }
}
