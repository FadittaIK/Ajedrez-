package Ajedrez;

import Juegos.MultiJuegos;
import Juegos.MultiJuegosFactory;


public class AjedrezFactory extends MultiJuegosFactory {
    @Override
    public MultiJuegos crearJuego() {

        return new Ajedrez();
    }
}
